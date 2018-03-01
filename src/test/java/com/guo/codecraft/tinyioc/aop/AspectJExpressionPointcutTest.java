package com.guo.codecraft.tinyioc.aop;

import com.guo.codecraft.tinyioc.HelloWorldService;
import com.guo.codecraft.tinyioc.HelloWorldServiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guo on 3/1/2018.
 */
public class AspectJExpressionPointcutTest {
    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(* com.guo.codecraft.tinyioc.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* com.guocodecraft.tinyioc.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"),HelloWorldServiceImpl.class);
        Assert.assertTrue(matches);
    }
}
