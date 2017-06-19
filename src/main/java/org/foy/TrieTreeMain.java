package org.foy;

import org.foy.ds.TrieTree;
import org.foy.io.BufferedReadLine;

import java.io.IOException;


/**
 创建字典树花费时间:22091ms.
 身份证号:510105196105161359重复。查询花费时间:0ms.
 身份证号:510124190602011436不存在。查询花费时间:0ms.
 身份证号:510101195605034110重复。查询花费时间:0ms.
 身份证号:510108200106114667重复。查询花费时间:0ms.
 身份证号:510104195503290489重复。查询花费时间:0ms.

 * User: Foy Lian
 * Date: 2017-06-19
 * Time: 9:09
 */
public class TrieTreeMain {
    public static void main(String[] args) throws IOException {
        TrieTree tree = build();
        String[] tests = {"510105196105161359"
                , "510124190602011436", "510101195605034110", "510108200106114667",
                "510104195503290489" };
        for (String t : tests) {
            find(tree, t);
        }
    }

    public static void find(TrieTree tree, String test) {
        long start = System.currentTimeMillis();
        int cnt = tree.findCount(tree.root, test);
        long end = System.currentTimeMillis();
        if (cnt > 0) {
            System.out.println("身份证号:" + test + "重复。查询花费时间:" + (end - start) + "ms.");
        } else {
            System.out.println("身份证号:" + test + "不存在。查询花费时间:" + (end - start) + "ms.");
        }
    }

    public static TrieTree build() throws IOException {
        long start = System.currentTimeMillis();
        TrieTree tree = new TrieTree();
        TrieTree.TrieTreeNode root = tree.new TrieTreeNode();
        tree.root = root;
        BufferedReadLine bin = new BufferedReadLine();
        while (bin.hasNext()) {
            tree.createTrie(root, bin.readLine());
        }
        long end = System.currentTimeMillis();
        System.out.println("创建字典树花费时间:" + (end - start) + "ms.");
        return tree;
    }
}
