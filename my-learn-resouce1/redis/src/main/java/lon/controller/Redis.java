package lon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import jakarta.annotation.Resource;
import java.util.*;


@RestController
public class Redis {

    @Resource
    private RedisTemplate redisTemplate;

    /*
     * spring类型的相关操作
     * */
    @GetMapping("/t1")
    public String stringTest() throws InterruptedException {

        /*
         * 一、普通存储
         */
        redisTemplate.opsForValue().set("key", "小明");
        System.out.println("key 的值：" + redisTemplate.opsForValue().get("key"));

        /*
         * 二、给已有 key 设置过期时间
         */
        Boolean success = redisTemplate.expire("key", 30, TimeUnit.SECONDS);

        if (Boolean.TRUE.equals(success)) {
            System.out.println("key 设置 30 秒过期成功");
        } else {
            System.out.println("key 设置过期时间失败，可能 key 不存在");
        }

        /*
         * 三、等待 31 秒，查看 key 是否已经过期
         */
        Thread.sleep(31000);


        Object value = redisTemplate.opsForValue().get("key");

        if (value == null) {
            System.out.println("key 已经过期，被 Redis 删除");
        } else {
            System.out.println("key 还存在：" + value);
        }

        /*
         * 四、存储数据的同时设置过期时间
         */
        redisTemplate.opsForValue().set("key1", "小明1", 10, TimeUnit.SECONDS);

        Object key1Value = redisTemplate.opsForValue().get("key1");

        System.out.println("key1 的值：" + key1Value);

        /*
         * 五、原子自增、自减
         */
        redisTemplate.opsForValue().set("num", 0, 30, TimeUnit.SECONDS);

        Long num1 = redisTemplate.opsForValue().increment("num");
        System.out.println("自增 1 后：" + num1);

        Long num2 = redisTemplate.opsForValue().increment("num", 100);
        System.out.println("自增 100 后：" + num2);

        Long num3 = redisTemplate.opsForValue().decrement("num", 50);
        System.out.println("自减 50 后：" + num3);

        /*
         * 六、批量设置、批量获取
         */
        Map<String, Object> map = new HashMap<>();
        map.put("user1", "you");
        map.put("user2", "me");

        redisTemplate.opsForValue().multiSet(map);

        List<String> keys = new ArrayList<>(map.keySet());

        System.out.println("批量存储的 key：" + keys);

        List<Object> values = redisTemplate.opsForValue().multiGet(keys);

        System.out.println("批量获取的 value：" + values);

        return String.valueOf(redisTemplate.opsForValue().get("user1"));
    }

    /*
     * hash类型的相关操作  Map<String,Map<String,Object>
     * */
    @GetMapping("/t2")
    public String testHash() throws InterruptedException {
//存入数据
        redisTemplate.opsForHash().put("Key1", "1", 1);
        redisTemplate.opsForHash().put("Key1", "2", "v2");
        redisTemplate.opsForHash().put("Key1", "3", "v3");
//        获取数据  field
        System.out.println("存入的数据为：" + redisTemplate.opsForHash().get("Key1", "1"));
//        获取所有 hash
        System.out.println("获取全部的值： " + redisTemplate.opsForHash().entries("Key1"));

//        删除一个  field
        redisTemplate.opsForHash().delete("Key1", "3");
        System.out.println("获取全部的值： " + redisTemplate.opsForHash().entries("Key1"));

//        判断field是否存在
        Boolean success = redisTemplate.opsForHash().hasKey("Key1", "3");
        System.out.println("是否存在： " + success);
//        获取所有的field
        Set<Object> list = redisTemplate.opsForHash().keys("Key1");
        System.out.println("获取的 feild： " + list.toString());

//        获取所有的value
        List<String> list1 = redisTemplate.opsForHash().values("Key1");
        System.out.println("Values: " + list1.toString());

//        获取Hash长度

        System.out.println("hash长度为： " + redisTemplate.opsForHash().size("Key1"));

//        自增
        redisTemplate.opsForHash().increment("Key1", "1", 10);
        System.out.println("增加后的值为： " + redisTemplate.opsForHash().get("Key1", "1"));

//        自减
        redisTemplate.opsForHash().increment("Key1", "1", -5);
        System.out.println("减后的值为： " + redisTemplate.opsForHash().get("Key1", "1"));
//        设置过期时间
        redisTemplate.expire("Key1", 30, TimeUnit.SECONDS);

        Thread.sleep(31000);

//        判断该Key是否存在
        Boolean b = redisTemplate.hasKey("Key1");

        if (Boolean.TRUE.equals(b)) {
            System.out.println("Key1 还存在");
        } else {
            System.out.println("Key1 已经过期或不存在");
        }
        return "hello";
    }

