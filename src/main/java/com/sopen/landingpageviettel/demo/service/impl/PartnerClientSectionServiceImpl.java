package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.BrandLogo;
import com.sopen.landingpageviettel.demo.models.PartnerClientSection;
import com.sopen.landingpageviettel.demo.repository.BrandLogoRepository;
import com.sopen.landingpageviettel.demo.repository.PartnerClientSectionRepository;
import com.sopen.landingpageviettel.demo.service.PartnerClientSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PartnerClientSectionServiceImpl implements PartnerClientSectionService {
    @Autowired
    PartnerClientSectionRepository partnerClientSectionRepository;

    @Autowired
    BrandLogoRepository brandLogoRepository;

    @Override
    public ServiceResult getLatest() {
        PartnerClientSection partnerClientSection = partnerClientSectionRepository.findTopByOrderByIdDesc();
        return new ServiceResult(partnerClientSection, "ok");
    }

    @Override
    public ServiceResult save(PartnerClientSection partnerClientSection) {
        try {
            partnerClientSection = savePartnerClientSectionTransaction(partnerClientSection);
        } catch (ConstraintViolationException e) {
            return new ServiceResult(e.getCause(), "object field must be not null or empty");
        }
        return new ServiceResult(partnerClientSection, "ok");
    }

    @Transactional(
            propagation = Propagation.REQUIRES_NEW
            , rollbackFor = ConstraintViolationException.class
    )
    public PartnerClientSection savePartnerClientSectionTransaction(PartnerClientSection partnerClientSection) {
        if (partnerClientSection.getId() != null) {
            partnerClientSection.setId(null);
        }
        List<BrandLogo> brandLogoList = partnerClientSection.getBrandLogoList();
        partnerClientSection = partnerClientSectionRepository.save(partnerClientSection);
        for (BrandLogo brandLogo : brandLogoList) {
            brandLogo.setPartnerClientSection(partnerClientSection);
            brandLogoRepository.save(brandLogo);
        }
        return partnerClientSection;
    }
}
