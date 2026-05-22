package arithmetic.intermediate_sort;


import org.junit.Test;

import java.util.Arrays;

/*
 * 快速排序
 * */
public class Quike {
    /**
     * 判断 两个元素的大小
     *
     * @param arr
     * @param i
     * @param j
     * @param <T>
     * @return 当arr[i]>arr[j]返回值大于零
     */
    public static <T extends Comparable<T>> boolean judge(T[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) > 0;
    }

    /**
     * 当arr[i]<arr[j]返回值小于 0
     * @param arr
     * @param i
     * @param j
     * @return
     * @param <T>
     */
    public static <T extends Comparable<T>> boolean less(T[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    /**
     * 对数组进行排序
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void quikeSort(T[] arr) {
        quikeSort(arr, 0, arr.length - 1);
    }

    /**
     * 交换元素
     *
     * @param arr
     * @param i
     * @param j
     * @param <T>
     */
    public static <T extends Comparable<T>> void exchange(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 重载方法
     *
     * @param arr
     * @param left
     * @param right
     * @param <T>
     */
    public static <T extends Comparable<T>> void quikeSort(T[] arr, int left, int right) {
//结束条件 当左边大于右边
        if (left >= right) {
            return;
        }
//        找到中间的值
        int med = partition(arr, left, right);
//        对左边的进行排序
        quikeSort(arr, left, med - 1);
//        对右边的进行排序
        quikeSort(arr, med + 1, right);

    }

    public static <T extends Comparable<T>> int partition(T[] arr, int left, int right) {
        int le = left;
        int ri = right+1;
//        从左端点和右边端点开始寻找比开头大和比开头小的数
        while (true) {
//            找右边的比mediate小的值
            while (judge(arr, --ri, left)) {
                if (ri == le) {
                    break;
                }
            }
//            找左边的比mediate大的值
            while (less(arr, ++le, left)) {
                if (le == ri) {
                    break;
                }
            }
//            找到后开始交换他们的位置
            if (le >= ri) {
                break;
            }else {
                exchange(arr,le,ri);
            }
        }
        exchange(arr,left,ri);
        return ri;
    }

    @Test
    public void t1(){
        Integer [] arr = new Integer[]{10,9,8,7,6,5,4,3,2,1,0};
        quikeSort(arr);
        Arrays.stream(arr).forEach(s-> System.out.print(s+" "));
    }
}
