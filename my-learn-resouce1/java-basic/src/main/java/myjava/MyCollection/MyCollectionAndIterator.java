package myjava.MyCollection;

/**
 * Collection 是单列集合体系的根接口。
 *
 * Collection 接口下面主要有：
 *
 * List：
 * 有序，可重复。
 * 常见实现类：
 * ArrayList、LinkedList、Vector
 *
 * Set：
 * 无序，不可重复。
 * 常见实现类：
 * HashSet、LinkedHashSet、TreeSet
 *
 * Queue：
 * 队列结构。
 * 常见实现类：
 * PriorityQueue、ArrayDeque、LinkedList
 *
 * Collection 定义了所有单列集合共有的方法。
 *
 * 常用方法：
 * add(E e)              添加元素
 * remove(Object o)      删除元素
 * contains(Object o)    判断元素是否存在
 * size()                获取元素个数
 * isEmpty()             判断集合是否为空
 * clear()               清空集合
 * iterator()            获取迭代器
 * toArray()             转换为数组
 *
 * Collection 不能通过索引访问元素，
 * 因为 Collection 并不知道底层到底是：
 * 数组(ArrayList)
 * 链表(LinkedList)
 * 哈希表(HashSet)
 * 红黑树(TreeSet)
 *
 * 因此 Collection 提供统一的 Iterator 遍历接口。
 *
 * ==================================================
 *
 * Iterator（迭代器）
 *
 * Iterator 是 Collection 提供的统一遍历接口。
 *
 * Iterator 的作用：
 * 隐藏底层数据结构，
 * 为客户端提供统一的遍历方式。
 *
 * 无论集合底层是：
 * 数组
 * 链表
 * 哈希表
 * 红黑树
 *
 * 都可以使用 Iterator 进行遍历。
 *
 * 获取方式：
 *
 * Iterator<E> it = collection.iterator();
 *
 * 常用方法：
 *
 * hasNext()
 * 判断是否还有下一个元素。
 *
 * next()
 * 获取下一个元素，
 * 并将迭代器向后移动一位。
 *
 * remove()
 * 删除刚刚通过 next() 返回的元素。
 *
 * ==================================================
 *
 * Iterator 遍历流程：
 *
 * Iterator<String> it = list.iterator();
 *
 * while(it.hasNext()){
 *     String value = it.next();
 *     System.out.println(value);
 * }
 *
 * 执行过程：
 *
 * 1.
 * hasNext()
 * 判断后面是否还有元素
 *
 * 2.
 * next()
 * 返回当前元素
 * 并将指针移动到下一个位置
 *
 * 3.
 * 重复执行直到 hasNext() 返回 false
 *
 * ==================================================
 *
 * foreach 本质
 *
 * foreach 本质也是 Iterator。
 *
 * 例如：
 *
 * for(String s : list){
 *     System.out.println(s);
 * }
 *
 * 编译后实际上类似于：
 *
 * Iterator<String> it = list.iterator();
 *
 * while(it.hasNext()){
 *     String s = it.next();
 *     System.out.println(s);
 * }
 *
 * ==================================================
 *
 * 快速失败机制（Fail-Fast）
 *
 * 当 Iterator 正在遍历集合时：
 *
 * 如果使用集合对象直接修改集合：
 *
 * list.remove(...)
 * set.add(...)
 *
 * 可能抛出：
 *
 * ConcurrentModificationException
 *
 * 原因：
 *
 * Iterator 发现集合结构已经发生变化。
 *
 * 正确做法：
 *
 * 使用 Iterator 自己的 remove() 方法删除元素。
 *
 * Iterator<Integer> it = list.iterator();
 *
 * while(it.hasNext()){
 *     Integer num = it.next();
 *
 *     if(num == 3){
 *         it.remove();
 *     }
 * }
 *
 * ==================================================
 *
 * 记忆：
 *
 * Collection：
 * 单列集合根接口
 *
 * Iterator：
 * 统一遍历集合
 *
 * hasNext()
 * 判断有没有下一个
 *
 * next()
 * 获取下一个元素
 *
 * remove()
 * 删除当前元素
 *
 * foreach 本质：
 * Iterator
 */
public class MyCollectionAndIterator {
}