package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.PricingComponent;
import com.sopen.landingpageviettel.demo.models.PricingTable;
import com.sopen.landingpageviettel.demo.repository.PricingComponentRepository;
import com.sopen.landingpageviettel.demo.repository.PricingTableRepository;
import com.sopen.landingpageviettel.demo.service.PricingComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingComponentServiceImpl implements PricingComponentService {
    @Autowired
    PricingComponentRepository pricingComponentRepository;

    @Autowired
    PricingTableRepository pricingTableRepository;

    @Override
    public List<PricingComponent> getAll() {
        return pricingComponentRepository.findAll();
    }

    @Override
    public PricingComponent getLatest() {
        return pricingComponentRepository.findTopByOrderByIdDesc();
    }

    @Override
    public void create(PricingComponent pricingComponent) {
        pricingComponentRepository.save(pricingComponent);
        List<PricingTable> pricingTableList = pricingComponent.getPricingTableList();
        pricingTableList.forEach(pricingTable -> {
            pricingTable.setPricingComponent(pricingComponent);
            // save pricing table
            pricingTableRepository.save(pricingTable);
        });
    }
}
