package com.guo.codecraft.tinyioc.aop;

/**
 * Created by guo on 3/1/2018.
 */
public abstract class AbstractAopProxy implements AopProxy {
    protected AdvisedSupport advised;

    //传入通知事件
    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}
