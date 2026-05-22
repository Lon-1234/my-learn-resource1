package arithmetic.intermediatesort;

import org.junit.Test;

import java.util.Arrays;

/*
 * 希尔排序
 * */
public class xiersort {
    /**
     * 判断大小
     *
     * @param arr 需要排序的数组
     * @param i   前一位元素
     * @param j   后一位元素
     * @param <T>
     * @return a.compareTo(b) 当a>b 返回值大于0
     */
    public static <T extends Comparable<T>> boolean judge(T[] arr, int i, T j) {
        return arr[i].compareTo(j) > 0;
    }

    /**
     * 交换位置
     *
     * @param arr
     * @param i
     * @param j
     * @param <T>
     */
    public static <T extends Comparable<T>> void exchange(T[] arr, int i, T j) {
        arr[i] = j;
    }

    /**
     * @param arr 待排序的数组
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
//        计算步长
        int walk = 1;
        while (walk < arr.length / 2) {
            walk = (walk + 1) * 3;
        }
//        管理步长
        for (int i = walk; i > 0; i = (i - 1) / 3) {
//        对对应步长组进行选择排序
            for (int j = i; j < arr.length; j++) {
                T temp = arr[j];//记录当前步长位置的元素
//                为元素寻找正确且对应的位置
                int k = j;
                while (k - i >= 0 && judge(arr, k - i, temp)) {
                    arr[k] = arr[k - i];
                    k -= i;
                }
                exchange(arr, k, temp);
            }
        }
    }

    @Test
    public void t1() {
        Integer[] arr = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        sort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
    }
}
