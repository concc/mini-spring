package com.minis.core;

import com.minis.beans.definition.BeanDefinition;
import com.minis.beans.definition.BeanDefinitionRegistry;
import com.minis.core.exception.BeansException;
import com.minis.core.factory.BeanFactory;
import com.minis.core.resgister.DefaultSingletonBeanRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory , BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);


    private List beanDefinitionNames = new ArrayList<>();

    public SimpleBeanFactory() {
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object singleton = this.getSingleton(beanName);
        // 如果获取为空，构建出来
        if (null == singleton) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition == null) {
                throw new BeansException("");
            }
            try {
                singleton = Class.forName(beanDefinition.getClassName()).newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            this.registerSingleton(beanName, singleton);
        }
        return singleton;
    }

    @Override
    public Boolean containsBean(String name) {
        return containSingleton(name);
    }

    @Override
    public boolean isSingleton(String name) {
        return this.beanDefinitionMap.get(name).isSingleton();
    }

    @Override
    public boolean isPrototype(String name) {
        return this.beanDefinitionMap.get(name).isPrototype();
    }

    @Override
    public Class<?> getType(String name) {
        return this.beanDefinitionMap.get(name).getClass();
    }

    public void registerBean(String beanName, Object object){
        this.registerSingleton(beanName, object);
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(beanDefinition.getId(), beanDefinition);
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(name, beanDefinition);
        this.beanDefinitionNames.add(name);
        if (!beanDefinition.isLazyInit()) {
            try {
                getBean(name);
            }catch (BeansException e) {

            }
        }
    }

    @Override
    public void removeBeanDefinition(String name) {
        this.beanDefinitionMap.remove(name);
        this.beanDefinitionNames.remove(name);
        this.removeSingleton(name);
    }

    @Override
    public BeanDefinition getBeanDefinition(String name) {
        return this.beanDefinitionMap.get(name);
    }

    @Override
    public boolean containsBeanDefinition(String name) {
        return this.beanDefinitionMap.containsKey(name);
    }
}
