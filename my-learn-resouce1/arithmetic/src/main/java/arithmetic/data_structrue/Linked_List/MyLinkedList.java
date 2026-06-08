package arithmetic.data_structrue.Linked_List;


import java.util.Iterator;
import java.util.Objects;

/*
 * 这是我的链表
 * */
public class MyLinkedList<E> implements Iterable<E> {
    //    记录链表的头节点
    private final Node hand;
    //    记录链表的长度
    private int N;

   private class Node {
        //        元素
        E e;
        //         尾指针
        Node next;

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    public MyLinkedList() {
        this.hand = new Node(null, null);
        N = 0;
    }

    //    判断链表是否为空
    public boolean isEmpty() {
        return this.N == 0;
    }

    //    判断普通索引是否越界
    private void checkIndex(int index) {
        if (index < 0 || index >= this.N) {
            throw new ArrayIndexOutOfBoundsException("索引越界！" + index);
        }
    }

    //    判断插入过来的索引是否越界
    private void checkInsertIndex(int index) {
        if (index < 0 || index > this.N) {
            throw new ArrayIndexOutOfBoundsException("索引越界！" + index);
        }
    }

    //    添加数据  默认插入尾节点
    public void add(E e) {
//        寻找最后的一个节点
        Node hand = this.hand;
        while (hand.next != null) {
            hand = hand.next;
        }
//        创建节点
        Node newNode = new Node(e, null);
//        插入
        hand.next = newNode;
        this.N++;

    }

    //    指定位置添加数据
    public void addIndex(int index, E e) {
        checkInsertIndex(index);
//        寻找需要插入的节点
        Node hand = this.hand;
        for (int i = 0; i < index; i++) {
            hand = hand.next;
        }
        Node newNode = new Node(e, null);
        newNode.next = hand.next;
        hand.next = newNode;
        this.N++;
    }

    /**
     * 修改方法 修改指定位置的元素
     *
     * @param index
     * @param newE  新的元素
     * @return 返回被修改的元素
     */
    public E updataDate(int index, E newE) {
        checkIndex(index);
        Node hand = this.hand.next;
        for (int i = 0; i < index; i++) {
            hand = hand.next;
        }
        E Data = hand.e;
        hand.e = newE;
        return Data;
    }
//    删除数据

    /**
     * @param oldE 需要删除的数据
     * @return 返回删除数据的索引
     */
    public int delete(E oldE) {
        Node current = this.hand;
        for (int i = 0; i < this.N; i++) {
            if (current.next.e != null && current.next.e.equals(oldE)) {
                // 找到了，直接让当前节点指向“下下个”节点
                current.next = current.next.next;
                this.N--;
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    //    清空数据
    public void clear() {
        this.hand.next = null;
        this.N = 0;
    }

    //    获取指定位置的数据
    public E getIndex(int index) {
        checkIndex(index);
        Node hand = this.hand.next;
        for (int i = 0; i < index; i++) {
            hand = hand.next;
        }
        return hand.e;
    }

    //    返回链表的长度
    public int length() {
        return this.N;
    }

    //    打印链表中的数据
    public void printAll() {
        StringBuilder stringBuilder = new StringBuilder();
        if (isEmpty()) {
            stringBuilder.append("[]");
            System.out.println(stringBuilder);
            return;
        }
        Node hand = this.hand.next;
        stringBuilder.append("[");
        while (hand.next != null) {
            stringBuilder.append(hand.e).append(",");
            hand = hand.next;
        }
        stringBuilder.append(hand.e).append("]");
        System.out.println(stringBuilder);
    }

    //    遍历接口实现
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<E> {

        private Node e;

        public MyIterator() {
            this.e = hand.next;
        }

        @Override
        public boolean hasNext() {
            return e != null;
        }

        @Override
        public E next() {
            E data = e.e;
            e = e.next;
            return data;
        }
    }


    /*
     * 链表的反转
     * */

    //反转整个链表
    public void reverse() {
//当前链表为空 则不反转 否则调用重载方法
        if (isEmpty()) {
            return;
        }
        reverse(hand.next);
    }

    public Node reverse(Node curr) {
//        当当前节点没有下一个节点则，结束调用 返回最后一个节点
        if (curr.next == null) {
            hand.next = curr;
            return curr;
        }

//        如果不是 则递归反转curr的下一个节点 返回值，链表反转后，当前节点的上一个节点
        Node pre = reverse(curr.next);
//        让返回的节点的下一个节点变成curr
        pre.next = curr;
//        把当前节点的下一个节点变为null
        curr.next = null;
        return curr;
    }


    /*
     * Fast slow Pointer
     * */


    //    中间值问题

    /**
     * @return 返回链表的中间节点的值
     */
    public E getMid() {
//定义两个指针
        Node fast = this.hand.next;
        Node slow = this.hand.next;
//        使用两个指针遍历链表，当快指针指向的节点没有下一个节点了，就可以结束了，结束之后，快慢指针指向的节点就是中间值
        while (fast != null && fast.next != null) {
//    变换两个指针的值
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.e;
    }


//    单项链表是否有环

    /**
     * @return true为有环 false 为无环
     */
    public boolean isCircle() {
//        定义两个快慢指针
        Node fast = this.hand.next;
        Node slow = this.hand.next;
//        遍历链表，如果快指针和慢指针直线同一个节点，那么证明有环
        while (fast != null && fast.next != null) {
//            变换fast和slow
            fast = fast.next.next;
            slow = slow.next;
//            判断他们两个是否指向同一个节点
            if (Objects.equals(fast, slow)) {
                return true;
            }
        }
        return false;
    }

    /*
    * 这里提供一个方法用于将链表闭环 让尾节点指向第二个元素
    *
    * */
    public void Entrance(){
        Node hand = this.hand.next;
        while (hand.next!=null){
            hand = hand.next;
        }
        hand.next = this.hand.next.next;
    }


    /**
     * @return 返回值是有环链表的入口 没有返回null
     */
    //    有环链表入口问题
    public Node getEntrance() {
//        前提是链表得是环
        if (!isCircle()) {
            return null;
        }
//        定义快慢指针
        Node fast = this.hand.next;
        Node slow = this.hand.next;
        Node temp = null;
//        遍历链表，先找到环（快慢指针相遇），准备一个临时指针，指向链表的首节点，接着遍历，直到慢指针和临时指针相遇，相遇的这个节点就是环的入口
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (Objects.equals(fast, slow)) {
                temp = this.hand.next;
                continue;
            }
//            让临时节点往后走
            if (temp != null) {
                temp = temp.next;
//                判断临时指针和慢指针是否相遇
                if (Objects.equals(slow, temp)) {
                    break;
                }
            }

        }
        return temp;
    }

}


