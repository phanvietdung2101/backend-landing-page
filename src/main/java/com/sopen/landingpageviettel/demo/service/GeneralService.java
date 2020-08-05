package com.sopen.landingpageviettel.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GeneralService<E> {
    List<E> findALl();


}
