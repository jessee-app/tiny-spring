package com.guo.codecraft.tinyioc.beans.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by guo on 3/1/2018.
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }
    @Override
    //根据URL载入输入流
    public InputStream getInputStream() throws Exception {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
