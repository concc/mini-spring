package com.minis.test;


import com.minis.beans.factory.annotation.Autowired;
import com.minis.web.annoation.Controller;
import com.minis.web.annoation.RequestMapping;

@Controller
public class HelloWorldBean {

    @Autowired
    IAction action;

    public HelloWorldBean() {
    }

    @RequestMapping("/test1")
    public String doTest1(UserVo userVo) {
        System.out.println("receive number : " + userVo.getId());
        return "test 1, hello world!";
    }
    @RequestMapping("/test2")
    public String doTest2() {
        return "test 2, hello world!";
    }

    @RequestMapping("/testaop")
    public String doTestAop() {
        action.doAction();
        return "1111";
    }

}