package com.zgtong.web.common.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class JedisPoolUtil {

    private JedisPoolConfig config = null;
    private String hosts;
    private List<JedisPool> jedisPools = new ArrayList<>();

    public void setConfig(JedisPoolConfig config) {
        this.config = config;
    }

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }

    public void init(){
        if (hosts == null || hosts.isEmpty()){
            throw new RuntimeException("未获取到正确的链接信息.");
        }

        if (jedisPools != null && jedisPools.size()>0){
            throw new RuntimeException("连接池已经初始化,请勿重复调用.");
        }
        List<String> hps = Arrays.asList(hosts.split(","));
        for (String hp : hps){
            String[]    bhp     = hp.split(":");
            String      host    = bhp[0];
            int         port    = Integer.parseInt(bhp[1]);

           JedisPool jedisPool = new JedisPool(config,host,port);
           jedisPools.add(jedisPool);
        }
    }

    public void destroy(){
        if(jedisPools != null && jedisPools.size()>0){
            for(JedisPool pool : jedisPools){
                pool.close();
            }
        }
    }

    public List<JedisPool> getJedisPools(){
        return jedisPools;
    }
}
