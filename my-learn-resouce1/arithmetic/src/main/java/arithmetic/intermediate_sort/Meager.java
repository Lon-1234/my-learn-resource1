package arithmetic.intermediate_sort;

import org.junit.Test;

import java.util.Arrays;

/*
 * 这是一个归并排序
 * */
public class Meager {
    public static Comparable[] temp;

    /**
     * @param arr 传递过来的数组 待排序的数组
     * @param i   前一个元素的下标
     * @param j   后一个元素的下表
     * @param <T>
     * @return 当 a.compareTo(b) 当a>b的时候返回值大于零
     */
    public static <T extends Comparable<T>> boolean judge(T[] arr, int i, int j) {
        if (i == j) {
            return false;
        }
        return arr[i].compareTo(arr[j]) > 0;
    }
    public static <T extends Comparable<T>> void separator_sort(T[] arr) {
        temp = new Comparable[arr.length];
        separator_sort(arr,0,arr.length-1);
    }

    /**
     * 对数据进行分组
     * @param arr
     * @param left  数组的最左边
     * @param right 数组的最右边
     * @param <T>
     */
    public static <T extends Comparable<T>> void separator_sort(T[] arr, int left, int right) {
//        递归结束的条件
        if (left >= right) {
            return;
        }
//        计算中间的值
        int med = left + (right - left) / 2;
//        左边分
        separator_sort(arr, left, med);
//        右边分
        separator_sort(arr, med + 1, right);
//        开始合并
        meager(arr, left, med, right);
    }

    /**
     * 将零散的数据合成
     * @param arr
     * @param left
     * @param med
     * @param right
     * @param <T>
     */
    public static <T extends Comparable<T>> void meager(T[] arr, int left, int med, int right) {

        int le = left;
        int me = med + 1;
        int index = left;

        while (le <= med && me <= right) {
            if (judge(arr, le, me)) {
                temp[index++] = arr[me++];
            } else {
                temp[index++] = arr[le++];
            }
        }

//        处理右边剩余的元素
        while (me <= right) {
            temp[index++] = arr[me++];
        }

//        处理左边的元素
        while (le <= med) {
            temp[index++] = arr[le++];
        }

//        复制
        System.arraycopy(temp, left, arr, left, right - left + 1);
    }

    @Test
    public void t1(){
        Integer [] arr = new Integer[]{10,9,8,7,6,5,4,3,2,1,0};
        separator_sort(arr);
        Arrays.stream(arr).forEach(s-> System.out.print(s+" "));
    }
}
