package com.minis.core;

import com.minis.beans.definition.BeanDefinition;
import org.dom4j.Element;

public class XmlBeanDefinitionRender {

    SimpleBeanFactory simpleBeanFactory;

    public XmlBeanDefinitionRender(SimpleBeanFactory simpleBeanFactory) {
        this.simpleBeanFactory = simpleBeanFactory;
    }

    public void loadBeanDefinitions(Resource resource){

        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanId = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanId, beanClassName);
            this.simpleBeanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}
