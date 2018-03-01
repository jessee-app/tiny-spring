package com.guo.codecraft.tinyioc.beans.facroty;

import com.guo.codecraft.tinyioc.beans.BeanDefinition;
import com.guo.codecraft.tinyioc.beans.BeanPostProcessor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by guo on 3/1/2018.
 * 抽象bean工厂
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    //bean工程里维护类的字典，类名+class对象
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    private final List<String> beanDefinitionNames = new ArrayList<String>();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    /**
     * 获取bean的时候，才创建类的实例对象，原来只是保存类名和类的Class对象 。
     * 到这一步会根据Class对象创建类的实例
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("no bean named " + name + "is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            //刚创建的对象，其他什么都没做
            bean = doCreateBean(beanDefinition);
            //初始化bean对象
            bean = initializeBean(bean,name);
            //这里的bean是初始化之后的bean，与刚开始创建的bean不一样。
            beanDefinition.setBean(bean);
        }
        return bean;
    }

    /**
     * 初始化bean，
     *
     * @param bean
     * @param name
     * @return
     * @throws Exception
     */
    protected Object initializeBean(Object bean, String name) throws Exception {
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
        }

        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
        }
        return bean;
    }

    /**
     * 创建bean的实例
     *
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    /**
     * 注册bean，即将类名和定义保存到内存中(map对象）中
     *
     * @param name
     * @param beanDefinition
     * @throws Exception
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(name, beanDefinition);
        //保存一份做准备
        beanDefinitionNames.add(name);
    }

    /**
     * 重新验证一下，以免被GC回收了，如果被回收的话就重新创建类的实例
     */
    public void preInstantiateSingletons() throws Exception {
        for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext(); ) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }

    /**
     * 创建bean并设置bean的引用
     */
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        //这里会创建bean的实例对象
        Object bean = createBeanInstance(beanDefinition);

        //将bean的实例对象设置到beandefinition中去
        beanDefinition.setBean(bean);
        //设置bean的引用的实例对象
        applyPropertyValues(bean, beanDefinition);

        return bean;
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {

    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws Exception {
        this.beanPostProcessors.add(beanPostProcessor);
    }


    /**
     * 根据类型返回beans
     *
     * @param type
     * @return
     * @throws Exception
     */
    public List getBeansForType(Class type) throws Exception {
        List beans = new ArrayList<Object>();
        for (String beanDefinitionName : beanDefinitionNames) {
            if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
                beans.add(getBean(beanDefinitionName));
            }
        }
        return beans;
    }
}
