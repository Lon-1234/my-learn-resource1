package lon.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * RDB 持久化学习
 * <p>
 * RDB:
 * Redis DataBase
 * <p>
 * 本质：
 * 给 Redis 当前数据拍快照
 * <p>
 * 默认生成：
 * dump.rdb
 * <p>
 * RDB 三种触发方式：
 * <p>
 * 1 SAVE
 * 同步保存（阻塞）
 * <p>
 * 2 BGSAVE
 * 后台保存（推荐）
 * <p>
 * 3 自动触发
 * save 900 1
 * save 300 10
 * save 60 10000
 * <p>
 * 注意：
 * RDB 三种方式最终生成的都是：
 * <p>
 * dump.rdb
 * <p>
 * 不会生成三个文件
 */
@RestController
public class RdbController {

    @Resource
    private RedisTemplate redisTemplate;


    //    存入测试数据
    @GetMapping("/rdb/test")
    public String test() {
        redisTemplate.opsForValue().set("list0", "long");
        redisTemplate.opsForValue().set("age", "20");
        redisTemplate.opsForValue().set("city", "shanghai");
        return "数据已经写入";
    }

    //    SAVE
    /*
     Redis主进程
      ↓
    生成 dump.rdb
      ↓
    保存完成
      ↓
    继续工作
    问题：保存期间无法处理请求
    */
    @GetMapping("rdb/save")
    public String save() {
        redisTemplate.getConnectionFactory()
                .getConnection()
                .serverCommands()
                .save();
        return "SAVE执行成功";
    }

    /*
    Redis主进程
      ↓
    fork子进程
      ↓
    子进程生成dump.rdb
      ↓
    主进程继续处理请求

    这是生产环境真正使用的方式
     */
//    BGSAVE
    @GetMapping("/rdb/bgsave")
    public String bgsave(){
        redisTemplate.getConnectionFactory()
                .getConnection()
                .serverCommands()
                .bgSave();
        return "BGSAVE执行成功";
    }
    @GetMapping("/rdb/check")
    public String checkRdb() {

        Object name = redisTemplate.opsForValue().get("list0");
        Object age = redisTemplate.opsForValue().get("age");
        Object city = redisTemplate.opsForValue().get("city");
        return "name=" + name + ", age=" + age + ", city=" + city;
    }

    @GetMapping("/flushDb")
    public String flushDb() {

        redisTemplate.getConnectionFactory()
                .getConnection()
                .serverCommands()
                .flushDb();

        return "当前数据库所有Key已清空";
    }

    class RDB {

//        RDB的第3种方式步骤
//        RDB第三种方式：自动 save 配置
//
//        一、什么是自动 save
//
//        自动 save 是 Redis 自动触发 RDB 的方式。
//
//        本质：
//
//        Redis 自动执行 BGSAVE。
//
//        所以：
//
//        自动 save ≠ SAVE
//
//        自动 save = 自动执行 BGSAVE
//
//        不会阻塞 Redis 主进程。
//
//
//        二、工作流程
//
//                Redis运行
//    ↓
//        用户不断修改数据
//    ↓
//        达到配置条件
//    ↓
//        Redis自动执行BGSAVE
//    ↓
//        fork子进程
//    ↓
//        生成dump.rdb
//    ↓
//        主进程继续处理请求
//
//
//        三、查看当前RDB配置
//
//        启动Redis客户端：
//
//        redis-cli
//
//        执行：
//
//        CONFIG GET save
//
//        例如返回：
//
//        save
//900 1 300 10 60 10000
//
//        说明：
//
//                900秒修改1次触发RDB
//
//300秒修改10次触发RDB
//
//60秒修改10000次触发RDB
//
//
//        四、修改redis配置文件
//
//        找到：
//
//        redis.windows.conf
//
//        或者：
//
//        redis.conf
//
//        使用记事本打开。
//
//        搜索：
//
//        save
//
//        可能看到：
//
//        save 900 1
//        save 300 10
//        save 60 10000
//
//
//        五、配置解释
//
//        save 900 1
//
//        含义：
//
//                900秒（15分钟）内
//
//                至少修改1次数据
//
//        自动执行BGSAVE
//
//
//        save 300 10
//
//        含义：
//
//                300秒（5分钟）内
//
//                至少修改10次数据
//
//        自动执行BGSAVE
//
//
//        save 60 10000
//
//        含义：
//
//                60秒内
//
//                至少修改10000次数据
//
//        自动执行BGSAVE
//
//
//        六、自定义配置示例
//
//        例如：
//
//        save 60 1
//
//        表示：
//
//                60秒内
//
//                只要修改1次数据
//
//        就自动生成RDB。
//
//
//        例如：
//
//        save 30 5
//
//        表示：
//
//                30秒内
//
//                修改5次数据
//
//        自动生成RDB。
//
//
//        七、关闭自动RDB
//
//        配置文件中：
//
//        把所有save注释掉：
//
//                # save 900 1
//                # save 300 10
//                # save 60 10000
//
//        或者：
//
//        save ""
//
//        作用：
//
//        关闭自动RDB。
//
//        注意：
//
//        关闭后只能手动执行：
//
//        SAVE
//
//        或者：
//
//        BGSAVE
//
//
//        八、重启Redis
//
//        修改配置文件后：
//
//        关闭Redis
//
//        重新启动：
//
//        redis-server.exe redis.windows.conf
//
//        或者：
//
//        redis-server.exe redis.conf
//
//        配置才能生效。
//
//
//        九、测试自动RDB
//
//        第一步：
//
//        配置：
//
//        save 60 1
//
//        第二步：
//
//        启动Redis
//
//        第三步：
//
//        进入客户端：
//
//        redis-cli
//
//        第四步：
//
//        写入数据：
//
//        set name long
//
//        第五步：
//
//        等待60秒
//
//        Redis会自动执行：
//
//        BGSAVE
//
//        生成：
//
//        dump.rdb
//
//
//        十、查看RDB是否生成
//
//        查看保存目录：
//
//        CONFIG GET dir
//
//        查看文件名：
//
//        CONFIG GET dbfilename
//
//        一般返回：
//
//        dump.rdb
//
//        进入目录即可看到：
//
//        dump.rdb
//
//
//        十一、自动save总结
//
//        自动save本质：
//
//        自动执行BGSAVE
//
//                不会阻塞Redis
//
//        触发条件：
//
//        save 秒数 修改次数
//
//        例如：
//
//        save 900 1
//        save 300 10
//        save 60 10000
//
//        满足任意一个条件：
//
//        Redis都会自动执行BGSAVE
//
//        最终生成：
//
//        dump.rdb
//
//        不会生成多个RDB文件。
    }

}
