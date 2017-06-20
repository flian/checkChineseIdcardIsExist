package org.foy;

import org.foy.io.BufferedReadLine;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
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
        buildMappedByteBuffer();
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

    public static void buildMappedByteBuffer() throws IOException {
        long start = System.currentTimeMillis();
        List<String> ss = new ArrayList<String>();
        FileInputStream fis = new FileInputStream("c:/ids.txt");
        FileChannel fc = fis.getChannel();

        MappedByteBuffer mmb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

        byte[] buffer = new byte[(int)fc.size()];
        mmb.get(buffer);

        fis.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(buffer)));

        for (String line = in.readLine(); line != null; line = in.readLine()) {
            // do your processing here...
            ss.add(line);
        }

        in.close();
        long end = System.currentTimeMillis();
        System.out.println("读取全部文件花费:" + (end - start) + "ms.");
    }
}
