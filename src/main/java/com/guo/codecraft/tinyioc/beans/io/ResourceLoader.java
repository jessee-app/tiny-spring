package com.guo.codecraft.tinyioc.beans.io;

import java.net.URL;

/**
 * Created by guo on 3/1/2018.
 */
public class ResourceLoader {

    //获取资源
    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
