package lon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 策略	           描述	                         优缺点
 * always	  每次写命令立即刷盘	          数据最安全，性能最差
 * everysec  	每秒刷盘一次	             常用，性能和安全性平衡，最多丢1秒数据
 * no	        由操作系统决定何时刷盘	              性能最好，安全性最低
 */
@RestController
public class AofRedis {
    //   先注入Redis
    @Autowired
    private RedisTemplate redisTemplate;


    //    首先开启aof
    @GetMapping("/start/aof")
    public String startAop() {
        System.out.println("111");
        redisTemplate.getConnectionFactory()
                .getConnection()
                .serverCommands()
                .setConfig("appendonly", "yes");
        return "aof已经开启";
    }


    //    设置aof策略为always
    @GetMapping("aof/always")
    public String aofalways() {
        redisTemplate.getConnectionFactory()
                .getConnection()
                .serverCommands()
                .setConfig("appendfsync", "always");
        return "aof策略设置为 always";
    }


//     设置AOF策略为everysec

    @GetMapping("/aof/everysec")
    public String aofEverysec() {
        redisTemplate.getConnectionFactory()
                .getConnection()
                .serverCommands()
                .setConfig("appendfsync", "everysec");
        return "AOF策略已设置为 everysec";
    }

    //     设置AOF策略为no
    @GetMapping("/aof/no")
    public String aofNo() {
        redisTemplate.getConnectionFactory()
                .getConnection()
                .serverCommands()
                .setConfig("appendfsync", "no");
        return "AOF策略已设置为 no";
    }

    //    测试数据
    @GetMapping("/test")
    public String test0() {
        redisTemplate.opsForValue().set("user1", "v1");
        redisTemplate.opsForValue().set("user2", "v2");
        redisTemplate.opsForValue().set("user3", "v3");
        return "测试数据已经写入了";
    }


    //    验证。先关闭redis然后重启验证
    @GetMapping("/check")
    public String check() {
        Object user1 = redisTemplate.opsForValue().get("user1");
        Object user2 = redisTemplate.opsForValue().get("user2");
        Object user3 = redisTemplate.opsForValue().get("user3");
        return "user1:     " + user1 + "    user2:    " + user2 + "    user3:     " + user3;
    }

}
