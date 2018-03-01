package com.guo.codecraft.tinyioc.aop;

/**
 * Created by guo on 3/1/2018.
 * 切点接口，Class匹配和方法匹配
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
