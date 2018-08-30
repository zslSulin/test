package com.min.test.java8.lambda.customer;

import org.junit.Test;

import java.util.Optional;

/**
 * OptionalsDemo
 *
 * @author zhangsl
 * @date 2018/8/29 13:33
 */
public class OptionalsDemo {

    @Test
    public void test01() {
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();
        optional.get();
        optional.orElse("fallback");

        optional.ifPresent(s -> {
            System.out.println(s.charAt(0));
        });
    }
}
