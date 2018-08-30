package com.min.test.java8.stream;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * ProcessOrderDemo
 *
 * @author zhangsl
 * @date 2018/8/30 14:19
 */
public class ProcessOrderDemo {

    @Test
    public void test01() {
        System.out.println("filter");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                });

        System.out.println("fileter print");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach" + s));


        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMath: " + s);
                    return s.startsWith("A");
                });

    }
}
