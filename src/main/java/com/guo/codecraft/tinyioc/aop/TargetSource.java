package com.guo.codecraft.tinyioc.aop;

/**
 * Created by guo on 3/1/2018.
 */
public class TargetSource {


    //类的Class对象
    private Class<?> targetClass;

    //类的接口
    private Class<?>[] interfaces;

    //类的实例
    private Object target;

    public TargetSource(Object target, Class<?> targetClass,Class<?>... interfaces) {
        this.target = target;
        this.targetClass = targetClass;
        this.interfaces = interfaces;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }
}
