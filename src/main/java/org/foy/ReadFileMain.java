package org.foy;

import org.foy.io.BufferedReadLine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Foy Lian
 * Date: 2017-06-20
 * Time: 8:35
 */
public class ReadFileMain {
    public static void main(String[] args) throws IOException {
        build();
    }
    public static void build() throws IOException {//算快的了
        long start = System.currentTimeMillis();
        BufferedReadLine bin = new BufferedReadLine();
        List<String> ss = new ArrayList<String>();
        while (bin.hasNext()) {
            ss.add(bin.readLine());
        }
        long end = System.currentTimeMillis();
        System.out.println("读取全部文件花费:" + (end - start) + "ms.");
    }
}
