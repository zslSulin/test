package com.min.test.java8.lambda.customer;

import com.min.test.java8.lambda.interfaces.Person;
import org.junit.Test;

import java.util.Comparator;

/**
 * ComparatorsDemo
 *
 * @author zhangsl
 * @date 2018/8/29 13:28
 */
public class ComparatorsDemo {

    @Test
    public void test01() {
        Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2);
        comparator.reversed().compare(p1, p2);
    }
}
