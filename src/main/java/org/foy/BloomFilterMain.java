package org.foy;

import org.foy.ds.BloomFilter;
import org.foy.io.BufferedReadLine;

import java.io.IOException;


/**
 * 布隆过滤:大概10s左右.
 * <p>
 * User: Foy Lian
 * Date: 2017-06-19
 * Time: 9:09
 */
public class BloomFilterMain {
    public static void main(String[] args) throws IOException {
        double falsePositiveProbability = 0.001;
        int expectedNumberOfElements = 1000 * 1000;
        BloomFilter<String> bloomFilter = new BloomFilter<String>(falsePositiveProbability, expectedNumberOfElements);
        build(bloomFilter);
        String[] tests = {"510105196105161359"
                , "510124190602011436", "510101195605034110", "510108200106114667",
                "510104195503290489" };
        for (String t : tests) {
            find(bloomFilter, t);
        }
    }

    public static void find(BloomFilter filter, String test) {
        long start = System.currentTimeMillis();
        boolean isContain = filter.contains(test);
        long end = System.currentTimeMillis();
        if (isContain) {
            System.out.println("身份证号:" + test + "重复。查询花费时间:" + (end - start) + "ms.");
        } else {
            System.out.println("身份证号:" + test + "不存在。查询花费时间:" + (end - start) + "ms.");
        }
    }

    public static void build(BloomFilter filter) throws IOException {
        long start = System.currentTimeMillis();
        BufferedReadLine bin = new BufferedReadLine();
        while (bin.hasNext()) {
            filter.add(bin.readLine());
        }
        long end = System.currentTimeMillis();
        System.out.println("创建布隆过滤器花费时间:" + (end - start) + "ms.");
    }
}
