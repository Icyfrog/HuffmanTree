/**
 * 学号：516051910027
 * 姓名：苑齐超
 */

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

// 方法一   Sort by count: largest in head
class SortCharByCount implements Comparator<CharRecord> {
    @Override
    public int compare(CharRecord o1, CharRecord o2) {
        if (o1.getCount() > o2.getCount() || (o1.getCount().equals(o2.getCount()) && o1.getKeyword() < o2.getKeyword())) {
            return -1;
        }
        else return 1;
    }

    // 方法2  lambda
    private void sort() {
        List<String> list = new ArrayList<>();
        list.add("51003");
        list.add("510020");
        list.add("");
        list.add(null);
        list.add("510060");
        list.sort((o1, o2) -> {
            if (o1 == null || o2 == null) {
                return -1;
            }
            if (o1.length() > o2.length()) {
                return 1;
            }
            if (o1.length() < o2.length()) {
                return -1;
            }
            if (o1.compareTo(o2) > 0) {
                return 1;
            }
            if (o1.compareTo(o2) < 0) {
                return -1;
            }
            if (o1.compareTo(o2) == 0) {
                return 0;
            }
            return 0;
        });

    }
}


public class Huffman {

    static Set<Character> characterSet = new HashSet<>();
    static List<CharRecord> freqTable = new ArrayList<>();
    static CharRecord huffmanTree = new CharRecord();
    static Map<Character, String> codingTable = new HashMap<>();
    static List<LeafNode> huffmanList = new ArrayList<>();


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
                if (characterSet.contains((char) tempchar)) {
                    for (CharRecord charRecord : freqTable) {
                        if (charRecord.getKeyword() == (char) tempchar) {
                            charRecord.addCount(1);
                            break;
                        }
                    }
                }
                // 如果没有遇到过
                else {
                    characterSet.add((char) tempchar);
                    CharRecord charRecord = new CharRecord((char) tempchar, 1);
                    freqTable.add(charRecord);
                }

            }
            reader.close();
            // 表示输入文件中共出现过多少种不同的 ASCII 字符
            System.out.println(characterSet.size());

            // 根据出现次数 重排序
            freqTable.sort(new SortCharByCount());
            // 文件中出现次数最多的三个字符和它们的出现个数
            for (int i=0; i<3; i++) {
                System.out.println(freqTable.get(i).getKeyword()+ " " + freqTable.get(i).getCount());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void build_tree() {
        while (freqTable.size() > 1) {
            freqTable.sort((o1, o2) ->
            {
                if (o1.getCount() < o2.getCount() || (o1.getCount().equals(o2.getCount()) && o1.getKeyword() < o2.getKeyword())) {
                    return -1;
                }
                else
                    return 1;
            });
            CharRecord father = new CharRecord();
            CharRecord leftChild = freqTable.get(0);
            CharRecord rightChild = freqTable.get(1);
            if (leftChild.getKeyword() < rightChild.getKeyword())
                father.setKeyword(leftChild.getKeyword());
            else
                father.setKeyword(rightChild.getKeyword());
            father.setCount(leftChild.getCount() + rightChild.getCount());
            father.setLeft(leftChild);
            father.setRight(rightChild);
            freqTable.add(father);
            freqTable.remove(1);
            freqTable.remove(0);
        }
        // 根据出现次数 重排序
        huffmanTree = freqTable.get(0);
        // todo: check the length!
        System.out.println(getHeight(huffmanTree));
    }

    public static int getHeight(CharRecord root) {
        if (root.getLeft() == null) {
            return 0;
        }
        else {
            return (Integer.max(getHeight(root.getRight()), getHeight(root.getLeft())) + 1);
        }
    }

    // output the valid bit first
    public static void compress(String zip, String txt) throws FileNotFoundException {

        StringBuilder allBit = new StringBuilder();
        File file = new File(txt);
        Reader reader = null;

        PrintStream printStream = new PrintStream(zip);

        try {
            //System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                //System.out.println((char) tempchar);
                char c = (char) tempchar;
                String huffmancode = codingTable.get(c);
                allBit.append(huffmancode);
            }
            reader.close();

            int byteNum = (allBit.length()-1) / 8;
            //System.out.println(byteNum);
            int zeroNum = 8- (allBit.length() - byteNum * 8);
            //System.out.println(zeroNum);
            byteNum++;
            for (int i = 0; i < zeroNum; i++) {
                allBit = new StringBuilder(allBit.toString().concat("0"));
            }


            byte[] bytes = new byte[byteNum];
            for (int i = 0; i < byteNum; i++) {
                String tmpString = allBit.substring(i*8,(i+1)*8);
                //System.out.println(tmpString);
                bytes[i] = (byte) Integer.parseInt(tmpString,2);
            }

            printStream.println(bytes);
            printStream.close();
            System.out.println(allBit.length() - zeroNum);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void getWayOneByOne(CharRecord root, String way) {
        if (root.getLeft() == null) {

            codingTable.put(root.getKeyword(), way);
        }
        else {
            getWayOneByOne(root.getLeft(), way.concat("0"));
            getWayOneByOne(root.getRight(), way.concat("1"));
        }
    }

    public static void encode(String idx) throws FileNotFoundException {
        getWayOneByOne(huffmanTree, "");
        // sort the codingTable
        for (Character c : codingTable.keySet()) {
            LeafNode leafNode = new LeafNode(c, codingTable.get(c));
            huffmanList.add(leafNode);
        }

        huffmanList.sort((o1, o2) -> {
            if (o1.getC() < o2.getC())
                return -1;
            else
                return 1;
        });

        PrintStream printStream = new PrintStream(idx);

        for (LeafNode leafNode : huffmanList) {
            printStream.println(leafNode.getC() + " " + leafNode.getHuffmanCode());
        }

        printStream.close();
        System.out.println(codingTable.get('e'));
    }


    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner((System.in));
        String ins = sc.nextLine();
        String[] inputs = ins.split(" ");
        //System.out.println(inputs.length);
        String txt = inputs[0];
        String idx = inputs[1];
        String zip = inputs[2];

        do_statistics("./" + txt);
        build_tree();
        encode(idx);
        compress(zip, txt);

/*
        do_statistics("./sample.txt");
        build_tree();
        encode("./sample.huffidx");
        compress("./sample.huffzip");

 */
    }
}
