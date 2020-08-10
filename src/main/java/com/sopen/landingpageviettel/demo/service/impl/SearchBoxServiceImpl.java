package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.SearchBox;
import com.sopen.landingpageviettel.demo.repository.SearchBoxRepository;
import com.sopen.landingpageviettel.demo.service.SearchBoxService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchBoxServiceImpl implements SearchBoxService {
    @Autowired
    SearchBoxRepository searchBoxRepository;

    @Override
    public ServiceResult getLatest() {
        SearchBox searchBox = searchBoxRepository.findTopByOrderByIdDesc();
        return new ServiceResult(searchBox,"ok");
    }

    @Override
    public ServiceResult create(SearchBox searchBox) {
        searchBox = searchBoxRepository.save(searchBox);
        return new ServiceResult(searchBox,"ok");
    }
}
