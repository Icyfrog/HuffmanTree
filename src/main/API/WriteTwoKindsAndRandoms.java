import java.io.*;
import java.util.Random;
public class WriteTwoKindsAndRandoms {

    public void randomTest() {
        System.out.println( Math.random() );   // (0 <= random < 1.0)

        Random r = new Random();//（方法一）先生成一个对象 r，

        int b= r.nextInt(10);   //调用 r 对象下面的nextInt，生成0～10之间的随机数，将结果传给 b
        System.out.println(b);//输出随机数 b


        int a = (int) (Math.random()*10); //（方法二） 调用Math.random(), 生成 [0,1)之间的数， 乘以10，结果就变为[0,10), 然后进行强制类型转换，将结果传给 a
        System.out.println(a);  //输出随机数 a
    }

    public static void FuGai() throws IOException {
        FileOutputStream fos=new FileOutputStream("/home/icyfrog/Documents/output.out");
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            Integer b = r.nextInt(10);
            fos.write((b.toString() + "  ").getBytes());
        }
        fos.close();
    }

    public static void XuXie() {
        FileWriter fw;
        try {
            fw = new FileWriter("/home/icyfrog/Documents/output.out",true);
            //写入换行
            fw.write("\n");// Linux/Unix平台下用\n
            //续写一个hello world!
            for (int i = 0; i < 10; i++) {
                Integer b  = (int) (Math.random()*100 + 100);
                fw.write(b.toString() + "  ");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                String[] buff = tempString.split("  ");
                for (int i = 0; i < buff.length; i ++) {
                    System.out.println(buff[i]);
                }
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //
        FuGai();
        XuXie();
        readFileByLines("/home/icyfrog/Documents/output.out");

        //File folders = new File("/home/icyfrog/Documents/one/two/three/main");
        //folders.mkdirs(); //在java中用mkdir只能创建一个，mkdirs可以创建多级目录

        File folders = new File("/home/icyfrog/Documents/one");
        folders.mkdir(); //在java中用mkdir只能创建一个，mkdirs可以创建多级目录
    }
}
