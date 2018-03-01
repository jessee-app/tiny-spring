package com.guo.codecraft.tinyioc.aop;

import org.aopalliance.aop.Advice;

/**
 * Created by guo on 3/1/2018.
 */
public interface Advisor {
    //获取通知事件
    Advice getAdvice();
}
