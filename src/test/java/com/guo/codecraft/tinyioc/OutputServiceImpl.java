package com.guo.codecraft.tinyioc;

/**
 * Created by guo on 3/1/2018.
 */
public class OutputServiceImpl implements OutputService {

    @Override
    public void output(String text) {
        System.out.println(text);
    }
}
