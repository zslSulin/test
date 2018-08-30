package com.min.test.java8.lambda.customer;

import com.min.test.java8.lambda.interfaces.Person;
import org.junit.Test;

import java.util.function.Supplier;

/**
 * SuppliersDemo
 *
 * @author zhangsl
 * @date 2018/8/29 13:21
 * @desc 产生一个给定类型的结果(没有入参)
 */
public class SuppliersDemo {

    @Test
    public void test01() {
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();
    }
}
