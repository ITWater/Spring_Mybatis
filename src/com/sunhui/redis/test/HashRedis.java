package com.sunhui.redis.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class HashRedis {
	@Test
	public void HashRedisTest() {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) context.getBean("RedisTemplate.class");
		String key = "hash";
		Map<String,String> map = new HashMap<String,String>();
		map.put("f1","val1");
		map.put("f2","val2");
		
		redisTemplate.opsForHash().putAll(key,map);
		
		redisTemplate.opsForHash().put(key, "f3","6");
		
		
	}
}
