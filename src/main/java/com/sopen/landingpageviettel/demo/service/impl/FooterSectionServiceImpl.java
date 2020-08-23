package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.FooterLink;
import com.sopen.landingpageviettel.demo.models.FooterSection;
import com.sopen.landingpageviettel.demo.repository.FooterLinkRepository;
import com.sopen.landingpageviettel.demo.repository.FooterSectionRepository;
import com.sopen.landingpageviettel.demo.service.FooterSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class FooterSectionServiceImpl implements FooterSectionService {
    @Autowired
    FooterSectionRepository footerSectionRepository;

    @Autowired
    FooterLinkRepository footerLinkRepository;

    @Override
    public ServiceResult getLatest() {
        FooterSection footerSection = footerSectionRepository.findTopByOrderByIdDesc();
        return new ServiceResult(footerSection, "ok");
    }

    @Override
    public ServiceResult save(FooterSection footerSection) {
        try {
            footerSection = saveFooterSectionTransaction(footerSection);
        } catch (ConstraintViolationException e) {
            return new ServiceResult(e.getCause(), "object field must be not null or empty");
        }
        return new ServiceResult(footerSection, "ok");
    }

    @Transactional(
            propagation = Propagation.REQUIRES_NEW
            , rollbackFor = ConstraintViolationException.class
    )
    FooterSection saveFooterSectionTransaction(FooterSection footerSection) {
        if (footerSection.getId() != null) {
            long id = footerSection.getId();
            footerSection.setId(null);
            footerSectionRepository.deleteById(id);
        }
        footerSection = footerSectionRepository.save(footerSection);
        List<FooterLink> footerLinkList = footerSection.getFooterLinkList();
        for (FooterLink footerLink : footerLinkList) {
            footerLink.setFooterSection(footerSection);
            footerLinkRepository.save(footerLink);
        }
        return footerSection;
    }
}
