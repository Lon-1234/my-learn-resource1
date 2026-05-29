package myjava.MyCollection.myset;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet 实现了 SortedSet 接口，所以可以进行排序。
 *
 * TreeSet 的排序方式分为两种：
 *
 * 1. 自然排序
 * 元素所属的类必须实现 Comparable 接口，并重写 compareTo() 方法。
 * 例如 Integer、String 本身已经实现了 Comparable 接口。
 *
 * 2. 客户化排序 / 定制排序
 * 创建 TreeSet 时传入 Comparator 比较器对象。
 * Comparator 中需要重写 compare(o1, o2) 方法。
 *
 * compare(o1, o2) 规则：
 * 返回值 > 0：o1 排在 o2 后面
 * 返回值 < 0：o1 排在 o2 前面
 * 返回值 = 0：TreeSet 认为 o1 和 o2 重复，只保留一个
 *
 * 注意：
 * TreeSet 判断重复不依赖 hashCode() 和 equals()，
 * 而是依赖 compareTo() 或 Comparator 的 compare() 方法。
 */
public class MyTreeSet {

    public static void main(String[] args) {

        // 自然排序：Integer 已经实现了 Comparable 接口，不需要额外传比较器
        Set<Integer> set = new TreeSet<>();

        set.add(1);
        set.add(4);
        set.add(3);
        set.add(2);
        set.add(5);

        System.out.println("---自然排序---");
        for (Integer i : set) {
            System.out.println(i);
        }

        System.out.println("---客户化排序---");

        // 客户化排序：按照 age 从大到小排序
        Set<Student> set1 = new TreeSet<>(new MyComparator());

        set1.add(new Student(1));
        set1.add(new Student(2));
        set1.add(new Student(3));
        set1.add(new Student(4));
        set1.add(new Student(5));

        for (Student s : set1) {
            System.out.println(s);
        }
    }

    // 对象类
    static class Student {
        public int age;

        public Student(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    '}';
        }
    }

    // 比较器：控制 Student 在 TreeSet 中的排序规则
    static class MyComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }
}