package com.genius.interview.basic;

import org.openjdk.jol.info.ClassLayout;

public class ObjectAnalyze {

    public static void main(String[] args) {
        ObjectA objectA = new ObjectA();
        System.out.println(ClassLayout.parseInstance(objectA).toPrintable());
        int[] a = {1};
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }

}
