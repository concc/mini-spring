package com.minis.process;

import com.minis.core.exception.BeansException;

public interface BeanPostProcessor {


    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;


    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
