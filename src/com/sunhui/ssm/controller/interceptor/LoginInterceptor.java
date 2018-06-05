package com.sunhui.ssm.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
* <p>Title: LoginInterceptor</p>  
* <p>Description:登陆认证拦截器 </p>  
* @author sunhui 
* @date 2018年4月25日
 */
//拦截器是基于aop的
public class LoginInterceptor implements HandlerInterceptor {
	
	//进入handler方法之后，返回modelAndView之前执行
	//应用场景从modelAndView出发：将公用的模型数据（比如菜单导航）在这里传到视图，也可以在这里面统一指定视图
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("HandlerLoginInterceptor--------afterCompletion");
	}

	//执行handler完成执行此方法
	//应用场景：统一的异常处理，统一的日志处理
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("HandlerLoginInterceptor--------postHandle");
	}

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//获取请求的url
		String url = request.getRequestURI();
		//获取session对象
		HttpSession session = request.getSession();
		//System.out.println(url+"----"+url.indexOf("login.action"));
		//判断url是否公开地址
		//这里公开地址是登录提交的地址
		if(url.indexOf("login.action")>=0) {
			return true;
		}
		
		if( session.getAttribute("admin2") != null) {
			//return false 表示数据库表中没有记录 
			//return true 表示数据库表中有记录
			return true;
		}else {
			session.setAttribute("loginMessage","请输入正确的用户名和密码！");
		}
		
		//执行这里表示用户身份需要认证，跳转登陆页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
		return false;
		
	}
}
