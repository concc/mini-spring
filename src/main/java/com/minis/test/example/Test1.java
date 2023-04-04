package com.minis.test.example;


import com.minis.context.ClassPathXmlApplicationContext;
import com.minis.core.exception.BeansException;
import com.minis.test.annotation.BaseService;

public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        BaseService baseService = null;
        try {
            baseService = (BaseService)ctx.getBean("baseservice");
        } catch (BeansException e) {
            e.printStackTrace();
        }
        baseService.sayHello();
    }
}