package com.example.redisdemo;

import com.example.redisdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepo {

    @Lazy
    @Autowired
    private RedisTemplate redisTemplate;

    private static List<User> users = new ArrayList();

    private static final String KEY = "USER";

    public List<User> getAll() {
        return redisTemplate.opsForHash().values(KEY);
    }

    public User add(User user) {
        users.add(user);
        return user;
    }

    public void reloadCache() {
        //redisTemplate.opsForStream().delete(KEY);
        redisTemplate.opsForHash().values(KEY).clear();
        users.stream()
                .forEach(user -> redisTemplate.opsForHash().put(KEY, user.getId(), user));
    }
}
