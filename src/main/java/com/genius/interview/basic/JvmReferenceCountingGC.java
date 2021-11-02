package com.genius.interview.basic;

public class JvmReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    // 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否有回收过
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        JvmReferenceCountingGC.testGC();
    }

    public static void testGC() {
        JvmReferenceCountingGC objectA = new JvmReferenceCountingGC();
        JvmReferenceCountingGC objectB = new JvmReferenceCountingGC();
        objectA.instance = objectB;
        objectB.instance = objectA;
        objectA = null;
        objectB = null;

        // 假设在这行发生GC， objectA和objectB是否能被回收
        System.gc();
    }

}
