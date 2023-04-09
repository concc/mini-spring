package com.minis.test;


import com.minis.web.annoation.Controller;
import com.minis.web.annoation.RequestMapping;

@Controller
public class HelloWorldBean {

    public HelloWorldBean() {
    }

    @RequestMapping("/test1")
    public String doTest1() {
        return "test 1, hello world!";
    }
    @RequestMapping("/test2")
    public String doTest2() {
        return "test 2, hello world!";
    }

}