package com.mcl.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yz on 2018/2/9.
 */
@Component
public class RedisUtil {

    public static JedisPool jedisPool = new JedisPool();

    private static Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    private static final Integer OVERTIME = 60*60*24*7 ;//默认七天过期

    public void setFormId(String openid,String formid){

        Jedis jedis = jedisPool.getResource();

        jedis.sadd(openid,formid);

        jedis.expire(openid,OVERTIME);



    }

    public String getFormId(String openid){

        Jedis jedis = jedisPool.getResource();

        for(int i=0;i<3;i++){
            String formid = jedis.spop(openid);
            if(StringUtils.isNotBlank(formid)){
                return formid;
            }
        }
        return null ;
    }


}
