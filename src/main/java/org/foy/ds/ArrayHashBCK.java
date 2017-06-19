package org.foy.ds;

/**
 * 简单hash法(创建对象方式)：大概8-9s
 * User: Foy Lian
 * Date: 2017-06-19
 * Time: 9:44
 */
public class ArrayHashBCK {
    int startDay = 18170619;//开始日期
    int endDay = 20170620;//结算日期
    int hashLen = endDay - startDay + 1;//只考虑近200年的人
    int[] arr = new int[hashLen];
    Node[] list = new Node[hashLen];

    //20160619
    public static class Node {
        public int birthday;
        public String cardNo;
        public Node next = null;
        public Node last = this;
    }

    public ArrayHashBCK() {
        for (int i = 0; i < hashLen; i++) {
            arr[i] = 0;
        }
    }

    private int pos(int birthday) {
        return birthday - startDay;
    }

    public void addNode(String str) {
        Node newNode = createNode(str);
        if (arr[pos(newNode.birthday)] == 0) {
            list[pos(newNode.birthday)] = newNode;
            arr[pos(newNode.birthday)]++;
        } else {
            arr[pos(newNode.birthday)]++;
            list[pos(newNode.birthday)].last.next = newNode;
            list[pos(newNode.birthday)].last = newNode;
        }
    }

    public boolean find(String test) {
        Node newNode = createNode(test);
        if (arr[pos(newNode.birthday)] == 0) {
            return false;
        }
        int i = pos(newNode.birthday);
        Node n = list[i];
        while (n != null) {
            if (n.cardNo.equals(test)) {
                return true;
            }
            n=n.next;
        }
        return false;
    }

    public static Node createNode(String str) {
        Node n = new Node();
        int birthday = 0;
        char[] chars = str.toCharArray();
        for (int i = 6; i < 14; i++) {
            birthday = (birthday * 10 + (chars[i] - '0'));
        }
        n.cardNo = str;
        n.birthday = birthday;
        return n;
    }
}
