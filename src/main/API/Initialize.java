import java.util.*;

public class Initialize {

    public static void init() {
        /**
         * Map
         */
        Map<Integer, String> map = new HashMap<>();

        /**
         * List
         */

        List<String> stringList = new LinkedList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");

        List<String> stringList2 = new LinkedList<String>(){{
            add("a");
            add("b");
            add("c");
        }};

        List<String> stringList3 = Arrays.asList("a", "b", "c");

        int[] intArray = new int[]{1, 2, 3};
        Integer[] integerArray = new Integer[]{1, 2, 3};

        List<int[] > intArrayList = Arrays.asList(intArray);
        List<Integer> integerList = Arrays.asList(integerArray);
        List<Integer> integerList2 = Arrays.asList(1, 2, 3);

        /**
         * Array
         */
        int[] a = new int[2];   //需要指定数组的长度
        a[0] = 1;
        a[1] = 2;

        int[] a2 = new int[]{1,2,3}; //与第二种方法不同，这里new不需要指定数组的长度，数组长度由其后的初始化操作确定

        int[] b = new int[]{
                new Integer(1),
                new Integer(2),
                3
        };

        /**
         * queue:
         * add         增加一个元索                      如果队列已满，则抛出一个IIIegaISlabEepeplian异常
         * remove   移除并返回队列头部的元素     如果队列为空，则抛出一个NoSuchElementException异常
         * element  返回队列头部的元素              如果队列为空，则抛出一个NoSuchElementException异常
         * offer       添加一个元素并返回true        如果队列已满，则返回false
         * poll         移除并返问队列头部的元素     如果队列为空，则返回null
         * peek       返回队列头部的元素              如果队列为空，则返回null
         * put         添加一个元素                       如果队列满，则阻塞
         * take        移除并返回队列头部的元素
         */
        Queue<String> queue = new LinkedList<String>();

    }
}
