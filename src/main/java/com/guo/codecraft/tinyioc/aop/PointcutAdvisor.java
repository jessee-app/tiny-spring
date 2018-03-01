package com.guo.codecraft.tinyioc.aop;

import com.guo.codecraft.tinyioc.aop.Advisor;

/**
 * Created by guo on 3/1/2018.
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
