package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.FeatureProgress;
import com.sopen.landingpageviettel.demo.models.ProgressCircle;
import com.sopen.landingpageviettel.demo.repository.FeatureProgressRepository;
import com.sopen.landingpageviettel.demo.repository.ProgressCircleRepository;
import com.sopen.landingpageviettel.demo.service.ProgressCircleService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
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
        return new ServiceResult(progressCircle, "ok");
    }

    @Override
    public ServiceResult save(ProgressCircle progressCircle) {
        try {
            progressCircle = saveProgressCircleTransaction(progressCircle);
        } catch (ConstraintViolationException e) {
            return new ServiceResult(e.getCause(), "object field must be not null or empty");
        }
        return new ServiceResult(progressCircle, "ok");
    }

    @Transactional(
            propagation = Propagation.REQUIRES_NEW
            , rollbackFor = ConstraintViolationException.class
    )
    public ProgressCircle saveProgressCircleTransaction(ProgressCircle progressCircle) {
        if (progressCircle.getId() != null) {
            progressCircle.setId(null);
        }
        progressCircle = progressCircleRepository.save(progressCircle);
        List<FeatureProgress> featureProgressList = progressCircle.getFeatureProgressList();
        for (FeatureProgress featureProgress : featureProgressList) {
            featureProgress.setProgressCircle(progressCircle);
            featureProgressRepository.save(featureProgress);
        }
        return progressCircle;
    }
}
