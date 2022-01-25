package com.genius.interview.eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda {

    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.forEach(n -> System.out.println(n));
        // 方法引用
        objects.forEach(System.out::println);
        // 若对参数修改不能使用方法引用
        objects.forEach(n -> System.out.println("数字: " + n));
        // 只能引用final或final局部变量，不能再lambda内修改定义在域外的变量
        List<Integer> integers = Arrays.asList(1, 2, 3);
        int factor = 2;
        integers.forEach(element -> System.out.println(element * factor));
        // 惰性求职方法
        Stream<Integer> integerStream = integers.stream().filter(f -> f.equals(1));
        System.out.println(integerStream);
        // 及早求值方法
        List<Integer> filterIntegers = integers.stream().filter(f -> f.equals(1)).collect(Collectors.toList());
        System.out.println(filterIntegers);
        // stream and parallelStream
        // (MapReduce 本身就是用于并行处理大数据集的软件框架，其处理大数据的核心思想就是大而化小，
        // 分配到不同机器去运行map，最终通过reduce将所有机器的结果结合起来得到一个最终结果，
        // 与MapReduce不同，Stream则是利用多核技术可将大数据通过多核并行处理，而MapReduce则可以分布式的。)
        Stream<Integer> parallel = integers.stream().parallel();
    }

}
