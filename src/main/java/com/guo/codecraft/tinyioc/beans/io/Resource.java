package com.guo.codecraft.tinyioc.beans.io;

import java.io.InputStream;

/**
 * Created by guo on 3/1/2018.
 * Resource是Spring内部定位资源接口
 */
public interface Resource {
    InputStream getInputStream() throws Exception;
}
