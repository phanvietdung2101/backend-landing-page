package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.SearchBox;
import com.sopen.landingpageviettel.demo.repository.SearchBoxRepository;
import com.sopen.landingpageviettel.demo.service.SearchBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchBoxServiceImpl implements SearchBoxService {
    @Autowired
    SearchBoxRepository searchBoxRepository;

    @Override
    public List<SearchBox> getAll() {
        return searchBoxRepository.findAll();
    }

    @Override
    public SearchBox getLatest() {
        return searchBoxRepository.findTopByOrderByIdDesc();
    }

    @Override
    public void create(SearchBox searchBox) {
        searchBoxRepository.save(searchBox);
    }
}
