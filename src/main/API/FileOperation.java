import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileOperation {
    public static void main(String[] args) throws IOException {//程序主入口函数，带命令行参数
        function1();
        function2();
    }


    /**
     * 编写一个Java程序对文本文件按行进行读取，每读取一行后显示此行，并统计此行有多少字节，有多少字符并显示统计结果，最后显示总的行数。
     */
    public static void function1() {
        try {//try代码块，当发生异常时会转到catch代码块中
            //读取指定的文件
            BufferedReader in = new BufferedReader(new FileReader("/home/icyfrog/Downloads/demo.txt"));
            String str=null;//定义一个字符串类型变量str
            int i=0;//定义一个整型变量
            while ((str = in.readLine())!= null) {//readLine()方法, 用于读取一行,只要读取内容不为空就一直执行
                i++;
                byte[] bytes=str.getBytes();//获得字节数
                System.out.print("第"+i+"行："+str+"    ");//输出从每一行读取的内容
                System.out.println("第"+i+"行有"+bytes.length+"个字节"+str.length()+"个字符");//输出每一行的字符和字节个数
            }
            System.out.println("该文本共有"+i+"行");//输出总的行数
        } catch (IOException e) {//当try代码块有异常时转到catch代码块
            e.printStackTrace();//printStackTrace()方法是打印异常信息在程序中出错的位置及原因
        }
    }

    /**
     * 编写一个Java程序通过二进制流的方式实现对任何类型文件的复制操作。
     */
    public static void function2() throws IOException {
        FileInputStream fis=new FileInputStream("/home/icyfrog/Downloads/demo.txt");
        //将文件复制到指定路径下
        FileOutputStream fos=new FileOutputStream("/home/icyfrog/Documents/demo.txt");
        byte[] lsy=new byte[fis.available()];//定义字节数组用来当作缓冲区
        fis.read(lsy);//将文件以字节流形式读入缓冲区字节数组
        fos.write(lsy);//从缓冲区字节数组中以字节流形式取出
        fos.close();//关闭读取流
        fis.close();//关闭写入流
        File file=new File("/home/icyfrog/Downloads/demo.txt");//创建文件对象
        if(file.exists()){//if语句的条件，调用exists方法判断文件是否存在
            System.out.println("文件成功复制到指定路径下");//若文件存在，则输出文件存在
        }
        else{//否则
            System.out.println("文件复制失败");//输出文件不存在
        }
    }

}


class Peoples {
    public String name;
    public int id;

    Peoples(String name, int id) {
        this.id = id;
        this.name = name;
    }

    Peoples() {}
}