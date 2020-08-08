package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.FeatureProgress;
import com.sopen.landingpageviettel.demo.models.ProgressCircle;
import com.sopen.landingpageviettel.demo.repository.FeatureProgressRepository;
import com.sopen.landingpageviettel.demo.repository.ProgressCircleRepository;
import com.sopen.landingpageviettel.demo.service.ProgressCircleService;
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
    public List<ProgressCircle> getAll() {
        return progressCircleRepository.findAll();
    }

    @Override
    public ProgressCircle getLatest() {
        return progressCircleRepository.findTopByOrderByIdDesc();
    }

    @Override
    public void create(ProgressCircle progressCircle) {
        progressCircleRepository.save(progressCircle);
        List<FeatureProgress> featureProgressList = progressCircle.getFeatureProgressList();
        featureProgressList.forEach(featureProgress -> {
            featureProgress.setProgressCircle(progressCircle);
            // save feature progress
            featureProgressRepository.save(featureProgress);
        });
    }
}
