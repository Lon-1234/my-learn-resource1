package arithmetic.basicsort;

import org.junit.Test;

import java.util.Arrays;

/*
* 这是一个插入排序
* */
public class InsertSort {
    /**
     * 判断元素的大小
     *
     * @param arr 传递过来的需要排序的数组
     * @param i   前一个元素下表
     * @param j   后一个元素下表
     * @param <T>
     * @return a.compareTo(b) 返回值>0表示a>b
     */
    public static <T extends Comparable<T>> boolean judge(T[] arr, int i, T j) {
        return arr[i].compareTo(j) > 0;
    }

    public static <T extends  Comparable <T>> void sort(T [] arr){
        for (int i = 1; i < arr.length; i++) {
            T temp = arr[i];
           int j=i;
           while(j-1>=0&&judge(arr,j-1,temp)){
               arr[j] = arr[j-1];
               j--;
           }
           arr[j] = temp;
        }
    }
    @Test
    public void t1(){
        Integer [] arr = new Integer[]{10,9,8,7,6,5,4,3,2,1,0};
        sort(arr);
        Arrays.stream(arr).forEach(s-> System.out.print(s+" "));
    }
}
