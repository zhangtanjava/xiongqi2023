package com.example.xiongqi2023.jvm;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    public final static int OUTOFMEMORY = 900000000;

    private String oom;

    private int length;

    StringBuffer tempOOM = new StringBuffer();

    public HeapOOM(int leng) {
        this.length = leng;

        int i = 0;
        while (i < leng) {
            i++;
            try {
                tempOOM.append("a");
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                break;
            }
        }
        this.oom = tempOOM.toString();

    }

    public String getOom() {
        return oom;
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        HeapOOM javaHeapTest = new HeapOOM(OUTOFMEMORY);
        System.out.println(javaHeapTest.getOom().length());
    }


}