    /*
     * List 类型相关操作
     * Redis List 类似 Java 中的 LinkedList
     *
     * 特点：
     * 1. 有序
     * 2. 可以重复
     * 3. 可以从左边插入
     * 4. 可以从右边插入
     * 5. 可以从左边弹出
     * 6. 可以从右边弹出
     */
    @GetMapping("/t3")
    public String t3() throws InterruptedException {

//      左侧插入
        redisTemplate.opsForList().leftPush("list1", 1);
        redisTemplate.opsForList().leftPush("list1", 2);
        redisTemplate.opsForList().leftPush("list1", 3);
//      查看结果
        System.out.println("左侧插入：" + redisTemplate.opsForList().range("list1", 0, -1));
//        右侧插入

        redisTemplate.opsForList().rightPush("list1", 4);
        redisTemplate.opsForList().rightPush("list1", 5);
        redisTemplate.opsForList().rightPush("list1", 6);

        //      查看结果
        System.out.println("右侧插入：" + redisTemplate.opsForList().range("list1", 0, -1));

//        查看长度
        System.out.println("长度为：" + redisTemplate.opsForList().size("list1"));

//        根据下标获取元素
        System.out.println("下表为0的元素：" + redisTemplate
                .opsForList()
                .index("list1", 0));

//        左侧弹出
        Object o1 = redisTemplate.opsForList().leftPop("list1");
        System.out.println("左侧弹出元素为：" + o1);
        //      查看结果
        System.out.println("右侧插入：" + redisTemplate.opsForList().range("list1", 0, -1));

//        右侧弹出
        Object o2 = redisTemplate.opsForList().rightPop("list1");
        System.out.println("右侧弹出的元素是：" + o2);
        //      查看结果
        System.out.println("右侧插入：" + redisTemplate.opsForList().range("list1", 0, -1));

//        设置过期时间
        redisTemplate.expire("list1", 30, TimeUnit.SECONDS);
        Thread.sleep(31000);
//        判断Key是否存在
        Boolean b = redisTemplate.hasKey("list1");
        if (Boolean.TRUE.equals(b)) {
            System.out.println("list1 还存在");
        } else {
            System.out.println("list1 已经过期或不存在");
        }

        return "List 类型操作完成";
    }

    @GetMapping("/t4")
    public String t4() throws InterruptedException {
        /*
         * 自动去重
         * */
//        添加元素
        redisTemplate.opsForSet().add("list1", 1);
        redisTemplate.opsForSet().add("list1", 2);
        redisTemplate.opsForSet().add("list1", 3);
        redisTemplate.opsForSet().add("list1", 4);
        redisTemplate.opsForSet().add("list1", 5);
//        查看
        System.out.println(redisTemplate.opsForSet().members("list1"));


//        删除元素
        redisTemplate.opsForSet().remove("list1", 5);

//        查看
        System.out.println(redisTemplate.opsForSet().members("list1"));

//      判断元素是否存在
        Boolean b = redisTemplate.opsForSet().isMember("list1", 5);
        System.out.println("元素5是否存在：" + b);

//        获取集合大小
        System.out.println("集合大小为："+redisTemplate.opsForSet().size("list1"));
//        设置过期时间
        redisTemplate.expire("list1",10,TimeUnit.SECONDS);
        Thread.sleep(11000);

        Boolean b1 = redisTemplate.hasKey("list1");
        if(Boolean.TRUE.equals(b1)){
            System.out.println("key:list1,存在");
        }else {
            System.out.println("key:list1,不存在");
        }

        return "set完成";
    }

    @GetMapping("/t5")
    public String t5() throws InterruptedException {
/*
*ZSet 每个元素都会有一个：

score（分数）
* 实际应用到排行榜等
* */

//        添加元素
        redisTemplate.opsForZSet().add("list1","user1",60);
        redisTemplate.opsForZSet().add("list1","user2",70);
        redisTemplate.opsForZSet().add("list1","user3",90);
        redisTemplate.opsForZSet().add("list1","user4",100);

        System.out.println("升序");
//        查看升序排序 查询出来的是user的排行
        Set<String> set = redisTemplate.opsForZSet().range("list1",0,-1);
        for (String s :
                set) {
            System.out.println(s);
        }

        System.out.println("降序");
//        查看降序排行

        Set<String> set1 = redisTemplate.opsForZSet().reverseRange("list1",0,-1);
        for (String s :
                set1) {
            System.out.println(s);
        }
//        查看分数
        Double i = redisTemplate.opsForZSet().score("list1","user1");
        System.out.println("user1的分数是："+i);

//        删除元素
        System.out.println("删除后");
        redisTemplate.opsForZSet().remove("list1","user1");
        Set<String> set2 = redisTemplate.opsForZSet().reverseRange("list1",0,-1);
        for (String s :
                set2) {
            System.out.println(s);
        }

//        增加分数(减小分数就让100 --> -xx)
        redisTemplate.opsForZSet().incrementScore("list1","user2",100);
        System.out.println("user2分数为："+redisTemplate.opsForZSet().score("list1","user2"));

//        设置过期时间
        redisTemplate.expire("list1",10,TimeUnit.SECONDS);
        Thread.sleep(11000);
        Boolean n = redisTemplate.hasKey("list1");
        if(Boolean.TRUE.equals(n)){
            System.out.println("key存在！");
        }else {
            System.out.println("key找不到！");
        }

        return "ZSet完成";
    }

}
