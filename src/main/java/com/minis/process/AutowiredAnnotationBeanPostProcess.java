package com.minis.process;

import com.minis.annoation.Autowired;
import com.minis.core.exception.BeansException;
import com.minis.core.factory.BeanFactory;
import com.minis.factory.AutowireCapableBeanFactory;

import java.lang.reflect.Field;

public class AutowiredAnnotationBeanPostProcess implements BeanPostProcessor{

    private AutowireCapableBeanFactory beanFactory;


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Object result = bean;
        Class<?> clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                boolean isAutowired = field.isAnnotationPresent(Autowired.class);
                if (isAutowired) {
                    String fieldName = field.getName();
                    Object autowiredObj = this.getBeanFactory().getBean(fieldName);
                    try {
                        field.setAccessible(true);
                        field.set(bean, autowiredObj);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }

    private BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(AutowireCapableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
