package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.FeatureProgress;
import com.sopen.landingpageviettel.demo.models.ProgressCircle;
import com.sopen.landingpageviettel.demo.repository.FeatureProgressRepository;
import com.sopen.landingpageviettel.demo.repository.ProgressCircleRepository;
import com.sopen.landingpageviettel.demo.service.ProgressCircleService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressCircleServiceImpl implements ProgressCircleService {
    @Autowired
    ProgressCircleRepository progressCircleRepository;

    @Autowired
    FeatureProgressRepository featureProgressRepository;

    @Override
    public ServiceResult getLatest() {
        ProgressCircle progressCircle = progressCircleRepository.findTopByOrderByIdDesc();
        return new ServiceResult(progressCircle,"ok");
    }

    @Override
    public ServiceResult create(ProgressCircle progressCircle) {
        progressCircle = progressCircleRepository.save(progressCircle);
        List<FeatureProgress> featureProgressList = progressCircle.getFeatureProgressList();
        for (FeatureProgress featureProgress : featureProgressList) {
            featureProgress.setProgressCircle(progressCircle);
            // save feature progress
            featureProgressRepository.save(featureProgress);
        }
        return new ServiceResult(progressCircle,"ok");
    }
}
