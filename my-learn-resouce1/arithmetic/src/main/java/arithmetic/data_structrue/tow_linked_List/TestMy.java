package arithmetic.data_structrue.tow_linked_List;

/*
 * 详细测试一下
 * */
public class TestMy {

    public static void main(String[] args) {
        // 创建一个存储 Integer 类型的双向链表
        LinkedList<Integer> list = new LinkedList<>();

        System.out.println("=== 1. 测试空链表与基础状态 ===");
        list.printAll(); // 预期: []
        System.out.println("链表是否为空: " + list.isEmpty()); // 预期: true
        System.out.println("链表长度: " + list.size());       // 预期: 0

        System.out.println("\n=== 2. 测试添加操作 (Add) ===");
        list.addLast(10);  // 测试向空链表尾部添加
        list.addFirst(20); // 测试向非空链表头部添加
        list.addLast(30);  // 测试向非空链表尾部添加
        System.out.print("当前链表: ");
        list.printAll(); // 预期: [20, 10, 30]

        System.out.println("\n=== 3. 测试按索引插入 (Add by Index) ===");
        list.add(0, 40); // 头部插入 (等同于 addFirst)
        list.add(list.size(), 50); // 尾部插入 (等同于 addLast)
        list.add(2, 60); // 中间插入
        System.out.print("插入后链表: ");
        list.printAll(); // 预期: [40, 20, 60, 10, 30, 50]

        System.out.println("\n=== 4. 测试查询操作 (Get/Contains) ===");
        System.out.println("第一个元素: " + list.getFirst()); // 预期: 40
        System.out.println("最后一个元素: " + list.getLast());  // 预期: 50
        System.out.println("索引 2 的元素: " + list.get(2));    // 预期: 60
        System.out.println("元素 10 的索引: " + list.indexOf(10)); // 预期: 3
        System.out.println("是否包含 100: " + list.contains(100)); // 预期: false

        System.out.println("\n=== 5. 测试删除操作 (Remove) ===");
        System.out.println("删除头部: " + list.removeFirst()); // 预期: 40
        System.out.println("删除尾部: " + list.removeLast());  // 预期: 50
        System.out.print("当前链表: ");
        list.printAll(); // 预期: [20, 60, 10, 30]

        System.out.println("\n=== 6. 测试按索引删除 (Remove by Index) ===");
        System.out.println("删除索引 1 (值为60): " + list.remove(1)); // 预期: 60
        System.out.print("当前链表: ");
        list.printAll(); // 预期: [20, 10, 30]

        System.out.println("\n=== 7. 测试清空链表 (Clear) ===");
        list.clear();
        System.out.print("清空后链表: ");
        list.printAll(); // 预期: []
        System.out.println("清空后长度: " + list.size()); // 预期: 0

        System.out.println("\n=== 8. 极限边界测试 (防空指针) ===");
        list.addFirst(99);
        System.out.println("添加唯一元素 99 后删除: " + list.removeLast()); // 预期: 99
        System.out.println("链表是否被完全置空: " + list.isEmpty()); // 预期: true
    }
}