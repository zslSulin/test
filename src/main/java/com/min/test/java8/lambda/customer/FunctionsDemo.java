package com.min.test.java8.lambda.customer;

import org.junit.Test;

import java.util.function.Function;

/**
 * FunctionsDemo
 *
 * @author zhangsl
 * @date 2018/8/29 13:18
 * @desc 接收一个参数,并返回一个单一结果
 */
public class FunctionsDemo {

    @Test
    public void test01() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");
    }
}
