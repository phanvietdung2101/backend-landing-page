package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.FooterLink;
import com.sopen.landingpageviettel.demo.models.FooterSection;
import com.sopen.landingpageviettel.demo.repository.FooterLinkRepository;
import com.sopen.landingpageviettel.demo.repository.FooterSectionRepository;
import com.sopen.landingpageviettel.demo.service.FooterSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return new ServiceResult(footerSection,"ok");
    }

    @Override
    public ServiceResult create(FooterSection footerSection) {
        footerSectionRepository.save(footerSection);
        List<FooterLink> footerLinkList = footerSection.getFooterLinkList();
        footerLinkList.forEach(footerLink -> {
            footerLink.setFooterSection(footerSection);
            // save footer link
            footerLinkRepository.save(footerLink);
        });
        return new ServiceResult("ok");
    }
}
