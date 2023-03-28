package com.minis.test.impl;

import com.minis.test.AService;

public class AServiceImpl implements AService {

    private String name;

    private int level;

    @Override
    public void sayHello() {
        System.out.println("a service 1 say hello");
    }
}
