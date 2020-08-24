package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.PricingComponent;
import com.sopen.landingpageviettel.demo.models.PricingTable;
import com.sopen.landingpageviettel.demo.repository.PricingComponentRepository;
import com.sopen.landingpageviettel.demo.repository.PricingTableRepository;
import com.sopen.landingpageviettel.demo.service.PricingComponentService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class PricingComponentServiceImpl implements PricingComponentService {
    @Autowired
    PricingComponentRepository pricingComponentRepository;

    @Autowired
    PricingTableRepository pricingTableRepository;

    @Override
    public ServiceResult getLatest() {
        PricingComponent pricingComponent = pricingComponentRepository.findTopByOrderByIdDesc();
        return new ServiceResult(pricingComponent, "ok");
    }

    @Override
    public ServiceResult save(PricingComponent pricingComponent) {
        try {
            pricingComponent = savePricingComponentTransaction(pricingComponent);
        } catch (ConstraintViolationException e) {
            return new ServiceResult(e.getCause(), "object field must be not null or empty");
        }
        return new ServiceResult(pricingComponent, "ok");
    }

    @Transactional(
            propagation = Propagation.REQUIRES_NEW
            , rollbackFor = ConstraintViolationException.class
    )
    public PricingComponent savePricingComponentTransaction(PricingComponent pricingComponent) {
        if (pricingComponent.getId() != null) {
            pricingComponent.setId(null);
        }
        pricingComponent = pricingComponentRepository.save(pricingComponent);
        List<PricingTable> pricingTableList = pricingComponent.getPricingTableList();
        for (PricingTable pricingTable : pricingTableList) {
            pricingTable.setId(null);
            pricingTable.setPricingComponent(pricingComponent);
            pricingTableRepository.save(pricingTable);
        }
        return pricingComponent;
    }
}
