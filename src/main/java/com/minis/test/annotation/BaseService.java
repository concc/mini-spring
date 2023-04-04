package com.minis.test.annotation;

import com.minis.annoation.Autowired;
import com.minis.test.BaseBaseService;

public class BaseService {

    @Autowired
    private BaseBaseService basebaseservice;

    public BaseBaseService getBasebaseservice() {
        return basebaseservice;
    }

    public void setBasebaseservice(BaseBaseService basebaseservice) {
        this.basebaseservice = basebaseservice;
    }

    public BaseService() {
    }

    public void sayHello() {
        System.out.println("Base Service says Hello");
        basebaseservice.sayHello();
    }

}