package lon.controller;


import org.springframework.web.bind.annotation.RestController;


/**
 * 学习缓存和缓存优化
 *
 *
 * 缓存基础核心概念
 * 1.缓存命中： 数据在缓存中找到
 * 2.缓存未命中： 数据在缓存中未找到
 * 缓存淘汰策略：LRU、LFU、FIFO
 *
 *
 * （1）.FIFO: 先进先出，哪个存得最早那个就先销毁
 * （2）.LRU: 最近使用最少 时间越往前，越先删除
 * （3）.LFU: 最不经常使用 看访问次数，次数越少越先删除
 *
 *
 * 缓存问题：
 *
 *
 * 缓存穿透：查询一个数据库不存在的数据 → 缓存空对象 + 短时间过期
 * 缓存击穿：热点数据失效 → 使用互斥锁或队列让请求排队
 * 缓存雪崩：大量 key 同时失效 → 设置不同过期时间，或使用缓存预热
 *
 *
 */
@RestController
public class CachRedisController {


}
