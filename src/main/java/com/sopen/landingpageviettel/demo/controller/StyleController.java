package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.models.Style;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import com.sopen.landingpageviettel.demo.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/style/")
public class StyleController extends GeneralController<Style>{
    @Autowired
    StyleService styleService;

    @Override
    @GetMapping("get-latest")
    public ServiceResult getLatest() {
        return styleService.getLatest();
    }

    @Override
    @PostMapping("create")
    public ServiceResult create(@RequestBody Style style) {
        return styleService.save(style);
    }
}
