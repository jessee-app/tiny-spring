package com.guo.codecraft.tinyioc.context;

import com.guo.codecraft.tinyioc.beans.BeanDefinition;
import com.guo.codecraft.tinyioc.beans.facroty.AbstractBeanFactory;
import com.guo.codecraft.tinyioc.beans.facroty.AutowireCapableBeanFactory;
import com.guo.codecraft.tinyioc.beans.io.ResourceLoader;
import com.guo.codecraft.tinyioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Created by guo on 3/1/2018.
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        //直接全部初始化
        refresh();
    }

    @Override
    protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception {
        //定位bean,然后加载bean
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        //注册bean,这里bean已经加载到虚拟机中，但还没有实例化对象，先不急嘛。
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
