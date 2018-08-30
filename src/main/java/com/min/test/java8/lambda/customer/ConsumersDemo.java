package com.min.test.java8.lambda.customer;

import com.min.test.java8.lambda.interfaces.Person;
import org.junit.Test;

import java.util.function.Consumer;

/**
 * ConsumersDemo
 *
 * @author zhangsl
 * @date 2018/8/29 13:23
 * @desc 代表了在输入一个参数上需要进行的操作
 */
public class ConsumersDemo {

    @Test
    public void test01() {
        Consumer<Person> greeter = person -> System.out.println("hello, " + person.getFirstName());
        greeter.accept(new Person("Luke", "Skywalker"));
    }
}
