package com.sopen.landingpageviettel.demo.service;

public class ServiceResult {
    private Object data;
    private String message;


    public ServiceResult() {
    }

    public ServiceResult(Object data, String message) {
        this.message = message;
        this.data = data;
    }

    public ServiceResult(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
