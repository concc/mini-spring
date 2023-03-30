package com.minis.test.impl;

import com.minis.test.AService;
import com.minis.test.BaseService;

public class AServiceImpl implements AService {
    private String name;
    private int level;
    private String property1;
    private String property2;
    private BaseService ref1;

    public AServiceImpl() {
    }
    public AServiceImpl(String name, int level) {
        this.name = name;
        this.level = level;
        System.out.println(this.name + "," + this.level);
    }
    public void sayHello() {
        System.out.println(this.property1 + "," + this.property2);
    }
    // 在此省略property1和property2的setter、getter方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public BaseService getRef1() {
        return ref1;
    }

    public void setRef1(BaseService ref1) {
        this.ref1 = ref1;
    }
}