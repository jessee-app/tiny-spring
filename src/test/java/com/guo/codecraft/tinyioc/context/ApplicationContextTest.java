package com.guo.codecraft.tinyioc.context;

import com.guo.codecraft.tinyioc.HelloWorldService;
import org.junit.Test;

/**
 * Created by guo on 3/1/2018.
 */
public class ApplicationContextTest {
    @Test
    public void test() throws Exception {
        //就是把beanfactory封装一下，使调用更加方便。注册，全部初始化。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (com.guo.codecraft.tinyioc.HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

    @Test
    public void testPostBeanProcessor() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc-postbeanprocessor.xml");
        HelloWorldService helloWorldService = (com.guo.codecraft.tinyioc.HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
