package com.zgtong.web.common.redis;

import com.zgtong.web.common.redis.command.NBinaryJedis;
import com.zgtong.web.common.redis.command.NJedis;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class JedisWrapper {

    private ShardedJedisPool    pool;
    private NJedis jedis;
    private NBinaryJedis binaryJedis;

    private String              hosts;
    private String              password;
    private JedisPoolConfig     config = null;

    public void setConfig(JedisPoolConfig config){
        this.config = config;
    }

    public void setHosts(String hosts){
        this.hosts = hosts;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void init(){
        if (hosts == null || hosts.isEmpty()){
            throw new RuntimeException("未获取到正确的链接信息.");
        }

        if (pool != null){
            throw new RuntimeException("连接池已经初始化,请勿重复调用.");
        }

        List<String>            hps             = Arrays.asList(hosts.split(","));
        List<JedisShardInfo>    shardInfoList   = new ArrayList();

        for (String hp : hps){
            String[]    bhp     = hp.split(":");
            String      host    = bhp[0];
            int         port    = Integer.parseInt(bhp[1]);

            JedisShardInfo shard = new JedisShardInfo(host, port);

            if (!StringUtils.isEmpty(password)) {
                shard.setPassword(password);
            }

            shardInfoList.add(shard);
        }

        if(shardInfoList.isEmpty()) {
            throw new IllegalArgumentException("servers illegal: " + hosts);
        } else {
            this.pool = new ShardedJedisPool(config, shardInfoList);
        }

        jedis       = new NJedis(pool);
        binaryJedis = new NBinaryJedis(pool);
    }

    public void destroy(){
        if(pool != null)pool.close();
    }

    public NJedis getJedis(){
        return jedis;
    }

    public NBinaryJedis getBinaryJedis(){
        return binaryJedis;
    }

}
