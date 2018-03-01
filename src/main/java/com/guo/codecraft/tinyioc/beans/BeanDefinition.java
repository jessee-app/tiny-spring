package com.guo.codecraft.tinyioc.beans;


/**
 * Created by guo on 3/1/2018.
 * bean的内容及元数据，保存在beanFactory中，包装bean的实体。
 */
public class BeanDefinition {

    private Object bean;

    //类的class信息
    private Class beanClass;

    //类名
    private String beanClassName;

    //保存所有的属性，
    private PropertyValues  propertyValues  = new PropertyValues();

    public BeanDefinition() {

    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;


        try {
            //加载类，并返回class对象
            //这里已经有类的实例来，但是没有引用，怎么可以获取这个引用呢？
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
