package com.guo.codecraft.tinyioc;

/**
 * Created by guo on 3/1/2018.
 */
public class HelloWorldServiceImpl implements HelloWorldService {

    private String text;
    private OutputService outputService;

    @Override
    public void helloWorld() {
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
