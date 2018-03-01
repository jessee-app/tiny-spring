package com.guo.codecraft.tinyioc.beans;

import com.guo.codecraft.tinyioc.beans.BeanDefinitionReader;
import com.guo.codecraft.tinyioc.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guo on 3/1/2018.
 * 从配置文件中读取BeanDifinition 抽象类
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    //bean集合
    private Map<String,BeanDefinition> registry;

    //资源加载器
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
