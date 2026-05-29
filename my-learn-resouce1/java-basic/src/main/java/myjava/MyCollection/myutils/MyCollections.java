package myjava.MyCollection.myutils;

/**
 * Collections 工具类
 *
 * Collections 是集合工具类。
 *
 * 注意：
 *
 * Collection 是接口。
 * Collections 是工具类。
 *
 * Collection：
 * List、Set、Queue 的父接口。
 *
 * Collections：
 * 提供各种操作集合的静态方法。
 *
 * ==================================================
 *
 * 一、适用于 List 的方法
 *
 * List 具有索引，因此可以排序、复制、查找等。
 *
 * sort(List list)
 * 自然排序。
 *
 * sort(List list, Comparator c)
 * 客户化排序。
 *
 * binarySearch(List list, Object key)
 * 二分查找。
 * 要求集合已经排序。
 *
 * binarySearch(List list, Object key, Comparator c)
 * 使用比较器规则进行二分查找。
 *
 * shuffle(List list)
 * 随机打乱元素顺序。
 *
 * copy(List dest, List src)
 * 将 src 中元素复制到 dest 中。
 *
 * fill(List list, Object obj)
 * 使用指定对象填充整个 List。
 *
 * singletonList(Object obj)
 * 创建只包含一个元素的不可修改 List。
 *
 * synchronizedList(List list)
 * 创建线程安全的 List。
 *
 * unmodifiableList(List list)
 * 创建不可修改的 List。
 *
 * ==================================================
 *
 * 二、适用于 Collection 的方法
 *
 * Collection 是 List、Set、Queue 的父接口。
 *
 * 因此：
 *
 * Collection 方法
 * 一定适用于：
 *
 * List
 * Set
 * Queue
 *
 * max(Collection coll)
 * 返回最大元素。
 *
 * max(Collection coll, Comparator comp)
 * 根据比较器返回最大元素。
 *
 * min(Collection coll)
 * 返回最小元素。
 *
 * min(Collection coll, Comparator comp)
 * 根据比较器返回最小元素。
 *
 * synchronizedCollection(Collection c)
 * 创建线程安全 Collection。
 *
 * unmodifiableCollection(Collection c)
 * 创建不可修改 Collection。
 *
 * ==================================================
 *
 * 三、适用于 Set 的方法
 *
 * singleton(Object obj)
 * 创建只包含一个元素的不可修改 Set。
 *
 * synchronizedSet(Set set)
 * 创建线程安全 Set。
 *
 * unmodifiableSet(Set set)
 * 创建不可修改 Set。
 *
 * ==================================================
 *
 * 四、适用于 Map 的方法
 *
 * 注意：
 *
 * Map 不属于 Collection 体系。
 *
 * 继承关系：
 *
 * Iterable
 *      ↑
 * Collection
 *   ├── List
 *   ├── Set
 *   └── Queue
 *
 * Map（独立体系）
 *
 * 所以：
 *
 * Collections.max()
 * Collections.min()
 *
 * 不能直接用于 Map。
 *
 * singletonMap(K key,V value)
 * 创建只包含一个键值对的不可修改 Map。
 *
 * synchronizedMap(Map map)
 * 创建线程安全 Map。
 *
 * unmodifiableMap(Map map)
 * 创建不可修改 Map。
 *
 * ==================================================
 *
 * 五、常见面试题
 *
 * Collection 和 Collections 的区别？
 *
 * Collection：
 * 集合接口。
 *
 * Collections：
 * 集合工具类。
 *
 * ==================================================
 *
 * 六、记忆
 *
 * Collection：
 * 集合接口
 *
 * Collections：
 * 集合工具类
 *
 * List：
 * sort()
 * binarySearch()
 * shuffle()
 * copy()
 * fill()
 *
 * Collection：
 * max()
 * min()
 *
 * Set：
 * singleton()
 *
 * Map：
 * singletonMap()
 *
 * synchronizedXXX()
 * 创建线程安全集合
 *
 * unmodifiableXXX()
 * 创建不可修改集合
 */
public class MyCollections {
}