import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;


/*

    题目可能会涉及到文件操作、二进制操作、大小端、树、关联数组等基本数据结构和操作
    题目相关的材料会使用7z格式的压缩包发出，最终提交的代码也需要使用7z格式进行压缩。请准备并熟悉使用支持7z格式压缩和解压缩的工具
 */


public class Start {
    public static void main(String[] args) {

        Linear linear = new Linear(8);
        ArrayList<Integer> randsContainer = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i < 15000; i++) {
            randsContainer.add(rand.nextInt(100000));
        }

//        System.nanoTime();
//        获取纳秒级别的时间，可以更精准
        long startTime=System.currentTimeMillis();   //获取开始时间
        // do something
        for (int i = 0; i < randsContainer.size(); i++) {
            linear.set(randsContainer.get(i), randsContainer.get(i));
            if (i==1000) {
                long current = System.currentTimeMillis();
                System.out.println("insert 1000 records: " + (current-startTime) + "ms");
            }
        }
        System.out.print(linear.getS());

    }

}
