package com.unionman.springbootredis1.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Zhifeng.Zeng
 * @descrption Redis生产者
 * @date 2020/05/20 09:42
 */
@Component
public class RedisProducer {


    @Autowired
    private RedisTemplate redisTemplate;

    public void sendMessage(String message){

        redisTemplate.opsForList().leftPush("TOPIC_MESSAGE",message);

        System.out.println("已发送消息到TOPIC_MESSAGE  ： "+message);
    }


}
