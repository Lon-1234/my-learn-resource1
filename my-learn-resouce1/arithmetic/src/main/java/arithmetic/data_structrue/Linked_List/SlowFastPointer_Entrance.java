package arithmetic.data_structrue.Linked_List;

import java.util.Objects;

/*
 * 环链表入口问题 在这里展示
 * */
public class SlowFastPointer_Entrance {

    private static class Node<E> {
        //        元素
        E e;
        //         尾指针
        Node next;

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    /**
     * @return 返回值是有环链表的入口 没有返回null
     */

    //    有环链表入口问题
    public static Node getEntrance(Node hand) {

//        定义快慢指针
        Node fast = hand;
        Node slow = hand;
        Node temp = null;
//        遍历链表，先找到环（快慢指针相遇），准备一个临时指针，指向链表的首节点，接着遍历，直到慢指针和临时指针相遇，相遇的这个节点就是环的入口
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (Objects.equals(fast, slow)) {
                temp = hand;
                break;
            }
        }
//        让临时指针和慢指针，进行移动，临时指针从头开始
        while (!Objects.equals(temp,slow)){
            assert slow !=null : "这里不能为null";
            slow = slow.next;
            assert temp !=null : "这里不能为null";
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        // 1. 创建节点
        Node<Integer> n1 = new Node<>(1, null);
        Node<Integer> n2 = new Node<>(2, null);
        Node<Integer> n3 = new Node<>(3, null);
        Node<Integer> n4 = new Node<>(4, null);
        Node<Integer> n5 = new Node<>(5, null);

        // 2. 连接节点形成链表
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // 3. 制造环：尾节点指向 n3
        n5.next = n3;
        System.out.println(getEntrance(n1).e);

    }



}
