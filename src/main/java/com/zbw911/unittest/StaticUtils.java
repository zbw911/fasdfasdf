package com.zbw911.unittest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author zhangbaowei
 */
public class StaticUtils {

    private StaticUtils() {
    }

    public static List<Integer> range(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

    public static String name() {
        return "Baeldung";
    }
}