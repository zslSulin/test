package com.min.test.java8.lambda.customer;

import com.min.test.java8.lambda.interfaces.Converter;

/**
 * LambdaDemoOther
 *
 * @author zhangsl
 * @date 2018/8/29 11:54
 */
public class LambdaDemoOther {
    static int outerStaticNum;
    int outNum;

    void testScops() {
        Converter<Integer, String> converter1 = from -> {
            outNum = 23;
            return String.valueOf(outNum);
        };

        Converter<Integer, String> converter2 = from -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }
}
