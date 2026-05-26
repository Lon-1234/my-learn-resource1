package arithmetic.data_structrue.tow_linked_List;

/*
 * 双向链表
 */
public class LinkedList<E> {

    // 记录头指针
    private Node head;
    // 记录尾指针
    private Node tail;
    // 记录元素的数量
    private int N;

    // 节点类
    private class Node {
        Node prev;
        E data;
        Node next;

        public Node(Node prev, E data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    // 构造函数：初始化空链表
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.N = 0;
    }

    // 返回当前链表包含的节点数
    public int size() {
        return this.N;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return this.N == 0;
    }

    // 清空链表
    public void clear() {
        this.head = null;
        this.tail = null;
        this.N = 0;
    }

    // 从头遍历链表内容
    public void printAll() {
        if (this.N == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        // 起点必须是 head 本身，而不是 head.next
        Node node = this.head;
        while (node != null) {
            stringBuilder.append(node.data);
            if (node.next != null) {
                stringBuilder.append(", ");
            }
            node = node.next; // 局部游标后移
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }

    // 获取并返回头节点的值
    public E getFirst() {
        if (this.N == 0) {
            return null;
        }
        // 直接返回 head 的数据
        return this.head.data;
    }

    // 获取并返回尾节点的值（不删除）
    public E getLast() {
        if (this.N == 0) {
            return null;
        }
        return this.tail.data;
    }

    // 获取指定索引位置的节点值
    public E get(int index) {
        if (index < 0 || index >= this.N) {
            return null;
        }
        Node node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    // 查找指定值第一次出现的索引，如果不存在则返回 -1
    public int indexOf(E e) {
        Node node = this.head;
        for (int i = 0; i < this.N; i++) {
            // 兼容 null 值的判断，防止 NullPointerException
            if (e == null ? node.data == null : e.equals(node.data)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    // 判断链表中是否存在指定的值。
    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    // 删除头节点，并返回被删除的值。
    public E removeFirst() {
        if (this.N == 0) {
            return null;
        }
        E result = this.head.data;
        // 头指针后移
        this.head = this.head.next;

        if (this.head == null) {
            // 如果链表删空了，尾指针也要置空
            this.tail = null;
        } else {
            // 否则，切断新头节点向前的联系
            this.head.prev = null;
        }
        this.N--;
        return result;
    }

    // 删除尾节点，并返回被删除的值
    public E removeLast() {
        if (this.N == 0) {
            return null;
        }
        E result = this.tail.data;
        // 尾指针前移
        this.tail = this.tail.prev;

        if (this.tail == null) {
            // 如果链表删空了，头指针也要置空
            this.head = null;
        } else {
            // 否则，切断新尾节点向后的联系
            this.tail.next = null;
        }
        this.N--;
        return result;
    }

    // 删除指定索引位置的节点，并返回该节点的值。
    public E remove(int index) {
        if (index < 0 || index >= this.N) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == this.N - 1) {
            return removeLast();
        }

        // 寻找要删除的节点
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        // 执行剥离
        Node prevNode = current.prev;
        Node nextNode = current.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        this.N--;
        return current.data;
    }

    // 在链表的最前端插入一个新节点。
    public void addFirst(E e) {
        // 新节点的 prev 是 null，next 是当前的 head
        Node newNode = new Node(null, e, this.head);
        if (this.N == 0) {
            // 如果是空链表，头尾都是这个新节点
            this.tail = newNode;
        } else {
            // 否则，把原头节点的 prev 连上新节点
            this.head.prev = newNode;
        }
        // 更新 head 指针
        this.head = newNode;
        this.N++;
    }

    // 在链表的最后端追加一个新节点。
    public void addLast(E e) {
        // 新节点的 prev 是当前的 tail，next 是 null
        Node newNode = new Node(this.tail, e, null);
        if (this.N == 0) {
            // 如果是空链表，头尾都是这个新节点
            this.head = newNode;
        } else {
            // 否则，把原尾节点的 next 连上新节点
            this.tail.next = newNode;
        }
        // 更新 tail 指针
        this.tail = newNode;
        this.N++;
    }

    // 在指定的索引位置处插入新节点。
    public void add(int index, E e) {
        if (index < 0 || index > this.N) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.N);
        }
        if (index == 0) {
            addFirst(e);
            return;
        }
        // 注意：追加到末尾的条件是 index == this.N，而不是 N - 1
        if (index == this.N) {
            addLast(e);
            return;
        }

        // 寻找原位置的节点
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        // 创建新节点并连入链表
        Node prevNode = current.prev;
        Node newNode = new Node(prevNode, e, current);
        prevNode.next = newNode;
        current.prev = newNode;

        this.N++;
    }
}