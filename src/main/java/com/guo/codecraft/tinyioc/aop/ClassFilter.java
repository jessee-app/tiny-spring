package com.guo.codecraft.tinyioc.aop;

/**
 * Created by guo on 3/1/2018.
 * 匹配Class实例
 */
public interface ClassFilter {
    boolean matches(Class targetClass);
}
