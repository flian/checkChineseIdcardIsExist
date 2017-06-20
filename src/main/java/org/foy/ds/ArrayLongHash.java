package org.foy.ds;

/**
 * Created with IntelliJ IDEA.
 * User: Foy Lian
 * Date: 2017-06-19
 * Time: 9:44
 */
public class ArrayLongHash {
    int startDay = 18170619;//开始日期
    int endDay = 20170620;//结算日期
    int hashLen = endDay - startDay + 1;//只考虑近200年的人
    int[] arr = new int[hashLen];//日子标记
    long[][] strs = new long[hashLen][];//同年同月同人生日人的存储数组

    public ArrayLongHash() {
        for (int i = 0; i < hashLen; i++) {
            arr[i] = 0;
        }
    }

    private int pos(int birthday) {
        return birthday - startDay;
    }

    private void addNode(int birthday, long val) {

        int idx = pos(birthday);
        if (arr[idx] == 0) {
            strs[idx] = new long[800];
        }
        strs[idx][arr[idx]++] = val;
    }

    public void addNode(String str) {
        addNode(birthday(str), parseStr(str));
    }

    private long parseStr(String str) {
        if (('X')==(str.charAt(str.length()-1))) {
            //return parseStr(str.substring(0, str.length() - 2)) * 100 + 90;
            //return 510114200109201510L;
            return parseStr(str.substring(0, str.length() - 2)) * 100 + 90;
        }
        return Long.parseLong(str);
        //return 510114200109201510L;
    }

    public boolean find(String test) {
        int birthday = birthday(test);
        long val = parseStr(test);
        int idx = pos(birthday);
        if (arr[idx] == 0) {
            return false;
        }
        int cnt = arr[idx];
        for (int i = 0; i < cnt; i++) {
            if (strs[idx][i] == val) {
                return true;
            }
        }
        return false;
    }

    private static int birthday(String str) {
        int birthday = 0;
        char[] chars = str.toCharArray();
        for (int i = 6; i < 14; i++) {
            birthday = (birthday * 10 + (chars[i] - '0'));
        }
        return birthday;
    }
}
