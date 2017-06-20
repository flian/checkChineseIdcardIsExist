package org.foy.io;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Foy Lian
 * Date: 2017-06-19
 * Time: 8:57
 */
public class BufferedReadLine {

    private int bufferSize = 10 * 1024 * 1024;//10M
    private static String filePath = "c:/ids.txt";//测试文件
    private BufferedReader in;

    public BufferedReadLine(String filePath) throws UnsupportedEncodingException, FileNotFoundException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
        in = new BufferedReader(new InputStreamReader(bis, "utf-8"), bufferSize);//10M缓存
    }

    public BufferedReadLine() throws UnsupportedEncodingException, FileNotFoundException {
        this(filePath);
    }

    public boolean hasNext() throws IOException {
        return in.ready();
    }

    public String readLine() throws IOException {
        return in.readLine();
    }
}
