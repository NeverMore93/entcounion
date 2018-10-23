package com.microfocus.entcounion.cache;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;

public class RedisUserCache implements UserCache {

    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Override
    public UserDetails getUserFromCache(String username) {
        return null;
    }

    @Override
    public void putUserInCache(UserDetails user) {

    }

    @Override
    public void removeUserFromCache(String username) {

    }
}
