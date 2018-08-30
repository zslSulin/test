package com.min.test.java8.lambda.customer;

import org.junit.Test;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * PredicatesDemo
 *
 * @author zhangsl
 * @date 2018/8/29 13:12
 * @desc 布尔型函数
 */
public class PredicatesDemo {

    @Test
    public void test01() {
        Predicate<String> predicate = s -> s.length() > 0;
        predicate.test("foo");
        predicate.negate().test("foo");

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }

    @Test
    public void test02() {
        Predicate<Boolean> nonNull = Objects::nonNull;
    }
}
