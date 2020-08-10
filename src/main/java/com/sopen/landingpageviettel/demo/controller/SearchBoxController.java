package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.models.SearchBox;
import com.sopen.landingpageviettel.demo.service.SearchBoxService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/search-box-section/")
public class SearchBoxController extends GeneralController<SearchBox> {
    @Autowired
    SearchBoxService searchBoxService;

    @GetMapping("get-latest")
    @Override
    public ServiceResult getLatest() {
        return searchBoxService.getLatest();
    }

    @PostMapping("create")
    @Override
    public ServiceResult create(@RequestBody SearchBox searchBox) {
        return searchBoxService.create(searchBox);
    }
}
