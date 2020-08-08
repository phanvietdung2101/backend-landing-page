package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.BrandLogo;
import com.sopen.landingpageviettel.demo.models.PartnerClientSection;
import com.sopen.landingpageviettel.demo.repository.BrandLogoRepository;
import com.sopen.landingpageviettel.demo.repository.PartnerClientSectionRepository;
import com.sopen.landingpageviettel.demo.service.PartnerClientSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerClientSectionServiceImpl implements PartnerClientSectionService {
    @Autowired
    PartnerClientSectionRepository partnerClientSectionRepository;

    @Autowired
    BrandLogoRepository brandLogoRepository;

    @Override
    public ServiceResult getLatest() {
        PartnerClientSection partnerClientSection = partnerClientSectionRepository.findTopByOrderByIdDesc();
        return new ServiceResult(partnerClientSection,"ok");
    }

    @Override
    public ServiceResult create(PartnerClientSection partnerClientSection) {
        partnerClientSectionRepository.save(partnerClientSection);
        List<BrandLogo> brandLogoList = partnerClientSection.getBrandLogoList();
        brandLogoList.forEach(brandLogo -> {
            brandLogo.setPartnerClientSection(partnerClientSection);
            // save brand logo
            brandLogoRepository.save(brandLogo);
        });
        return new ServiceResult("ok");
    }
}
