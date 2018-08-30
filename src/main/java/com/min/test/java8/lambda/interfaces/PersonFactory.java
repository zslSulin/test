package com.min.test.java8.lambda.interfaces;

/**
 * PersonFactory
 *
 * @author zhangsl
 * @date 2018/8/29 11:38
 */
@FunctionalInterface
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
