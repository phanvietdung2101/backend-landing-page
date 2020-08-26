package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.Style;
import com.sopen.landingpageviettel.demo.repository.StyleRepository;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import com.sopen.landingpageviettel.demo.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StyleServiceImpl implements StyleService {
    @Autowired
    StyleRepository styleRepository;

    @Override
    public ServiceResult getLatest() {
        Style style = styleRepository.findTopByOrderByIdDesc();
        return new ServiceResult(style, "ok");
    }

    @Override
    public ServiceResult save(Style style) {
        style = styleRepository.save(style);
        return new ServiceResult(style,"ok");
    }
}
