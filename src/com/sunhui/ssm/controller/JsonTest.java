package com.sunhui.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunhui.ssm.pojo.ItemsCustom;

/**
 * 
 * <p>Title: JsonTest</p>
 * <p>Description:json交互测试 </p>
 * <p>Company:www.hailun.online</p>
 * @author sunhui
 * @date 2018年4月25日
 * @version 1.0
 */
@Controller
public class JsonTest {
	//请求json，输出json
	//@RequestBody将请求的商品信息的json串转成itemsCustom对象
	//@ResponseBody将itemsCustom对象转成json输出
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) {
		
		//@Response将itemsCustom转成json输出
		return itemsCustom ;
	}
	
	//请求key/value，输出json
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom) {
		//@ResponseBody将itemsCustom转成json输出
		return itemsCustom; 
	}
}
