package lon.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
        redisTemplate.opsForHash().delete("Key1","3");
        System.out.println("获取全部的值： " + redisTemplate.opsForHash().entries("Key1"));

//        判断field是否存在
        Boolean success = redisTemplate.opsForHash().hasKey("Key1","3");
        System.out.println("是否存在： "+success);
//        获取所有的field
        Set<Object> list =  redisTemplate.opsForHash().keys("Key1");
        System.out.println("获取的 feild： "+list.toString());

//        获取所有的value
        List<String> list1 = redisTemplate.opsForHash().values("Key1");
        System.out.println("Values: "+list1.toString());

//        获取Hash长度

        System.out.println("hash长度为： "+redisTemplate.opsForHash().size("Key1"));

//        自增
        redisTemplate.opsForHash().increment("Key1","1",10);
        System.out.println("增加后的值为： "+redisTemplate.opsForHash().get("Key1","1"));

//        自减
        redisTemplate.opsForHash().increment("Key1","1",-5);
        System.out.println("减后的值为： "+redisTemplate.opsForHash().get("Key1","1"));
//        设置过期时间
        redisTemplate.expire("Key1",30,TimeUnit.SECONDS);

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

}
