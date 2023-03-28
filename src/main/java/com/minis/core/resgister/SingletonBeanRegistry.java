package com.minis.core.resgister;

public interface SingletonBeanRegistry {
    void registerSingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);

    boolean containSingleton(String beanName);

    String[] getSingletonNames();

}
