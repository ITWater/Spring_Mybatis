package com.sunhui.redis.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisDemo {
	@Test
	public void redisDemo() {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) context.getBean("redisTemplate");
		User user = new  User ();
		user.setId(1L);
		user.setUserName("user_name_1");
		user.setNote("Note1");
		//将user对象存储到redis缓存中
		redisTemplate.opsForValue().set("user_1",user);
		//从redis缓存中获取user对象
		User user1 = (User)redisTemplate.opsForValue().get("user_1");
		System.out.println(user1.getUserName());
	}
}
