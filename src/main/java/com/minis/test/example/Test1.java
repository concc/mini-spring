package com.minis.test.example;


import com.minis.context.ClassPathXmlApplicationContext;
import com.minis.core.exception.BeansException;
import com.minis.test.AService;

public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        AService aService = null;
        try {
            aService = (AService)ctx.getBean("aservice");
        } catch (BeansException e) {
            e.printStackTrace();
        }
        aService.sayHello();
    }
}