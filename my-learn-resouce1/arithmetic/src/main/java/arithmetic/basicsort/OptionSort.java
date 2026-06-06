package src.main.java.arithmetic.basicsort;


import org.junit.Test;

import java.util.Arrays;

/*
 * 这是一个选择排序
 * */
public class OptionSort {

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


    public static <T extends Comparable<T>> void sort(T[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (judge(arr, minIndex, j)) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                exchange(arr, i, minIndex);
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
