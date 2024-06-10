package com.minis.beans.factory.support;

import com.minis.beans.BeansException;
import com.minis.beans.factory.FactoryBean;

public class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    protected Class<?> getTypeForFactoryBean(final FactoryBean factoryBean) {
        return factoryBean.getObjectType();
    }

    protected Object getObjectFromFactoryBean(FactoryBean<?> factory, String beanName) {
        Object object = doGetObjectFromFactoryBean(factory, beanName);
        try  {
            object = postProcessObjectFromFactoryBean(object, beanName);
        }catch (BeansException e) {
            e.printStackTrace();
        }
        return object;
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean<?> factory, final String beanName) {
        Object object = null;
        try {
            object = factory.getObject();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    protected Object postProcessObjectFromFactoryBean(Object object, String beanName) throws BeansException {
        return object;
    }

}
