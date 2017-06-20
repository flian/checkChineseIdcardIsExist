package org.foy;

import org.foy.ds.ArrayLongHash;
import org.foy.io.BufferedReadLine;

import java.io.IOException;


/**
 * 简单数组hash(用long存数据)方法:大概2-3s
 * <p>
 * User: Foy Lian
 * Date: 2017-06-19
 * Time: 9:09
 */
public class ArrayLongHashMain {
    public static void main(String[] args) throws IOException {
        ArrayLongHash arrayLongHash = build();//buffered reader
        //ArrayHash arrayHash = build2(); //
        String[] tests = {"510105196105161359"
                , "510124190602011436", "510101195605034110", "510108200106114667",
                "510104195503290489" };
        for (String t : tests) {
            find(arrayLongHash, t);
        }
    }

    public static void find(ArrayLongHash arrayLongHash, String test) {
        long start = System.currentTimeMillis();
        boolean isContain = arrayLongHash.find(test);
        long end = System.currentTimeMillis();
        if (isContain) {
            System.out.println("身份证号:" + test + "重复。查询花费时间:" + (end - start) + "ms.");
        } else {
            System.out.println("身份证号:" + test + "不存在。查询花费时间:" + (end - start) + "ms.");
        }
    }

    public static ArrayLongHash build() throws IOException {//算快的了
        long start = System.currentTimeMillis();
        ArrayLongHash arrayHash = new ArrayLongHash();
        BufferedReadLine bin = new BufferedReadLine();
        while (bin.hasNext()) {
            arrayHash.addNode(bin.readLine());
        }
        long end = System.currentTimeMillis();
        System.out.println("创建数组hash过滤器花费时间:" + (end - start) + "ms.");
        return arrayHash;
    }

}
