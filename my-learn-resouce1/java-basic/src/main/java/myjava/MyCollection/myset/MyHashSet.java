package myjava.MyCollection.myset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set 集合常用用法。
 *
 * HashSet 底层不是自己存数据，而是使用 HashMap 存数据。
 * HashSet 的元素就是 HashMap 的 key，value 固定是 PRESENT。
 *
 * 自定义类对象如果要放入 HashSet，
 * 并且希望按照对象内容去重，
 * 需要重写 hashCode() 和 equals() 方法。
 */
public class MyHashSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        // 添加元素
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        // 遍历
        for (Integer i : set) {
            System.out.print(i + " ");
        }

        System.out.println("\n_________");

        // 添加重复元素
        set.add(4);

        for (Integer i : set) {
            System.out.print(i + " ");
        }

        System.out.println("\n_________");

        // 删除元素
        boolean remove = set.remove(4);
        System.out.println("删除成功返回 true，remove：" + remove);

        for (Integer i : set) {
            System.out.print(i + " ");
        }

        System.out.println("\n_________");

        // 判断元素是否存在
        boolean contains = set.contains(3);
        System.out.println("判断元素是否存在，存在返回 true，contains：" + contains);

        // 获取元素个数
        int size = set.size();
        System.out.println("元素个数为：" + size);

        // 判断是否为空
        boolean empty = set.isEmpty();
        System.out.println("集合是否为空，空返回 true，empty：" + empty);

        // 迭代器遍历
        System.out.println("迭代器遍历：");
        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        // 清空集合
        set.clear();
        System.out.println("set 是否为空：" + set.isEmpty());
    }
}