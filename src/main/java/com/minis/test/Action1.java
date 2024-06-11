package com.minis.test;

public class Action1 implements IAction {
    @Override
    public void doAction() {
        System.out.println("action1 do action");
    }

    @Override
    public void doSome() {
        System.out.println("action1 do some");
    }
}
