package arithmetic.basuc;

import org.junit.Test;

import java.util.Arrays;

/*
 * 这是一个冒泡排序
 * */
public class BubblingSort {

    /**
     * 判断元素的大小
     *
     * @param arr 传递过来的需要排序的数组
     * @param i   前一个元素下表
     * @param j   后一个元素下表
     * @param <T>
     * @return a.compareTo(b) 返回值>0表示a>b
     */
    public static <T extends Comparable<T>> boolean judge(T[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) > 0;
    }

    /**
     * 交换元素
     *
     * @param arr 传递过来的需要排序的数组
     * @param i   前一个元素下表
     * @param j   后一个元素下表
     * @param <T>
     */
    public static <T extends Comparable<T>> void exchange(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 排序
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void Sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (judge(arr, j, j + 1)) {
                    exchange(arr, j, j + 1);
                }
            }

        }
    }


    @Test
    public void t1() {
        Integer[] arr = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Sort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));

    }
}
