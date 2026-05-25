package arithmetic.data_structrue.liner_list;

import java.util.Iterator;

/*
 * 这是一个线性表
 * */
public class MyArrayList<E> implements Iterable<E> {

    //    数组
    private E[] ARR;
    //    记录当前数组中是否还有元素
    private int N;

//    构造方法，用于初始化数组和元素个数


    public MyArrayList(int max) {
        this.ARR = (E[]) new Object[max];
        this.N = 0;
    }

    public MyArrayList() {
        this.ARR = (E[]) new Object[10];
        this.N = 0;
    }

    //    获取指定位置的元素
    public E getData(int index) {
        if (index >= this.N || index < 0) {
            return null;
        }
        return this.ARR[index];
    }

    //    清空线性表
    public void clear() {
        for (int i = 0; i < N; i++) {
            ARR[i] = null;
        }
        this.N = 0;
    }

    //    检查插入索引是否越界
    public void checkInsertIndex(int index) {
        if (index < 0 || index > this.N) {
            throw new ArrayIndexOutOfBoundsException("插入索引越界：" + index);
        }
    }

    //    返回当前线性表的长度
    public int length() {
        return this.N;
    }

    //    添加数据
    public void addARR(E e) {
//       先判断是否扩容
        if (N == ARR.length) {
            reSize(ARR.length * 2);
        }
        ARR[this.N++] = e;
    }


    // 变为私有方法，内部直接替换 ARR，不返回数组
    private void reSize(int newCapacity) {
        // 兜底：确保新容量不小于 10
        if (newCapacity < 10) {
            newCapacity = 10;
        }

        E[] newArr = (E[]) new Object[newCapacity];
        for (int i = 0; i < N; i++) {
            newArr[i] = ARR[i];
        }
        this.ARR = newArr; // 直接在内部更新全局数组
    }

    //    修改数据
    public E reSet(int index, E e) {
//        判断是否越界
        checkIndex(index);
        E i = ARR[index];
        ARR[index] = e;
        return i;
    }

    //    删除指定索引处的数据
    public E remove(int index) {
//        记录删除的值
        checkIndex(index);
        E e = ARR[index];
        for (int i = index; i < N - 1; i++) {
            ARR[i] = ARR[i + 1];
        }
        ARR[--this.N] = null;
//        只有当当前容量大于 10，并且元素个数少于 1/4 时，才允许缩容
        if (ARR.length > 10 && this.N < ARR.length / 4) {
            reSize(ARR.length / 2);
        }
        return e;
    }

    //    指定位置插入数据
    public void insertIndex(int index, E e) {
        checkInsertIndex(index);
//        先看看是否需要扩容
        if (this.N == ARR.length) {
            reSize(ARR.length * 2);
        }
        for (int i = N; i > index; i--) {
            ARR[i] = ARR[i - 1];
        }
        ARR[index] = e;
        N++;
    }

    //    查询元素出现的第一个位置
    public int indexOf(E e) {
        for (int i = 0; i < this.N; i++) {
            if (e == null ? ARR[i] == null : e.equals(ARR[i])) {
                return i;
            }
        }
        return -1;
    }

    //    判断下表是否越界 越界返回true
    public void checkIndex(int index) {
        if (index < 0 || index >= this.N) {
            throw new ArrayIndexOutOfBoundsException("索引越界：  " + index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < N; i++) {
            sb.append(ARR[i]);
            if (i != N - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //    遍历接口
    @Override
    public Iterator<E> iterator() {
        return new IteratorMy();
    }

    class IteratorMy implements Iterator<E> {
        private int n = 0;

        @Override
        public boolean hasNext() {
            if (n < N) {
                return true;
            }
            return false;
        }

        @Override
        public E next() {
            return ARR[n++];
        }
    }

}
