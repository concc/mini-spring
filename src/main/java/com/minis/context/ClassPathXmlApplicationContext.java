package com.minis.context;


import com.minis.core.ClassPathXmlResource;
import com.minis.core.Resource;
import com.minis.core.XmlBeanDefinitionRender;
import com.minis.core.even.ApplicationEvent;
import com.minis.core.even.ApplicationEventPublisher;
import com.minis.core.exception.BeansException;
import com.minis.core.factory.BeanFactory;
import com.minis.factory.AutowireCapableBeanFactory;
import com.minis.process.AutowiredAnnotationBeanPostProcess;
import com.minis.process.BeanPostProcessor;

import java.util.List;

public class ClassPathXmlApplicationContext implements BeanFactory, ApplicationEventPublisher {

    AutowireCapableBeanFactory beanFactory;

    List<BeanPostProcessor> beanFactoryPostProcessors;

    public ClassPathXmlApplicationContext(String fileName) {
        this(fileName, true);
    }


    public ClassPathXmlApplicationContext(String fileName, boolean isRefresh) {
        Resource resource = new ClassPathXmlResource(fileName);
        AutowireCapableBeanFactory beanFactory = new AutowireCapableBeanFactory();
        XmlBeanDefinitionRender reader = new XmlBeanDefinitionRender(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
        if (isRefresh) {
            try {
                refresh();
            } catch (BeansException e) {
                e.printStackTrace();
            }
        }
    }

    public List<BeanPostProcessor> getBeanFactoryPostProcessors() {
        return this.beanFactoryPostProcessors;
    }

    public void addBeanFactoryPostProcessor(BeanPostProcessor postProcessor) {
        this.beanFactoryPostProcessors.add(postProcessor);
    }

    public void refresh() throws BeansException, IllegalStateException {
        // Register bean processors that intercept bean creation.
        registerBeanPostProcessors(this.beanFactory);
        // Initialize other special beans in specific context subclasses.
        onRefresh();
    }

    private void registerBeanPostProcessors(AutowireCapableBeanFactory beanFactory) {
        beanFactory.addBeanPostProcessor(new AutowiredAnnotationBeanPostProcess());
    }

    private void onRefresh() {
        this.beanFactory.refresh();
    }


    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBean(String beanName, Object object) {
        this.beanFactory.registerBean(beanName, object);
    }

    @Override
    public Boolean containsBean(String name) {
        return this.beanFactory.containsBean(name);
    }

    @Override
    public boolean isSingleton(String name) {
        return this.beanFactory.isSingleton(name);
    }

    @Override
    public boolean isPrototype(String name) {
        return this.beanFactory.isPrototype(name);
    }

    @Override
    public Class<?> getType(String name) {
        return this.beanFactory.getType(name);
    }

    @Override
    public void publishEvent(ApplicationEvent event) {

    }
}
