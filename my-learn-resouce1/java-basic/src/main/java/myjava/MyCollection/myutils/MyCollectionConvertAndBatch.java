package myjava.MyCollection.myutils;

/**
 * 集合与数组互换 + 集合批量操作
 *
 * ==================================================
 * 一、数组转换为集合
 * ==================================================
 *
 * Arrays.asList(T... a)
 *
 * 作用：
 * 将数组转换为 List 集合。
 *
 * 例如：
 *
 * Integer[] arr = {1,2,3};
 *
 * List<Integer> list =
 *      Arrays.asList(arr);
 *
 * ==================================================
 *
 * 注意：
 *
 * Arrays.asList() 返回的 List
 * 本质上是数组视图。
 *
 * 不能改变长度：
 *
 * add()
 * remove()
 *
 * 会抛出：
 *
 * UnsupportedOperationException
 *
 * ==================================================
 *
 * 转换为真正的 ArrayList
 *
 * List<Integer> list =
 *      Arrays.asList(arr);
 *
 * ArrayList<Integer> arrayList =
 *      new ArrayList<>(list);
 *
 * ==================================================
 *
 * 转换为 HashSet
 *
 * Set<Integer> set =
 *      new HashSet<>(list);
 *
 * 常用于：
 *
 * 数组去重
 *
 * ==================================================
 * 二、集合转换为数组
 * ==================================================
 *
 * Collection 接口提供：
 *
 * Object[] toArray()
 *
 * T[] toArray(T[] a)
 *
 * ==================================================
 *
 * Object[] toArray()
 *
 * 返回：
 *
 * Object[]
 *
 * 例如：
 *
 * Object[] arr =
 *      list.toArray();
 *
 * ==================================================
 *
 * T[] toArray(T[] a)
 *
 * 返回指定类型数组。
 *
 * 例如：
 *
 * Integer[] arr =
 *      list.toArray(new Integer[0]);
 *
 * 返回：
 *
 * Integer[]
 *
 * 注意：
 *
 * new Integer[0]
 *
 * 只是告诉 JVM：
 *
 * 返回 Integer[] 类型。
 *
 * ==================================================
 * 三、Collection 批量操作
 * ==================================================
 *
 * retainAll(Collection<?> c)
 *
 * 求交集。
 *
 * 保留两个集合共同拥有的元素。
 *
 * 例如：
 *
 * list1：
 * 1 2 3 4
 *
 * list2：
 * 3 4 5 6
 *
 * retainAll()
 *
 * 结果：
 *
 * 3 4
 *
 * ==================================================
 *
 * removeAll(Collection<?> c)
 *
 * 求差集。
 *
 * 删除当前集合中同时存在于 c 中的元素。
 *
 * 例如：
 *
 * list1：
 * 1 2 3 4
 *
 * list2：
 * 3 4 5 6
 *
 * removeAll()
 *
 * 结果：
 *
 * 1 2
 *
 * ==================================================
 *
 * addAll(Collection<? extends E> c)
 *
 * 合并集合。
 *
 * 将 c 中所有元素添加到当前集合。
 *
 * 例如：
 *
 * list1.addAll(list2);
 *
 * ==================================================
 *
 * containsAll(Collection<?> c)
 *
 * 判断当前集合是否包含 c 中所有元素。
 *
 * 返回：
 *
 * true
 * false
 *
 * ==================================================
 * 四、List 特有方法
 * ==================================================
 *
 * subList(int fromIndex,
 *         int toIndex)
 *
 * 获取子集合。
 *
 * 注意：
 *
 * 左闭右开
 *
 * [fromIndex,toIndex)
 *
 * ==================================================
 *
 * 例如：
 *
 * List<Integer> list =
 *      Arrays.asList(
 *      1,2,3,4,5,6,7
 *      );
 *
 * list.subList(0,3);
 *
 * 返回：
 *
 * 1 2 3
 *
 * ==================================================
 *
 * list.subList(2,6);
 *
 * 返回：
 *
 * 3 4 5 6
 *
 * ==================================================
 *
 * 记忆：
 *
 * 数组 -> 集合
 *
 * Arrays.asList()
 *
 * 集合 -> 数组
 *
 * toArray()
 *
 * 交集
 *
 * retainAll()
 *
 * 差集
 *
 * removeAll()
 *
 * 合并
 *
 * addAll()
 *
 * 包含
 *
 * containsAll()
 *
 * 子集合
 *
 * subList()
 */
public class MyCollectionConvertAndBatch {
}