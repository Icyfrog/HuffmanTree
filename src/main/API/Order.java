import java.util.ArrayList;

public class Order {

    /**
     * 冒泡排序
     * @param data    要排序的数组
     * @param reverse 从大到小(false)还是从小到大(ture)
     */
    public static void bubbleSort(int[] data, boolean reverse) {
        if (data.length == 1) {
            return;
        }
        for (int i = 0; i < data.length - 1; i++) {
            int tmp = 0;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (reverse) {  //从小到大(ture)
                    if (data[j] >= data[j+1]) {
                        tmp = data[j];
                        data[j] = data[j +1 ];
                        data[j+1] = tmp;
                    }
                } else {    //从大到小(false)
                    if (data[j] <= data[j+1]) {
                        tmp = data[j+1];
                        data[j+1] = data[j];
                        data[j] = tmp;
                    }
                }
            }
        }
    }

    /**
     * 堆排序
     * @param data    要排序的数组
     * @param reverse 从大到小(false)还是从小到大(ture)
     */
    public static void heapSort(int[] data, boolean reverse) {
        if (data.length == 1) {
            return;
        }
        for (int i = 0; i < data.length; i++) {
            //建堆
            buildHeap(data, 0, data.length -1 - i, reverse);
            int tmp = data[0];
            data[0] = data[data.length - 1 - i];
            data[data.length - 1 - i] = tmp;
        }
    }

    /**
     * 将指定开始和结束段的数据建堆
     * 基本思想：堆排序是一种树形选择排序，是对直接选择排序的有效改进。
     *
     * 　　堆的定义如下：具有n个元素的序列（h1,h2,...,hn),当且仅当满足（hi>=h2i,hi>=2i+1）或（hi<=h2i,hi<=2i+1）(i=1,2,...,n/2)时称之为堆。
     * 在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶元素（即第一个元素）必为最大项（大顶堆）。完全二叉树可以很直观地表示堆的结构。
     * 堆顶为根，其它为左子树、右子树。初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个堆，这时堆的根节点的数最大。
     * 然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。依此类推，直到只有两个节点的堆，并对它们作交换，最后得到有n个节点的有序序列。
     * 从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组成。
     * 一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数　　
     *
     * @param data
     * @param beginIndex
     * @param endIndex
     * @param reverse
     */
    public static void buildHeap(int[] data, int beginIndex, int endIndex, boolean reverse) {
        if (beginIndex >= endIndex) {
            return;
        }
        for (int i = (endIndex + beginIndex - 1) / 2; i >= beginIndex; i--) {
            int cur = i;
            if (reverse) {   //大顶堆,用来从小到大排序
                //发生交换之后需要检查孙子节点,重孙子节点...
                while (2 * cur + 1 <= endIndex) {
                    int biggerChildIndex = 2 * cur + 1;
                    if (biggerChildIndex + 1 <= endIndex) {
                        if (data[biggerChildIndex] < data[biggerChildIndex + 1]) {
                            biggerChildIndex = biggerChildIndex + 1;
                        }
                    }
                    //找到最大子节点,如果比当前节点大,就交换
                    if (data[i] < data[biggerChildIndex]) {
                        int tmp = data[i];
                        data[i] = data[biggerChildIndex];
                        data[biggerChildIndex] = tmp;
                        //准备检查孙子节点
                        cur = biggerChildIndex;
                    } else {
                        break;
                    }
                }
            } else {    //小顶堆,用来从大到小排序
                //发生交换之后需要检查孙子节点,重孙子节点...
                while (2 * cur + 1 <= endIndex) {
                    int samllerChildIndex = 2 * i + 1;
                    if (samllerChildIndex + 1 <= endIndex) {
                        if (data[samllerChildIndex] > data[samllerChildIndex + 1]) {
                            samllerChildIndex = samllerChildIndex + 1;
                        }
                    }
                    //找到最小子节点,如果比当前节点小,就交换
                    if (data[i] > data[samllerChildIndex]) {
                        int tmp = data[i];
                        data[i] = data[samllerChildIndex];
                        data[samllerChildIndex] = tmp;
                        cur = samllerChildIndex;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    /**
     *  插入排序
     * @param data  要排序的数组
     * @param reverse 从大到小(false)还是从小到大(ture)
     */
    public static void insertSort(int[] data, boolean reverse) {
        if (data.length == 1) {
            return;
        }
        int tmp = 0;
        for (int i = 1; i < data.length; i++) {
            tmp = data[i];
            int n = i - 1;
            for (; n >= 0; n--) {
                if (reverse) {   //从小到大排序
                    if (data[n] >= tmp) {
                        data[n + 1] = data[n];  //将大于当前值的数后移一个位置
                    } else {
                        break;
                    }
                } else {    //从大到小排序
                    if (data[n] <= tmp) {
                        data[n + 1] = data[n];  //将小于当前值的数后移一个位置
                    } else {
                        break;
                    }
                }
            }
            data[n+1] = tmp;
        }
    }

    /**
     * 归并排序
     * 基本思想：归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。
     * 然后再把有序子序列合并为整体有序序列。
     * @param data    要排序的数组
     * @param reverse 从大到小(false)还是从小到大(ture)
     */
    public static void mergeSort(int[] data, int left, int right, boolean reverse) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(data, left, mid, reverse);
        mergeSort(data, mid + 1, right, reverse);
        merge(data, left, mid, right, reverse);
    }

    /**
     * 合并已排序好的两段
     * @param data
     * @param left
     * @param mid
     * @param right
     * @param reverse
     */
    public static void merge(int[] data, int left, int mid, int right, boolean reverse) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int n = 0;
        while (i <= mid && j <= right) {
            if (reverse) {  //从小到大
                if (data[i] <= data[j]) {
                    tmp[n++] = data[i++];
                } else {
                    tmp[n++] = data[j++];
                }
            } else {    //从大到小
                if (data[i] <= data[j]) {
                    tmp[n++] = data[j++];
                } else {
                    tmp[n++] = data[i++];
                }
            }
        }
        while (i <= mid) {
            tmp[n++] = data[i++];
        }
        while (j <= right) {
            tmp[n++] = data[j++];
        }
        for (int k = 0; k < tmp.length; k++) {
            data[left + k] = tmp[k];
        }
    }

    /**
     * 快速排序
     * @param data
     * @param left
     * @param right
     * @param reverse 从大到小(false)还是从小到大(ture)
     */
    public static void quickSort(int[] data, int left, int right, boolean reverse) {
        if (left >= right) {
            return;
        }
        int index = getIndex(data, left, right, reverse);
        quickSort(data, left, index - 1, reverse);
        quickSort(data, index + 1, right, reverse);
    }

    /**
     * 将待排序片段调整顺序,获得"中间数据"的正确索引
     * @param data
     * @param left
     * @param right
     * @param reverse 从大到小(false)还是从小到大(ture)
     * @return
     */
    public static int getIndex(int[] data, int left, int right, boolean reverse) {
        int cur = data[left];
        int i = left;
        int j = right;
        while (i < j) {
            if (reverse) {  //从小到大
                while (data[j] > cur && i < j) {
                    --j;
                }
                data[i] = data[j];
                while (data[i] <= cur && i < j) {
                    ++i;
                }
                data[j]=data[i];
            } else {    //从大到小
                while (data[j] < cur && i < j) {
                    --j;
                }
                data[i]=data[j];
                while (data[i] >= cur && i < j) {
                    ++i;
                }
                data[j]=data[i];
            }
        }
        data[i] = cur;
        return i;
    }

    /**
     * 基数排序
     * 基本思想：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。
     * 这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
     * @param data    要排序的数组
     * @param reverse 从大到小(false)还是从小到大(ture)
     */
    public static void jishuSort(int[] data, boolean reverse) {
        if (data.length == 1) {
            return;
        }
        int max = 0;
        for (int i = 0; i < data.length; i++) { //找出最大的数据
            if (max < data[i]) {
                max = data[i];
            }
        }
        System.out.println("the max number is :" + max);
        int radix = 1;
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<ArrayList<Integer>>(10);
        for (int i = 0; i < 10; i++) {
            numbers.add(i, new ArrayList<Integer>());
        }
        while (max > radix) {
            for (int i = 0; i < data.length; i++) {
                int index = (data[i] / radix) % 10;
                ArrayList<Integer> list = numbers.get(index);
                list.add(data[i]);
                numbers.set(index, list);
            }
            resetOrder(data, numbers, reverse);
            radix = radix * 10;
        }
    }

    /**
     * 重新调整数组顺序
     * @param data
     * @param numbers
     * @param reverse 从大到小(false)还是从小到大(ture)

     */
    public static void resetOrder(int[] data, ArrayList<ArrayList<Integer>> numbers, boolean reverse) {
        int n = 0;
        if (reverse) {
            for (int i = 0; i < numbers.size(); i++) {
                ArrayList<Integer> list = numbers.get(i);
                while(list.size()>0){
                    data[n++] = list.get(0);
                    list.remove(0);
                }
            }
        } else {
            for (int i = numbers.size() - 1; i >= 0; i--) {
                ArrayList<Integer> list = numbers.get(i);
                while(list.size()>0){
                    data[n++] = list.get(0);
                    list.remove(0);
                }
            }
        }
    }

    /**
     * 选择排序
     * @param data  要排序的数组
     * @param reverse 从大到小(false)还是从小到大(ture)
     */
    public static void selectSort(int[] data, boolean reverse) {
        if (data.length == 1) {
            return;
        }
        for(int i=0;i<data.length-1;i++){
            int tmp=data[i];    //要初始化
            int index = i;      //要初始化
            for(int j=i;j<data.length;j++){
                if(reverse) {   //从小到大(ture)
                    if (tmp>=data[j]){
                        tmp = data[j];  //最小值
                        index = j;
                    }
                }else {
                    if (tmp<=data[j]){
                        tmp = data[j];  //最大值
                        index = j;
                    }
                }
            }
            data[index] = data[i];
            data[i] = tmp;
        }
    }

    /**
     * 希尔排序
     * 基本思想：算法先将要排序的一组数按某个增量d（n/2,n为要排序数的个数）分成若干组，每组中记录的下标相差d.
     * 对每组中全部元素进行直接插入排序，然后再用一个较小的增量（d/2）对它进行分组，在每组中再进行直接插入排序。
     * 当增量减到1时，进行直接插入排序后，排序完成。
     *
     * @param data    要排序的数组
     * @param reverse 从大到小(false)还是从小到大(ture)
     */
    public static void shellSort(int[] data, boolean reverse) {
        if (data.length == 1) {
            return;
        }
        for (int d = data.length / 2; d >= 1; d = d / 2) {  //组大小
            for (int k = 0; k < d; k++) {   //多少组
                for (int n = d + k; n < data.length; n = n + d) {   //同一组
                    int cur = n;
                    while (cur - d >= 0) {  //插入排序
                        int tmp = 0;
                        if (reverse) {  //小到大(ture)
                            if (data[cur] <= data[cur - d]) {
                                tmp = data[cur];
                                data[cur] = data[cur - d];
                                data[cur - d] = tmp;
                            }
                        } else {         //从大到小(false)
                            if (data[cur] >= data[cur - d]) {
                                tmp = data[cur];
                                data[cur] = data[cur - d];
                                data[cur - d] = tmp;
                            }
                        }
                        cur = cur - d;
                    }
                }
            }
        }

    }

}
