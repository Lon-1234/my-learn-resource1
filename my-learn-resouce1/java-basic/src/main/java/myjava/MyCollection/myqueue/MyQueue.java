package myjava.MyCollection.myqueue;

/**
 * Queue 表示队列。
 *
 * Queue 是一种先进先出的数据结构：
 *
 * FIFO：
 * First In First Out
 * 先进先出
 *
 * 队列特点：
 * 1. 从队尾添加元素
 * 2. 从队头删除元素
 * 3. 可以获取队头元素
 *
 * Queue 常用实现类：
 *
 * LinkedList：
 * 底层是双向链表。
 * 可以作为普通队列使用。
 *
 * ArrayDeque：
 * 底层是数组。
 * 可以作为双端队列使用。
 *
 * PriorityQueue：
 * 优先级队列。
 * 元素会按照优先级规则出队。
 *
 * ==================================================
 *
 * Queue 常用方法：
 *
 * add(E e)
 * 向队尾添加元素。
 * 添加成功返回 true。
 * 如果队列容量已满，会抛出 IllegalStateException。
 *
 * offer(E e)
 * 向队尾添加元素。
 * 添加成功返回 true。
 * 如果队列容量已满，返回 false。
 *
 * remove()
 * 删除并返回队头元素。
 * 如果队列为空，会抛出 NoSuchElementException。
 *
 * poll()
 * 删除并返回队头元素。
 * 如果队列为空，返回 null。
 *
 * element()
 * 获取队头元素，但是不删除。
 * 如果队列为空，会抛出 NoSuchElementException。
 *
 * peek()
 * 获取队头元素，但是不删除。
 * 如果队列为空，返回 null。
 *
 * ==================================================
 *
 * add() 和 offer() 的区别：
 *
 * add()
 * 添加失败会抛异常。
 *
 * offer()
 * 添加失败会返回 false。
 *
 * 一般更推荐使用 offer()。
 *
 * ==================================================
 *
 * remove() 和 poll() 的区别：
 *
 * remove()
 * 队列为空时抛出 NoSuchElementException。
 *
 * poll()
 * 队列为空时返回 null。
 *
 * 一般更推荐使用 poll()。
 *
 * ==================================================
 *
 * element() 和 peek() 的区别：
 *
 * element()
 * 队列为空时抛出 NoSuchElementException。
 *
 * peek()
 * 队列为空时返回 null。
 *
 * 一般更推荐使用 peek()。
 *
 * ==================================================
 *
 * Deque 表示双端队列。
 *
 * Deque 是 Queue 的子接口。
 *
 * 双端队列特点：
 * 可以在队头添加元素。
 * 可以在队尾添加元素。
 * 可以在队头删除元素。
 * 可以在队尾删除元素。
 * 可以在队头获取元素。
 * 可以在队尾获取元素。
 *
 * Deque 常用实现类：
 *
 * LinkedList
 * ArrayDeque
 *
 * ==================================================
 *
 * Deque 添加元素方法：
 *
 * addFirst(E e)
 * 在队头添加元素。
 * 如果添加失败，会抛出 IllegalStateException。
 *
 * addLast(E e)
 * 在队尾添加元素。
 * 如果添加失败，会抛出 IllegalStateException。
 *
 * offerFirst(E e)
 * 在队头添加元素。
 * 如果添加失败，返回 false。
 *
 * offerLast(E e)
 * 在队尾添加元素。
 * 如果添加失败，返回 false。
 *
 * ==================================================
 *
 * Deque 删除元素方法：
 *
 * removeFirst()
 * 删除并返回队头元素。
 * 如果队列为空，会抛出 NoSuchElementException。
 *
 * removeLast()
 * 删除并返回队尾元素。
 * 如果队列为空，会抛出 NoSuchElementException。
 *
 * pollFirst()
 * 删除并返回队头元素。
 * 如果队列为空，返回 null。
 *
 * pollLast()
 * 删除并返回队尾元素。
 * 如果队列为空，返回 null。
 *
 * ==================================================
 *
 * Deque 获取元素方法：
 *
 * getFirst()
 * 获取队头元素，但是不删除。
 * 如果队列为空，会抛出 NoSuchElementException。
 *
 * getLast()
 * 获取队尾元素，但是不删除。
 * 如果队列为空，会抛出 NoSuchElementException。
 *
 * peekFirst()
 * 获取队头元素，但是不删除。
 * 如果队列为空，返回 null。
 *
 * peekLast()
 * 获取队尾元素，但是不删除。
 * 如果队列为空，返回 null。
 *
 * ==================================================
 *
 * PriorityQueue 表示优先级队列。
 *
 * PriorityQueue 不是按照添加顺序出队，
 * 而是按照排序规则决定谁先出队。
 *
 * 默认情况下：
 * 数字越小，优先级越高，越先出队。
 *
 * 例如：
 *
 * 添加顺序：
 * 67, 12, 33
 *
 * poll() 删除顺序：
 * 12, 33, 67
 *
 * 注意：
 * foreach 遍历 PriorityQueue 时，
 * 看到的顺序不一定是排序后的顺序。
 *
 * 真正按照优先级顺序取出元素，
 * 应该使用 poll()。
 *
 * ==================================================
 *
 * PriorityQueue 排序方式：
 *
 * 1. 自然排序
 * 元素所属类必须实现 Comparable 接口，
 * 并重写 compareTo() 方法。
 *
 * 例如：
 * Integer、String 已经实现 Comparable 接口。
 *
 * 2. 客户化排序 / 定制排序
 * 创建 PriorityQueue 时传入 Comparator 比较器对象，
 * 并重写 compare(o1, o2) 方法。
 *
 * compare(o1, o2) 规则：
 * 返回值 > 0：o1 优先级低，排在 o2 后面
 * 返回值 < 0：o1 优先级高，排在 o2 前面
 * 返回值 = 0：两个元素优先级相同
 *
 * ==================================================
 *
 * 记忆：
 *
 * Queue：
 * 单端队列，先进先出。
 *
 * Deque：
 * 双端队列，头尾都能操作。
 *
 * PriorityQueue：
 * 优先级队列，按排序规则出队。
 *
 * offer / poll / peek：
 * 更安全，失败时返回 false 或 null。
 *
 * add / remove / element：
 * 失败时容易抛异常。
 */
public class MyQueue {
}