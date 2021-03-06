package com.sopen.landingpageviettel.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface GeneralService<E> {
    ServiceResult getLatest();
    ServiceResult save(E e);
}
