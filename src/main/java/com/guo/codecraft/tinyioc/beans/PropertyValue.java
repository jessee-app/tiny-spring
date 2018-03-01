package com.guo.codecraft.tinyioc.beans;

/**
 * Created by guo on 3/1/2018.
 * 用于bean的属性注入，配置属性？
 */
public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
