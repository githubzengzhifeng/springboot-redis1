package com.unionman.springbootredis1.controller;

import com.unionman.springbootredis1.queue.RedisProducer;
import com.unionman.springbootredis1.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zhifeng.Zeng
 * @descrption
 * @date 2020/05/20 10:24
 */
@RestController
@RequestMapping("redis")
public class RedisTestController {

    @Autowired
    private RedisProducer redisProducer;

    @Autowired
    private RedisUtils redisUtils;

    @PostMapping("/cache")
    public String addCache(String key,String value){

        //-1代表永久,>-1以秒为单位
        redisUtils.set(key,value,-1L);

        return "success";
    }

    @GetMapping("/cache")
    public String getCache( String key){

        String cache = redisUtils.get(key, String.class);

        return cache;
    }

    @PutMapping("/cache")
    public String updateCache(String key,String value){

        //-1代表永久,>-1以秒为单位
        redisUtils.set(key,value,-1L);

        return "success";
    }

    @DeleteMapping("/cache/{key}")
    public String deleteCache(@PathVariable("key")String key){

        redisUtils.deleteCache(key);

        return "success";
    }

    /**
     * Redis实现消息队列
     * @param message
     * @return
     */
    @PostMapping("/message/sending")
    public String sendMessage(String message){

        redisProducer.sendMessage(message);

        return "success";
    }

}
