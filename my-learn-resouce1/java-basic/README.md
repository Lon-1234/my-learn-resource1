---
## 1.java集合体系
---
Java 集合体系 + 工具类总图
【接口】= interface
【类】= class

```text
├── Iterable【接口】
│   └── Collection【接口】：单列集合
│       │
│       ├── List【接口】：有序，可重复
│       │   ├── ArrayList【类】
│       │   ├── LinkedList【类】
│       │   └── Vector【类】
│       │       └── Stack【类】
│       │
│       ├── Set【接口】：不重复
│       │   ├── HashSet【类】
│       │   │   └── LinkedHashSet【类】
│       │   └── SortedSet【接口】
│       │       └── NavigableSet【接口】
│       │           └── TreeSet【类】
│       │
│       └── Queue【接口】：队列
│           ├── PriorityQueue【类】
│           └── Deque【接口】：双端队列
│               ├── ArrayDeque【类】
│               └── LinkedList【类】
│
├── Map【接口】：双列集合，key-value
│   ├── HashMap【类】
│   │   └── LinkedHashMap【类】
│   ├── SortedMap【接口】
│   │   └── NavigableMap【接口】
│   │       └── TreeMap【类】
│   ├── Hashtable【类】
│   │   └── Properties【类】
│   └── ConcurrentHashMap【类】
│
└── 工具类
├── Collections【类】：操作集合
├── Arrays【类】：操作数组
└── Objects【类】：操作对象
```

---
## 2.Set集合
```text
Iterable
    ↓
Collection
    ↓
Set
    ├── HashSet
    │     └── LinkedHashSet
    └── SortedSet
          └── NavigableSet
                └── TreeSet
```

Set 是 Collection 的子接口。

核心特点：

```text
1. 元素不能重复
2. 大多数实现类没有索引
3. 主要用于数据去重
```

---

## 2. HashSet

继承关系：

```text
Set
 └── HashSet
```

底层数据结构：

```text
JDK7：
    数组 + 链表

JDK8：
    数组 + 链表 + 红黑树
```

特点：

```text
1. 元素不能重复
2. 无序存储
3. 查询效率高
4. 允许null
5. 去重依赖 hashCode() 和 equals()
```

使用场景：

```text
数据去重
```

---

## 3. LinkedHashSet

继承关系：

```text
HashSet
   └── LinkedHashSet
```

底层数据结构：

```text
哈希表 + 双向链表
```

特点：

```text
1. 元素不能重复
2. 保留添加顺序
3. 查询效率较高
4. 允许null
```

使用场景：

```text
需要去重
同时保持插入顺序
```

---

## 4. TreeSet

继承关系：

```text
Set
 └── SortedSet
      └── NavigableSet
            └── TreeSet
```

底层数据结构：

```text
红黑树
```

特点：

```text
1. 元素不能重复
2. 自动排序
3. 默认升序
4. 不允许存入无法比较大小的对象
```

使用场景：

```text
需要排序并去重
```

---

## 5. 三种Set对比

```text
HashSet
    去重
    无序
    数组+链表+红黑树

LinkedHashSet
    去重
    有序
    哈希表+双向链表

TreeSet
    去重
    自动排序
    红黑树
```


---