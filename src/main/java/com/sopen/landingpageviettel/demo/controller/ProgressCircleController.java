package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.models.ProgressCircle;
import com.sopen.landingpageviettel.demo.service.ProgressCircleService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/progress-circle-section/")
public class ProgressCircleController extends GeneralController<ProgressCircle> {
    @Autowired
    ProgressCircleService progressCircleService;

    @GetMapping("get-latest")
    @Override
    public ServiceResult getLatest() {
        return progressCircleService.getLatest();
    }

    @PostMapping("create")
    @Override
    public ServiceResult create(@RequestBody ProgressCircle progressCircle) {
        return progressCircleService.create(progressCircle);
    }
}
