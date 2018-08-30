package com.min.test.java8.lambda.customer;

import com.min.test.java8.lambda.interfaces.Converter;
import com.min.test.java8.lambda.interfaces.Person;
import com.min.test.java8.lambda.interfaces.PersonFactory;
import org.junit.Test;

/**
 * LambdaDemo
 *
 * @author zhangsl
 * @date 2018/8/29 11:23
 */
public class LambdaDemo {

    @Test
    public void test01() {
        Converter<String, Integer> converter = from -> Integer.valueOf(from);
        Integer convert = converter.convert("123");
        System.out.println(convert);
    }

    @Test
    public void test02() {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer convert = converter.convert("123");
        System.out.println(convert);
    }

    @Test
    public void test03() {
        Something something = new Something();
        Converter<String, String> converter = something::startWith;
        String des = converter.convert("java");
        System.out.println(des);
    }

    class Something {
        public String startWith(String src) {
            if (null != src && !"".endsWith(src)) {
                return String.valueOf(src.charAt(0));
            }
            return null;
        }
    }

    @Test
    public void test04() {
        PersonFactory<Person> personPersonFactory = Person::new;
        Person person = personPersonFactory.create("JSON", "FAST");
        String firstName = person.getFirstName();
        String lastName = person.getLastName();
        System.out.println(firstName);
        System.out.println(lastName);
    }

    @Test
    public void test05() {
        int num = 1;
        Converter<Integer, String> converter = from -> String.valueOf(from + num);
        String convert = converter.convert(2);
        System.out.println(convert);
    }

    @Test
    public void test06() {
        int num = 1;
        Converter<Integer, String> converter = from -> String.valueOf(from + num);
        String convert = converter.convert(2);
    }

}
