package com.minis.test;


import com.minis.test.impl.AServiceImpl;

public class BaseBaseService {
    private AServiceImpl as;
    // 省略 getter、setter方法


    public AServiceImpl getAs() {
        return as;
    }

    public void setAs(AServiceImpl as) {
        this.as = as;
    }

    public void sayHello() {
        System.out.println("BaseBaseService say hello");
    }
}