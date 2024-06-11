package com.minis.test;

public class Action2 implements IAction{
    @Override
    public void doAction() {
        System.out.println("action2 do action");
    }

    public void doSome() {
        System.out.println("action2 do some");
    }
}
