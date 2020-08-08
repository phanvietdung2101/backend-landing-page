package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.service.ServiceResult;

public abstract class GeneralController<E> {
    public abstract ServiceResult getLatest();
    public abstract ServiceResult create(E e);
}
