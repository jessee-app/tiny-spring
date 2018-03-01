package com.guo.codecraft.tinyioc.aop;


import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by guo on 3/1/2018.
 */
public class JdkDynamicAopProxy extends AbstractAopProxy implements InvocationHandler {

    public JdkDynamicAopProxy(AdvisedSupport advised ) {
        super(advised);
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(),advised.getTargetSource().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //提取拦截的方法
        MethodInterceptor methodInterceptor = (MethodInterceptor) advised.getMethodInterceptor();
        //比较传入的方法和对象的方法是否一致，如果一致则调用传入的方法，
        if (advised.getMethodMatcher() != null
                && advised.getMethodMatcher().matches(method, advised.getTargetSource().getTarget().getClass())) {
            //这里应该是先调用拦截的方法，然后调用原始对象的方法。但是一般括号里的东西不是优先吗？括号里面好像就只有赋值操作而已。
            return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(),method, args));
        } else {
            return method.invoke(advised.getTargetSource().getTarget(), args);
        }
    }


}
