package com.sunhui.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sunhui.ssm.pojo.Admin;
import com.sunhui.ssm.service.ItemsService;

@Controller
public class LoginController {
	
	@Autowired
	private ItemsService itemsService ;
	
	//登陆
	@RequestMapping(value="/login")
	public String login(HttpSession session ,Admin admin) throws Exception {
		
		//调用service进行用户身份验证
		Admin admin2 =  itemsService.selectByAdmin(admin.getUsername(),admin.getPassword());
		
		//在session中保存用户身份信息
		session.setAttribute("admin2",admin2);
		//重定向到商品列表页面
		return "redirect:items/queryItems.action";
	}
	
	
	//退出
	@RequestMapping(value="/logout")
	public String logout(HttpSession session)throws Exception{
		
		//清除session
		session.invalidate();
		
		//重定向到商品列表页面
		return "redirect:items/queryItems.action";
	}
}
