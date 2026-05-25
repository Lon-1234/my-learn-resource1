package arithmetic.data_structrue.liner_list;

import java.util.Iterator;

public class TestMy {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.addARR(1);
        list.addARR(2);
        list.addARR(3);
        list.addARR(4);
        System.out.println("======");
        list.forEach(s -> System.out.print(s + " "));
        System.out.println("======");
        list.insertIndex(2, 100);
        System.out.println("======");
        Integer data = list.getData(2);
        System.out.println(data);
        Iterator<Integer> my = list.iterator();
        while(my.hasNext()){
            Integer i = my.next();
            System.out.println(i);
        }
    }
}
