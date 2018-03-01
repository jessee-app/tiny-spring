package com.guo.codecraft.tinyioc.aop;

import java.lang.reflect.Method;

/**
 * Created by guo on 3/1/2018.
 */
public interface MethodMatcher {
    boolean matches(Method method, Class targetClass);
}
