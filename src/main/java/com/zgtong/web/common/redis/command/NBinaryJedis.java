package com.zgtong.web.common.redis.command;

import redis.clients.jedis.*;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 */
public class NBinaryJedis implements BinaryJedisCommands,Closeable {

    protected ShardedJedisPool pool;

    public NBinaryJedis(ShardedJedisPool pool){
        this.pool = pool;
    }

    @Override
    public void close() throws IOException {
    }

    @Override
    public String set(byte[] key, byte[] value) {
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
    public String set(byte[] key, byte[] value, byte[] nxxx) {
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
    public String set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, long time) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.set(key,value,nxxx,expx,time);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public byte[] get(byte[] key) {
        ShardedJedis    jedis = null;
        byte[]          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.get(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Boolean exists(byte[] key) {
        ShardedJedis    jedis = null;
        Boolean         result;

        try{
            jedis   = pool.getResource();
            result  = jedis.exists(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long persist(byte[] key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.persist(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String type(byte[] key) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.type(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long expire(byte[] key, int seconds) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.expire(key,seconds);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long pexpire(String key, long milliseconds) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.pexpire(key,milliseconds);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long pexpire(byte[] key, long milliseconds) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.pexpire(key,milliseconds);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long expireAt(byte[] key, long unixTime) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.expireAt(key,unixTime);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long pexpireAt(byte[] key, long millisecondsTimestamp) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.pexpireAt(key,millisecondsTimestamp);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long ttl(byte[] key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.ttl(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Boolean setbit(byte[] key, long offset, boolean value) {
        ShardedJedis    jedis = null;
        Boolean         result;

        try{
            jedis   = pool.getResource();
            result  = jedis.setbit(key,offset,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Boolean setbit(byte[] key, long offset, byte[] value) {
        ShardedJedis    jedis = null;
        Boolean         result;

        try{
            jedis   = pool.getResource();
            result  = jedis.setbit(key,offset,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Boolean getbit(byte[] key, long offset) {
        ShardedJedis    jedis = null;
        Boolean         result;

        try{
            jedis   = pool.getResource();
            result  = jedis.getbit(key,offset);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long setrange(byte[] key, long offset, byte[] value) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.setrange(key,offset,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public byte[] getrange(byte[] key, long startOffset, long endOffset) {
        ShardedJedis    jedis = null;
        byte[]          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.getrange(key,startOffset,endOffset);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public byte[] getSet(byte[] key, byte[] value) {
        ShardedJedis    jedis = null;
        byte[]          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.getSet(key,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long setnx(byte[] key, byte[] value) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.setnx(key,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String setex(byte[] key, int seconds, byte[] value) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.setex(key,seconds,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long decrBy(byte[] key, long integer) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.decrBy(key,integer);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long decr(byte[] key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.decr(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long incrBy(byte[] key, long integer) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.incrBy(key,integer);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Double incrByFloat(byte[] key, double value) {
        ShardedJedis    jedis = null;
        Double           result;

        try{
            jedis   = pool.getResource();
            result  = jedis.incrByFloat(key,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long incr(byte[] key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.incr(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long append(byte[] key, byte[] value) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.append(key,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public byte[] substr(byte[] key, int start, int end) {
        ShardedJedis    jedis = null;
        byte[]          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.substr(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long hset(byte[] key, byte[] field, byte[] value) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hset(key,field,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public byte[] hget(byte[] key, byte[] field) {
        ShardedJedis    jedis = null;
        byte[]          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hget(key,field);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long hsetnx(byte[] key, byte[] field, byte[] value) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hsetnx(key,field,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String hmset(byte[] key, Map<byte[], byte[]> hash) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hmset(key,hash);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<byte[]> hmget(byte[] key, byte[]... fields) {
        ShardedJedis    jedis = null;
        List<byte[]>    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hmget(key,fields);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long hincrBy(byte[] key, byte[] field, long value) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hincrBy(key,field,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Double hincrByFloat(byte[] key, byte[] field, double value) {
        ShardedJedis    jedis = null;
        Double          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hincrByFloat(key,field,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Boolean hexists(byte[] key, byte[] field) {
        ShardedJedis    jedis = null;
        Boolean         result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hexists(key,field);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long hdel(byte[] key, byte[]... field) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hdel(key,field);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long hlen(byte[] key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hlen(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> hkeys(byte[] key) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hkeys(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Collection<byte[]> hvals(byte[] key) {
        ShardedJedis        jedis = null;
        Collection<byte[]>  result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hvals(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Map<byte[], byte[]> hgetAll(byte[] key) {
        ShardedJedis        jedis = null;
        Map<byte[], byte[]> result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hgetAll(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long rpush(byte[] key, byte[]... args) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.rpush(key,args);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long lpush(byte[] key, byte[]... args) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.lpush(key,args);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long llen(byte[] key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.llen(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<byte[]> lrange(byte[] key, long start, long end) {
        ShardedJedis    jedis = null;
        List<byte[]>    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.lrange(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String ltrim(byte[] key, long start, long end) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.ltrim(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public byte[] lindex(byte[] key, long index) {
        ShardedJedis    jedis = null;
        byte[]          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.lindex(key,index);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public String lset(byte[] key, long index, byte[] value) {
        ShardedJedis    jedis = null;
        String          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.lset(key,index,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long lrem(byte[] key, long count, byte[] value) {
        ShardedJedis    jedis = null;
        Long          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.lrem(key,count,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public byte[] lpop(byte[] key) {
        ShardedJedis    jedis = null;
        byte[]          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.lpop(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public byte[] rpop(byte[] key) {
        ShardedJedis    jedis = null;
        byte[]          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.rpop(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long sadd(byte[] key, byte[]... member) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.sadd(key,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> smembers(byte[] key) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.smembers(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long srem(byte[] key, byte[]... member) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.srem(key,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public byte[] spop(byte[] key) {
        ShardedJedis    jedis = null;
        byte[]          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.spop(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> spop(byte[] key, long count) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.spop(key,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long scard(byte[] key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.scard(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Boolean sismember(byte[] key, byte[] member) {
        ShardedJedis    jedis = null;
        Boolean         result;

        try{
            jedis   = pool.getResource();
            result  = jedis.sismember(key,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public byte[] srandmember(byte[] key) {
        ShardedJedis    jedis = null;
        byte[]          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.srandmember(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<byte[]> srandmember(byte[] key, int count) {
        ShardedJedis    jedis = null;
        List<byte[]>    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.srandmember(key,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long strlen(byte[] key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.strlen(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zadd(byte[] key, double score, byte[] member) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zadd(key,score,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zadd(byte[] key, double score, byte[] member, ZAddParams params) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zadd(key,score,member,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zadd(key,scoreMembers);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers, ZAddParams params) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zadd(key,scoreMembers,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> zrange(byte[] key, long start, long end) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrange(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zrem(byte[] key, byte[]... member) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrem(key,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Double zincrby(byte[] key, double score, byte[] member) {
        ShardedJedis    jedis = null;
        Double          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zincrby(key,score,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Double zincrby(byte[] key, double score, byte[] member, ZIncrByParams params) {
        ShardedJedis    jedis = null;
        Double          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zincrby(key,score,member,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zrank(byte[] key, byte[] member) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrank(key,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zrevrank(byte[] key, byte[] member) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrank(key,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> zrevrange(byte[] key, long start, long end) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrange(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrangeWithScores(byte[] key, long start, long end) {
        ShardedJedis    jedis = null;
        Set<Tuple>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeWithScores(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrevrangeWithScores(byte[] key, long start, long end) {
        ShardedJedis    jedis = null;
        Set<Tuple>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeWithScores(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zcard(byte[] key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zcard(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Double zscore(byte[] key, byte[] member) {
        ShardedJedis    jedis = null;
        Double          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zscore(key,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<byte[]> sort(byte[] key) {
        ShardedJedis    jedis = null;
        List<byte[]>    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.sort(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<byte[]> sort(byte[] key, SortingParams sortingParameters) {
        ShardedJedis    jedis = null;
        List<byte[]>    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.sort(key,sortingParameters);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zcount(byte[] key, double min, double max) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zcount(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zcount(byte[] key, byte[] min, byte[] max) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zcount(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> zrangeByScore(byte[] key, double min, double max) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScore(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScore(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScore(key,max,min);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> zrangeByScore(byte[] key, double min, double max, int offset, int count) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScore(key,min,max,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScore(key,max,min);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max, int offset, int count) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScore(key,min,max,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min, int offset, int count) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScore(key,max,min,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max) {
        ShardedJedis    jedis = null;
        Set<Tuple>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScoreWithScores(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min) {
        ShardedJedis    jedis = null;
        Set<Tuple>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScoreWithScores(key,max,min);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max, int offset, int count) {
        ShardedJedis    jedis = null;
        Set<Tuple>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScoreWithScores(key,min,max,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min, int offset, int count) {
        ShardedJedis    jedis = null;
        Set<byte[]>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScore(key,max,min,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max) {
        ShardedJedis    jedis = null;
        Set<Tuple>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScoreWithScores(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min) {
        ShardedJedis    jedis = null;
        Set<Tuple>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScoreWithScores(key,max,min);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max, int offset, int count) {
        ShardedJedis    jedis = null;
        Set<Tuple>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByScoreWithScores(key,min,max,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min, int offset, int count) {
        ShardedJedis    jedis = null;
        Set<Tuple>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScoreWithScores(key,max,min,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min, int offset, int count) {
        ShardedJedis    jedis = null;
        Set<Tuple>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByScoreWithScores(key,max,min,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zremrangeByRank(byte[] key, long start, long end) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zremrangeByRank(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zremrangeByScore(byte[] key, double start, double end) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zremrangeByScore(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zremrangeByScore(byte[] key, byte[] start, byte[] end) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zremrangeByScore(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zlexcount(byte[] key, byte[] min, byte[] max) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zlexcount(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> zrangeByLex(byte[] key, byte[] min, byte[] max) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByLex(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> zrangeByLex(byte[] key, byte[] min, byte[] max, int offset, int count) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrangeByLex(key,min,max,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> zrevrangeByLex(byte[] key, byte[] max, byte[] min) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByLex(key,max,min);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Set<byte[]> zrevrangeByLex(byte[] key, byte[] max, byte[] min, int offset, int count) {
        ShardedJedis    jedis = null;
        Set<byte[]>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zrevrangeByLex(key,max,min,offset,count);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long zremrangeByLex(byte[] key, byte[] min, byte[] max) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zremrangeByLex(key,min,max);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long linsert(byte[] key, BinaryClient.LIST_POSITION where, byte[] pivot, byte[] value) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.linsert(key,where,pivot,value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long lpushx(byte[] key, byte[]... arg) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.lpushx(key,arg);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long rpushx(byte[] key, byte[]... arg) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.rpushx(key,arg);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<byte[]> blpop(byte[] arg) {
        ShardedJedis    jedis = null;
        List<byte[]>    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.blpop(arg);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<byte[]> brpop(byte[] arg) {
        ShardedJedis    jedis = null;
        List<byte[]>    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.brpop(arg);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long del(byte[] key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.del(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public byte[] echo(byte[] arg) {
        ShardedJedis    jedis = null;
        byte[]          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.echo(arg);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long move(byte[] key, int dbIndex) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.move(key,dbIndex);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long bitcount(byte[] key) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.bitcount(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long bitcount(byte[] key, long start, long end) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.bitcount(key,start,end);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long pfadd(byte[] key, byte[]... elements) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.pfadd(key,elements);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public long pfcount(byte[] key) {
        ShardedJedis    jedis = null;
        Long            result = 0L;

        try{
            jedis   = pool.getResource();
            result  = jedis.pfcount(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long geoadd(byte[] key, double longitude, double latitude, byte[] member) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.geoadd(key,longitude,latitude,member);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Long geoadd(byte[] key, Map<byte[], GeoCoordinate> memberCoordinateMap) {
        ShardedJedis    jedis = null;
        Long            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.geoadd(key,memberCoordinateMap);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Double geodist(byte[] key, byte[] member1, byte[] member2) {
        ShardedJedis    jedis = null;
        Double          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.geodist(key,member1,member2);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public Double geodist(byte[] key, byte[] member1, byte[] member2, GeoUnit unit) {
        ShardedJedis    jedis = null;
        Double          result;

        try{
            jedis   = pool.getResource();
            result  = jedis.geodist(key,member1,member2,unit);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<byte[]> geohash(byte[] key, byte[]... members) {
        ShardedJedis    jedis = null;
        List<byte[]>    result;

        try{
            jedis   = pool.getResource();
            result  = jedis.geohash(key,members);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<GeoCoordinate> geopos(byte[] key, byte[]... members) {
        ShardedJedis            jedis = null;
        List<GeoCoordinate>     result;

        try{
            jedis   = pool.getResource();
            result  = jedis.geopos(key,members);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<GeoRadiusResponse> georadius(byte[] key, double longitude, double latitude, double radius, GeoUnit unit) {
        ShardedJedis            jedis = null;
        List<GeoRadiusResponse> result;

        try{
            jedis   = pool.getResource();
            result  = jedis.georadius(key,longitude,latitude,radius,unit);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<GeoRadiusResponse> georadius(byte[] key, double longitude, double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
        ShardedJedis            jedis = null;
        List<GeoRadiusResponse> result;

        try{
            jedis   = pool.getResource();
            result  = jedis.georadius(key,longitude,latitude,radius,unit,param);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMember(byte[] key, byte[] member, double radius, GeoUnit unit) {
        ShardedJedis            jedis = null;
        List<GeoRadiusResponse> result;

        try{
            jedis   = pool.getResource();
            result  = jedis.georadiusByMember(key,member,radius,unit);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMember(byte[] key, byte[] member, double radius, GeoUnit unit, GeoRadiusParam param) {
        ShardedJedis            jedis = null;
        List<GeoRadiusResponse> result;

        try{
            jedis   = pool.getResource();
            result  = jedis.georadiusByMember(key,member,radius,unit,param);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor) {
        ShardedJedis            jedis = null;
        ScanResult<Map.Entry<byte[], byte[]>> result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hscan(key,cursor);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor, ScanParams params) {
        ShardedJedis            jedis = null;
        ScanResult<Map.Entry<byte[], byte[]>> result;

        try{
            jedis   = pool.getResource();
            result  = jedis.hscan(key,cursor,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor) {
        ShardedJedis            jedis = null;
        ScanResult<byte[]>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.sscan(key,cursor);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor, ScanParams params) {
        ShardedJedis            jedis = null;
        ScanResult<byte[]>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.sscan(key,cursor,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor) {
        ShardedJedis            jedis = null;
        ScanResult<Tuple>      result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zscan(key,cursor);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor, ScanParams params) {
        ShardedJedis            jedis = null;
        ScanResult<Tuple>       result;

        try{
            jedis   = pool.getResource();
            result  = jedis.zscan(key,cursor,params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }

    @Override
    public List<byte[]> bitfield(byte[] key, byte[]... arguments) {
        ShardedJedis            jedis = null;
        List<byte[]>            result;

        try{
            jedis   = pool.getResource();
            result  = jedis.bitfield(key,arguments);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(jedis != null) jedis.close();
        }

        return result;
    }
}
