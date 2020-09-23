import com.sun.org.apache.regexp.internal.RE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

// Sort by count: largest in head
class SortByCount implements Comparator<Record> {
    @Override
    public int compare(Record o1, Record o2) {
        if (o1.getCount() > o2.getCount()) {
            return -1;
        }
        else if (o1.getCount() < o2.getCount()) {
            return 0;
        }
        else if (o1.getCount() == o2.getCount()) {
            if (o1.getKeyword().compareTo(o2.getKeyword()) < 0) {
                return -1;
            }
        }
        return 0;
    }
}

public class SearchKeyWord {

    static Set<Long> users = new HashSet<>();
    static Map<Long, List<Record>> userKeywordCounts = new HashMap<>();
    static List<Record> ranking = new ArrayList<>();

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
                String[] buff = tempString.split(" ");
                users.add(Long.valueOf(buff[0]));
                //System.out.println("line " + line + ": " + tempString);
                line++;

                // using userKeywordCounts
                // if this is a new user
                if (!userKeywordCounts.containsKey(Long.valueOf(buff[0]))) {
                    Record newRecord = new Record(buff[1],1);
                    List<Record> newList = new LinkedList<>();
                    newList.add(newRecord);
                    userKeywordCounts.put(Long.valueOf(buff[0]), newList);
                }
                // if this is not a new user
                else {
                    List<Record> tmpRecords = userKeywordCounts.get(Long.valueOf(buff[0]));
                    boolean ifOldKeyword = false;
                    // if this is an old keyword
                    for (Record record : tmpRecords) {
                        if (record.getKeyword().equals(buff[1])) {
                            record.setCount(record.getCount()+1);
                            ifOldKeyword = true;
                            break;
                        }
                    }
                    // if this is a new keyword
                    if (!ifOldKeyword) {
                        Record newRecord = new Record(buff[1], 1);
                        tmpRecords.add(newRecord);
                    }
                }
            }
            reader.close();
            System.out.println(line-1 + " " + users.size());
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

    static void ranKeywords() {
        for (Long key : userKeywordCounts.keySet()) {
            List<Record> records = userKeywordCounts.get(key);
            for (Record record : records) {
                for (Record rankingRecord : ranking) {
                    if (rankingRecord.getKeyword().equals(record.getKeyword())) {
                        //rankingRecor
                    }
                }
            }
        }

    }

    public static void main(String[] a) {
        readFileByLines("/home/icyfrog/Documents/demo.txt");
    }
}




