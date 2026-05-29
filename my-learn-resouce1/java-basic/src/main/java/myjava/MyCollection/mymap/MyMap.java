package myjava.MyCollection.mymap;

/**
 * Map（映射）
 *
 * Map 是双列集合。
 *
 * Collection：
 * 一个元素对应一个值。
 *
 * Map：
 * 一个 Key 对应一个 Value。
 *
 * 存储形式：
 *
 * Key -------> Value
 *
 * 例如：
 *
 * 学号 -------> 姓名
 * 用户名 -----> 用户对象
 * 商品ID -----> 商品对象
 *
 * ==================================================
 *
 * Map 特点：
 *
 * 1. Key 不允许重复
 *
 * 如果插入重复 Key：
 *
 * map.put("1","Monday");
 * map.put("1","Tuesday");
 *
 * 后面的值会覆盖前面的值。
 *
 * 最终：
 *
 * 1 -> Tuesday
 *
 * 2. Value 可以重复
 *
 * map.put("1","Monday");
 * map.put("2","Monday");
 *
 * 合法。
 *
 * ==================================================
 *
 * Map 常用实现类：
 *
 * HashMap
 * LinkedHashMap
 * TreeMap
 * Hashtable（基本淘汰）
 *
 * ==================================================
 *
 * HashMap
 *
 * 底层：
 *
 * JDK7：
 * 数组 + 链表
 *
 * JDK8：
 * 数组 + 链表 + 红黑树
 *
 * 特点：
 *
 * 1. Key 无序
 * 2. 查询速度快
 * 3. Key 不允许重复
 * 4. Value 可以重复
 * 5. 允许一个 null Key
 * 6. 允许多个 null Value
 * 7. 非线程安全
 *
 * ==================================================
 *
 * TreeMap
 *
 * 底层：
 *
 * 红黑树
 *
 * 特点：
 *
 * 1. Key 自动排序
 * 2. Key 不允许重复
 * 3. Value 可以重复
 *
 * 排序方式：
 *
 * 自然排序
 * Comparable
 *
 * 客户化排序
 * Comparator
 *
 * 与 TreeSet 完全一样。
 *
 * ==================================================
 *
 * LinkedHashMap
 *
 * 底层：
 *
 * HashMap + 双向链表
 *
 * 特点：
 *
 * 1. 保留插入顺序
 * 2. 查询速度快
 * 3. Key 不允许重复
 *
 * ==================================================
 *
 * Map 常用方法：
 *
 * put(K key,V value)
 * 添加键值对。
 *
 * get(Object key)
 * 根据 Key 获取 Value。
 *
 * remove(Object key)
 * 根据 Key 删除键值对。
 *
 * containsKey(Object key)
 * 判断 Key 是否存在。
 *
 * containsValue(Object value)
 * 判断 Value 是否存在。
 *
 * size()
 * 获取键值对个数。
 *
 * isEmpty()
 * 判断是否为空。
 *
 * clear()
 * 清空集合。
 *
 * ==================================================
 *
 * 遍历 Map
 *
 * 方式一：
 * keySet()
 *
 * Set<K> keys = map.keySet();
 *
 * for(K key : keys){
 *     System.out.println(key);
 *     System.out.println(map.get(key));
 * }
 *
 * ==================================================
 *
 * 方式二（推荐）：
 * entrySet()
 *
 * Set<Map.Entry<K,V>> entries =
 *      map.entrySet();
 *
 * for(Map.Entry<K,V> entry : entries){
 *     System.out.println(entry.getKey());
 *     System.out.println(entry.getValue());
 * }
 *
 * ==================================================
 *
 * Map.Entry
 *
 * 表示一组键值对：
 *
 * Key ---- Value
 *
 * 常用方法：
 *
 * getKey()
 * 获取键。
 *
 * getValue()
 * 获取值。
 *
 * setValue()
 * 修改值。
 *
 * ==================================================
 *
 * HashMap 去重原理
 *
 * HashMap 判断 Key 是否重复：
 *
 * 先调用：
 *
 * hashCode()
 *
 * 再调用：
 *
 * equals()
 *
 * 所以自定义对象作为 Key 时：
 *
 * 必须重写：
 *
 * hashCode()
 * equals()
 *
 * 否则可能出现重复 Key。
 *
 * ==================================================
 *
 * HashMap 容量相关参数
 *
 * capacity：
 * 容量（桶数量）
 *
 * size：
 * 元素个数
 *
 * loadFactor：
 * 负载因子
 *
 * 计算公式：
 *
 * loadFactor = size / capacity
 *
 * 默认：
 *
 * 16
 * 0.75
 *
 * 即：
 *
 * size >= 16 × 0.75
 *
 * size >= 12
 *
 * 就会触发扩容。
 *
 * ==================================================
 *
 * 扩容机制
 *
 * 默认容量：
 *
 * 16
 *
 * 扩容后：
 *
 * 32
 *
 * 再扩：
 *
 * 64
 *
 * 再扩：
 *
 * 128
 *
 * 每次扩容：
 *
 * 2 倍扩容
 *
 * 同时重新计算元素位置（rehash）。
 *
 * ==================================================
 *
 * 负载因子影响
 *
 * 负载因子小：
 *
 * 空间浪费大
 * 查询快
 *
 * 负载因子大：
 *
 * 节省空间
 * 哈希冲突多
 * 查询慢
 *
 * 默认：
 *
 * 0.75
 *
 * 是时间和空间的折中方案。
 *
 * ==================================================
 *
 * 记忆：
 *
 * HashMap：
 * 无序
 * 查询快
 *
 * LinkedHashMap：
 * 有序
 *
 * TreeMap：
 * 自动排序
 *
 * Key：
 * 唯一
 *
 * Value：
 * 可重复
 *
 * HashMap 去重：
 *
 * hashCode()
 * +
 * equals()
 */
public class MyMap {
}