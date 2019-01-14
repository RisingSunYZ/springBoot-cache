package com.example.cache.config;

import com.example.cache.model.Department;
import com.example.cache.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class MyRedisConfig {

    @Bean
    RedisTemplate<Object,Department> deptRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object,Department> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Department.class);
        redisTemplate.setDefaultSerializer(serializer);
        return redisTemplate;
    }

    @Primary  // 有多个cacheManager需要制定一个默认的一般将jdk的cacheManager作为默认
    @Bean
    RedisCacheManager deptRedisCacheManager(RedisTemplate<Object,Department> deptRedisTemplate){
        RedisCacheManager manager = new RedisCacheManager(deptRedisTemplate);
        manager.setUsePrefix(true);// 使用前缀，默认将CacheName作为前缀
        return manager;
    }

    @Bean
    RedisTemplate<Object,Employee> employeeRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object,Employee> employeeRedisTemplate = new RedisTemplate<>();
        employeeRedisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Employee.class);
        employeeRedisTemplate.setDefaultSerializer(serializer);
        return employeeRedisTemplate;
    }

    @Bean
    RedisCacheManager empRedisCacheManager(RedisTemplate<Object,Employee> employeeRedisTemplate){
        RedisCacheManager empRedisCacheManager = new RedisCacheManager(employeeRedisTemplate);
        empRedisCacheManager.setUsePrefix(true);
        return empRedisCacheManager;
    }

}
