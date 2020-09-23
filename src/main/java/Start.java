import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


/*

    题目可能会涉及到文件操作、二进制操作、大小端、树、关联数组等基本数据结构和操作
    题目相关的材料会使用7z格式的压缩包发出，最终提交的代码也需要使用7z格式进行压缩。请准备并熟悉使用支持7z格式压缩和解压缩的工具
 */


public class Start {

    public static void do_statistics(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            //System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 如果已经遇到过这个字符
                System.out.println(tempchar);

            }
            reader.close();
            // 表示输入文件中共出现过多少种不同的 ASCII 字符


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String ss(String ss) {
        return ss = ss.concat("asd");
    }


    public static void main(String[] args) {

        int a = 100;
        String as = Integer.toBinaryString(a);// 整数的二进制表示，可输出二进制字符串
        //System.out.println(as);
        long b = 200;
        String bs = Long.toBinaryString(b);// 长整数的二进制表示，可输出二进制字符串
        float c = 30.0f;
        int ci = Float.floatToIntBits(c);// 将浮点数的二进制布局解析为整型表示
        int ci2 = Float.floatToRawIntBits(c);// 将浮点数的二进制布局解析为整型表示
        float f2 = Float.intBitsToFloat(a);// 将整型数的布局解析为一个浮点数
        double d = 302.22d;
        Long dl = Double.doubleToLongBits(d);// 将浮点数的二进制布局解析为长整型表示
        Long dl2 = Double.doubleToRawLongBits(d);// 将浮点数的二进制布局解析为长整型表示
        double d2 = Double.longBitsToDouble(b);// 将长整型数的布局解析为一个双精度浮点数

        //do_statistics("./sample.txt");
        String tmpString = "1010";
        int aint = 0010;
        //Byte bb = new Byte(tmpString);
        System.out.println(Integer.toBinaryString(aint));


    }

}
