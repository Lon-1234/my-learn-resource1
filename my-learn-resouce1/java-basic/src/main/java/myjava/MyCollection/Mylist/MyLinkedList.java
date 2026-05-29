package myjava.MyCollection.Mylist;

/**
 * ArrayList 集合和 LinkedList 集合的常用操作方法基本一样，
 * 因为它们都实现了 List 接口。
 *
 * ArrayList：
 * 底层使用数组存储。
 * 特点：
 * 1. 查询快
 * 2. 增删相对慢
 * 3. 可以通过索引取值
 *
 * 常用方法：
 * add(E e)              添加元素
 * add(int index, E e)   在指定索引位置添加元素
 * get(int index)        根据索引获取元素
 * set(int index, E e)   修改指定索引位置的元素
 * remove(int index)     根据索引删除元素
 * remove(Object o)      根据元素删除
 * size()                获取元素个数
 * isEmpty()             判断集合是否为空
 * clear()               清空集合
 *
 * LinkedList：
 * 底层使用双向链表存储。
 * 特点：
 * 1. 插入、删除快
 * 2. 按索引查询慢
 * 3. 适合频繁操作头尾元素
 *
 * LinkedList 除了 List 的常用方法外，还提供了头尾操作方法：
 * addFirst(E e)         在头部添加元素
 * addLast(E e)          在尾部添加元素
 * getFirst()            获取第一个元素
 * getLast()             获取最后一个元素
 * removeFirst()         删除第一个元素
 * removeLast()          删除最后一个元素
 *
 * ListIterator：
 * ListIterator 是 List 集合专有的迭代器。
 * Iterator 只能向后遍历，而 ListIterator 可以双向遍历。
 *
 * 常用方法：
 * hasNext()             判断后面是否还有元素
 * next()                获取下一个元素，并向后移动
 * hasPrevious()         判断前面是否还有元素
 * previous()            获取上一个元素，并向前移动
 * nextIndex()           获取下一个元素的索引
 * previousIndex()       获取上一个元素的索引
 * add(E e)              在迭代器当前位置添加元素
 * set(E e)              修改刚刚遍历过的元素
 * remove()              删除刚刚遍历过的元素
 *
 * 注意：
 * 1. ListIterator 只能用于 List 集合。
 * 2. 使用 previous() 向前遍历前，迭代器必须先移动到后面。
 * 3. set() 和 remove() 必须在 next() 或 previous() 之后使用。
 *
 * List 集合本身不会自动排序。
 * 如果需要排序，可以使用 Collections.sort(list) 或 list.sort(comparator)。
 *
 * 1. 自然排序
 * 条件：
 * 集合元素所属的类必须实现 Comparable 接口，并重写 compareTo() 方法。
 *
 * compareTo(o) 规则：
 * 返回值 > 0：当前对象排在 o 后面
 * 返回值 < 0：当前对象排在 o 前面
 * 返回值 = 0：两个对象排序位置相同
 *
 * 2. 客户化排序 / 定制排序
 * 条件：
 * 排序时传入 Comparator 比较器对象，并重写 compare(o1, o2) 方法。
 *
 * compare(o1, o2) 规则：
 * 返回值 > 0：o1 排在 o2 后面
 * 返回值 < 0：o1 排在 o2 前面
 * 返回值 = 0：两个对象排序位置相同
 *
 * 补充： java.util.Arrays类的asList方法可以获取一个Java数组包装为一个List对象 ，这个对象的长度固定。
 *
 */
public class MyLinkedList {
}