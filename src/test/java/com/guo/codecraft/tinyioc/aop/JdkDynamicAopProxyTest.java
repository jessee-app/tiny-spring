package com.guo.codecraft.tinyioc.aop;

import com.guo.codecraft.tinyioc.HelloWorldService;
import com.guo.codecraft.tinyioc.HelloWorldServiceImpl;
import com.guo.codecraft.tinyioc.context.ApplicationContext;
import com.guo.codecraft.tinyioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * Created by guo on 3/1/2018.
 */
public class JdkDynamicAopProxyTest {
    @Test
    public void testInterceptor() throws Exception {
        // --------- helloWorldService without AOP，这里是和IOC结合的吧
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();

        System.out.println("-----------分割-----------------------------");



        // --------- helloWorldService with AOP，这里是纯粹的代理模式了
        // 1. 设置被代理对象(Joinpoint)
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldServiceImpl.class,
                HelloWorldService.class);
        //设置原始对象
        advisedSupport.setTargetSource(targetSource);

        // 2. 设置拦截器(Advice)
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        //设置拦截方法
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 3. 创建代理(Proxy)
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        //获取代理类实例，调用代理类的方法时，应该会自动取调用代理类invoke方法。
        HelloWorldService helloWorldServiceProxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();

        // 4. 基于AOP的调用
        helloWorldServiceProxy.helloWorld();

    }
}
