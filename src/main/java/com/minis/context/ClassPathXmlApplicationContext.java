package com.minis.context;


import com.minis.core.ClassPathXmlResource;
import com.minis.core.SimpleBeanFactory;
import com.minis.core.XmlBeanDefinitionRender;
import com.minis.core.even.ApplicationEvent;
import com.minis.core.even.ApplicationEventPublisher;
import com.minis.core.exception.BeansException;
import com.minis.core.factory.BeanFactory;

public class ClassPathXmlApplicationContext implements BeanFactory, ApplicationEventPublisher {

    SimpleBeanFactory simpleBeanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        ClassPathXmlResource resource = new ClassPathXmlResource(fileName);
        SimpleBeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionRender render = new XmlBeanDefinitionRender(beanFactory);
        render.loadBeanDefinitions(resource);
        this.simpleBeanFactory = beanFactory;
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.simpleBeanFactory.getBean(beanName);
    }

    @Override
    public void registerBean(String beanName, Object object) {
        this.simpleBeanFactory.registerBean(beanName, object);
    }

    @Override
    public Boolean containsBean(String name) {
        return this.simpleBeanFactory.containsBean(name);
    }

    @Override
    public boolean isSingleton(String name) {
        return this.simpleBeanFactory.isSingleton(name);
    }

    @Override
    public boolean isPrototype(String name) {
        return this.simpleBeanFactory.isPrototype(name);
    }

    @Override
    public Class<?> getType(String name) {
        return this.simpleBeanFactory.getType(name);
    }

    @Override
    public void publishEvent(ApplicationEvent event) {

    }
}
