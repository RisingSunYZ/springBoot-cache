package com.example.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
public class MyKeyGenerator implements KeyGenerator
{
    @Override
    public Object generate(Object target, Method method, Object... params) {
        System.out.println("参数="+params[0]);
        System.out.println("参数="+ Arrays.asList(params));
        return "yangzhao-"+params[0];
    }
}
