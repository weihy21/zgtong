package com.zgtong.web.common.redis.lock;


import com.zgtong.web.common.redis.JedisWrapper;
import com.zgtong.web.common.redis.command.NJedis;

import javax.annotation.Resource;

/**
 * Description: JedisLock 基于redis 的分布式锁
 *
 */
public class JedisLock {

    @Resource
    private JedisWrapper jedisWrapper;

    private static ThreadLocal<Long> EXPIRE_FLAG = new ThreadLocal<>();

    /**
     * 尝试在等待时间范围内 , 获取锁
     *
     * @param monitor
     * @param waittingTime      等待时间,单位:秒
     * @param maxOperationTime  锁定有效期
     * @return
     */
    public boolean getLock(String monitor , int waittingTime ,  int maxOperationTime){
        int waittingLimit = waittingTime*1000;
        int preTime = 20;
        int waittingNum = 0;

        for(;waittingNum < waittingLimit;waittingNum = waittingNum+preTime){
            if (tryLock(monitor,maxOperationTime)){
                return true;
            }else{
                try {Thread.sleep(preTime);} catch (InterruptedException e) {}
            }
        }

        return false;

    }

    public boolean tryLock(String monitor , int maxOperationTime){
        NJedis jedis       = jedisWrapper.getJedis();
        long    timestamp   = System.currentTimeMillis() + maxOperationTime * 1000 + 1;
        long    exist       = 0;

        exist = jedis.setnx(monitor, String.valueOf(timestamp));

        // 无论如何 , 都去检查是否设置了超时时间 .
        if (jedis.ttl(monitor) == -1) {
            // 根据并发量评估超时时间，设置成一个最大并发值在串行情况下不可能超出的时间值
            jedis.expire(monitor, maxOperationTime);
        }

        if (exist == 1) {
            EXPIRE_FLAG.set(timestamp);
            return true;
        }

        return false;
    }

    /**
     * 当前线程未获得锁 或者 锁定超时 则无法释放.
     * @param monitor
     */
    public void unLock(String monitor){
        NJedis jedis = jedisWrapper.getJedis();
        // 判断锁定状态
        if (EXPIRE_FLAG.get() == null || EXPIRE_FLAG.get() < System.currentTimeMillis() - 20){
            return;
        }

        try{
            jedis.del(monitor);
        }catch(Exception e){
            // 忽略.
        }
    }
}
