package com.zgtong.web.common.redis.command;

import redis.clients.jedis.*;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class NJedis extends NBinaryJedis implements JedisCommands{

    public NJedis(ShardedJedisPool pool){
        super(pool);
    }

    @Override
    public String set(String key, String value) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.set(key,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String set(String key, String value, String nxxx, String expx, long time) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.set(key,value,nxxx,expx,time);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String set(String key, String value, String nxxx) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.set(key,value,nxxx);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String get(String key) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.get(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Boolean exists(String key) {
        ShardedJedis    jedis = null;
        Boolean         result;

        try{
            jedis   = pool.getResource();
            result  = jedis.exists(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long persist(String key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.persist(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String type(String key) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.type(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long expire(String key, int seconds) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.expire(key,seconds);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long expireAt(String key, long unixTime) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.expireAt(key,unixTime);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long pexpireAt(String key, long millisecondsTimestamp) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.pexpireAt(key,millisecondsTimestamp);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long ttl(String key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.ttl(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long pttl(String key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.pttl(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Boolean setbit(String key, long offset, boolean value) {
        ShardedJedis    jedis = null;
        Boolean         result;

        try{
            jedis   = pool.getResource();
            result  = jedis.setbit(key,offset,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Boolean setbit(String key, long offset, String value) {
        ShardedJedis    jedis = null;
        Boolean         result;

        try{
            jedis   = pool.getResource();
            result  = jedis.setbit(key,offset,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Boolean getbit(String key, long offset) {
        ShardedJedis    jedis = null;
        Boolean         result;

        try{
            jedis   = pool.getResource();
            result  = jedis.getbit(key,offset);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long setrange(String key, long offset, String value) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.setrange(key,offset,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String getrange(String key, long startOffset, long endOffset) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.getrange(key,startOffset,endOffset);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String getSet(String key, String value) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.getSet(key,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long setnx(String key, String value) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.setnx(key,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String setex(String key, int seconds, String value) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.setex(key,seconds,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String psetex(String key, long milliseconds, String value) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.psetex(key,milliseconds,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long decrBy(String key, long integer) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.decrBy(key,integer);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long decr(String key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.decr(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long incrBy(String key, long integer) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.incrBy(key,integer);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Double incrByFloat(String key, double value) {
        ShardedJedis    jedis = null;
        Double          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.incrByFloat(key,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long incr(String key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.incr(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long append(String key, String value) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.append(key,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String substr(String key, int start, int end) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.substr(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long hset(String key, String field, String value) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hset(key,field,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String hget(String key, String field) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hget(key,field);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long hsetnx(String key, String field, String value) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hsetnx(key,field,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String hmset(String key, Map<String, String> hash) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hmset(key,hash);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<String> hmget(String key, String... fields) {
        ShardedJedis    jedis = null;
        List<String>    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hmget(key,fields);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long hincrBy(String key, String field, long value) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hincrBy(key,field,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Double hincrByFloat(String key, String field, double value) {
        ShardedJedis    jedis = null;
        Double            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hincrByFloat(key,field,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Boolean hexists(String key, String field) {
        ShardedJedis    jedis = null;
        Boolean         result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hexists(key,field);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long hdel(String key, String... field) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hdel(key,field);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long hlen(String key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hlen(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> hkeys(String key) {
        ShardedJedis    jedis = null;
        Set<String>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hkeys(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<String> hvals(String key) {
        ShardedJedis    jedis = null;
        List<String>    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hvals(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        ShardedJedis            jedis = null;
        Map<String, String>    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hgetAll(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long rpush(String key, String... string) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.rpush(key,string);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long lpush(String key, String... string) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.lpush(key,string);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long llen(String key) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.llen(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<String> lrange(String key, long start, long end) {
        ShardedJedis            jedis = null;
        List<String>            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.lrange(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String ltrim(String key, long start, long end) {
        ShardedJedis            jedis = null;
        String                  result;

        try{
            jedis   = pool.getResource();
            result  = jedis.ltrim(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String lindex(String key, long index) {
        ShardedJedis            jedis = null;
        String                  result;

        try{
            jedis   = pool.getResource();
            result  = jedis.lindex(key,index);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String lset(String key, long index, String value) {
        ShardedJedis            jedis = null;
        String                  result;

        try{
            jedis   = pool.getResource();
            result  = jedis.lset(key,index,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long lrem(String key, long count, String value) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.lrem(key,count,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String lpop(String key) {
        ShardedJedis            jedis = null;
        String                  result;

        try{
            jedis   = pool.getResource();
            result  = jedis.lpop(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String rpop(String key) {
        ShardedJedis            jedis = null;
        String                  result;

        try{
            jedis   = pool.getResource();
            result  = jedis.rpop(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long sadd(String key, String... member) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.sadd(key,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> smembers(String key) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.smembers(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long srem(String key, String... member) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.srem(key,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String spop(String key) {
        ShardedJedis            jedis = null;
        String                  result;

        try{
            jedis   = pool.getResource();
            result  = jedis.spop(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> spop(String key, long count) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.spop(key,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long scard(String key) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.scard(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Boolean sismember(String key, String member) {
        ShardedJedis            jedis = null;
        Boolean                 result;

        try{
            jedis   = pool.getResource();
            result  = jedis.sismember(key,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String srandmember(String key) {
        ShardedJedis            jedis = null;
        String                  result;

        try{
            jedis   = pool.getResource();
            result  = jedis.srandmember(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<String> srandmember(String key, int count) {
        ShardedJedis            jedis = null;
        List<String>            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.srandmember(key,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long strlen(String key) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.strlen(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zadd(String key, double score, String member) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zadd(key,score,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zadd(String key, double score, String member, ZAddParams params) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zadd(key,score,member,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zadd(String key, Map<String, Double> scoreMembers) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zadd(key,scoreMembers);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zadd(String key, Map<String, Double> scoreMembers, ZAddParams params) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zadd(key,scoreMembers,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> zrange(String key, long start, long end) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrange(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zrem(String key, String... member) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrem(key,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Double zincrby(String key, double score, String member) {
        ShardedJedis            jedis = null;
        Double                  result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zincrby(key,score,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Double zincrby(String key, double score, String member, ZIncrByParams params) {
        ShardedJedis            jedis = null;
        Double                  result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zincrby(key,score,member,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zrank(String key, String member) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrank(key,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zrevrank(String key, String member) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrank(key,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> zrevrange(String key, long start, long end) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrange(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrangeWithScores(String key, long start, long end) {
        ShardedJedis            jedis = null;
        Set<Tuple>              result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeWithScores(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
        ShardedJedis            jedis = null;
        Set<Tuple>              result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeWithScores(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zcard(String key) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zcard(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Double zscore(String key, String member) {
        ShardedJedis            jedis = null;
        Double                  result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zscore(key,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<String> sort(String key) {
        ShardedJedis            jedis = null;
        List<String>            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.sort(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<String> sort(String key, SortingParams sortingParameters) {
        ShardedJedis            jedis = null;
        List<String>            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.sort(key,sortingParameters);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zcount(String key, double min, double max) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zcount(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zcount(String key, String min, String max) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zcount(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> zrangeByScore(String key, double min, double max) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScore(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> zrangeByScore(String key, String min, String max) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScore(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> zrevrangeByScore(String key, double max, double min) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScore(key,max,min);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScore(key,min,max,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> zrevrangeByScore(String key, String max, String min) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScore(key,max,min);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> zrangeByScore(String key, String min, String max, int offset, int count) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScore(key,min,max,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScore(key,max,min,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
        ShardedJedis            jedis = null;
        Set<Tuple>              result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScoreWithScores(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) {
        ShardedJedis            jedis = null;
        Set<Tuple>              result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScoreWithScores(key,max,min);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {
        ShardedJedis            jedis = null;
        Set<Tuple>              result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScoreWithScores(key,min,max,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScore(key,max,min,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max) {
        ShardedJedis            jedis = null;
        Set<Tuple>              result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScoreWithScores(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min) {
        ShardedJedis            jedis = null;
        Set<Tuple>              result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScoreWithScores(key,max,min);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count) {
        ShardedJedis            jedis = null;
        Set<Tuple>              result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScoreWithScores(key,min,max,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) {
        ShardedJedis            jedis = null;
        Set<Tuple>              result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScoreWithScores(key,max,min,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min, int offset, int count) {
        ShardedJedis            jedis = null;
        Set<Tuple>              result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScoreWithScores(key,max,min,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zremrangeByRank(String key, long start, long end) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zremrangeByRank(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zremrangeByScore(String key, double start, double end) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zremrangeByScore(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zremrangeByScore(String key, String start, String end) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zremrangeByScore(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zlexcount(String key, String min, String max) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zlexcount(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> zrangeByLex(String key, String min, String max) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByLex(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> zrangeByLex(String key, String min, String max, int offset, int count) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByLex(key,min,max,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> zrevrangeByLex(String key, String max, String min) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByLex(key,max,min);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<String> zrevrangeByLex(String key, String max, String min, int offset, int count) {
        ShardedJedis            jedis = null;
        Set<String>             result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByLex(key,max,min,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zremrangeByLex(String key, String min, String max) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zremrangeByLex(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long linsert(String key, BinaryClient.LIST_POSITION where, String pivot, String value) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.linsert(key,where,pivot,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long lpushx(String key, String... string) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.lpushx(key,string);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long rpushx(String key, String... string) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.rpushx(key,string);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<String> blpop(String arg) {
        ShardedJedis            jedis = null;
        List<String>            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.blpop(arg);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<String> blpop(int timeout, String key) {
        ShardedJedis            jedis = null;
        List<String>            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.blpop(timeout,key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<String> brpop(String arg) {
        ShardedJedis            jedis = null;
        List<String>            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.brpop(arg);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<String> brpop(int timeout, String key) {
        ShardedJedis            jedis = null;
        List<String>            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.brpop(timeout,key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long del(String key) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.del(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String echo(String string) {
        ShardedJedis            jedis = null;
        String                  result;

        try{
            jedis   = pool.getResource();
            result  = jedis.echo(string);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long move(String key, int dbIndex) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.move(key,dbIndex);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long bitcount(String key) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.bitcount(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long bitcount(String key, long start, long end) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.bitcount(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long bitpos(String key, boolean value) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.bitpos(key,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long bitpos(String key, boolean value, BitPosParams params) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.bitpos(key,value,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, int cursor) {
        ShardedJedis            jedis = null;
        ScanResult<Map.Entry<String, String>>   result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hscan(key,cursor);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public ScanResult<String> sscan(String key, int cursor) {
        ShardedJedis            jedis = null;
        ScanResult<String>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.sscan(key,cursor);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public ScanResult<Tuple> zscan(String key, int cursor) {
        ShardedJedis            jedis = null;
        ScanResult<Tuple>       result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zscan(key,cursor);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor) {
        ShardedJedis            jedis = null;
        ScanResult<Map.Entry<String, String>>       result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hscan(key,cursor);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor, ScanParams params) {
        ShardedJedis            jedis = null;
        ScanResult<Map.Entry<String, String>>       result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hscan(key,cursor,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public ScanResult<String> sscan(String key, String cursor) {
        ShardedJedis            jedis = null;
        ScanResult<String>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.sscan(key,cursor);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public ScanResult<String> sscan(String key, String cursor, ScanParams params) {
        ShardedJedis            jedis = null;
        ScanResult<String>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.sscan(key,cursor,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public ScanResult<Tuple> zscan(String key, String cursor) {
        ShardedJedis            jedis = null;
        ScanResult<Tuple>       result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zscan(key,cursor);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public ScanResult<Tuple> zscan(String key, String cursor, ScanParams params) {
        ShardedJedis            jedis = null;
        ScanResult<Tuple>       result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zscan(key,cursor,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long pfadd(String key, String... elements) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.pfadd(key,elements);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public long pfcount(String key) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.pfcount(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long geoadd(String key, double longitude, double latitude, String member) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.geoadd(key,longitude,latitude,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long geoadd(String key, Map<String, GeoCoordinate> memberCoordinateMap) {
        ShardedJedis            jedis = null;
        Long                    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.geoadd(key,memberCoordinateMap);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Double geodist(String key, String member1, String member2) {
        ShardedJedis            jedis = null;
        Double                  result;

        try{
            jedis   = pool.getResource();
            result  = jedis.geodist(key,member1,member2);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Double geodist(String key, String member1, String member2, GeoUnit unit) {
        ShardedJedis            jedis = null;
        Double                  result;

        try{
            jedis   = pool.getResource();
            result  = jedis.geodist(key,member1,member2,unit);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<String> geohash(String key, String... members) {
        ShardedJedis            jedis = null;
        List<String>            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.geohash(key,members);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<GeoCoordinate> geopos(String key, String... members) {
        ShardedJedis            jedis = null;
        List<GeoCoordinate>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.geopos(key,members);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit) {
        ShardedJedis            jedis = null;
        List<GeoRadiusResponse> result;

        try{
            jedis   = pool.getResource();
            result  = jedis.georadius(key,longitude,latitude,radius,unit);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
        ShardedJedis            jedis = null;
        List<GeoRadiusResponse> result;

        try{
            jedis   = pool.getResource();
            result  = jedis.georadius(key,longitude,latitude,radius,unit,param);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit) {
        ShardedJedis            jedis = null;
        List<GeoRadiusResponse> result;

        try{
            jedis   = pool.getResource();
            result  = jedis.georadiusByMember(key,member,radius,unit);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit, GeoRadiusParam param) {
        ShardedJedis            jedis = null;
        List<GeoRadiusResponse> result;

        try{
            jedis   = pool.getResource();
            result  = jedis.georadiusByMember(key,member,radius,unit,param);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<Long> bitfield(String key, String... arguments) {
        ShardedJedis            jedis = null;
        List<Long>              result;

        try{
            jedis   = pool.getResource();
            result  = jedis.bitfield(key,arguments);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) if(jedis != null) jedis.close();
        }

        return result;
    }
}
