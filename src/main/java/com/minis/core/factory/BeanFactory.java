package com.minis.core.factory;


import com.minis.core.exception.BeansException;

public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    void registerBean(String beanName, Object object);

    Boolean containsBean(String name);

    boolean isSingleton(String name);

    boolean isPrototype(String name);

    Class<?> getType(String name);
}