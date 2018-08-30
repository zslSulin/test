package com.min.test.java8.lambda.interfaces;

/**
 * Converter
 *
 * @author zhangsl
 * @date 2018/8/29 11:21
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
