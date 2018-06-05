package com.sunhui.ssm.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//拦截器是基于aop的
public class HandlerInterceptor2 implements HandlerInterceptor {

	//进入handler方法之后，返回modelAndView之前执行
	//应用场景从modelAndView出发：将公用的模型数据（比如菜单导航）在这里传到视图，也可以在这里面统一指定视图
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("HandlerInterceptor2--------afterCompletion");
	}

	//执行handler完成执行此方法
	//应用场景：统一的异常处理，统一的日志处理
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("HandlerInterceptor2--------postHandle");
	}

	//进入handler方法之前执行
	//用于身份认证、身份授权
	//比如身份认证，如果认证通过表示当前用户没有登录，需要此方法拦截不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("HandlerInterceptor2--------preHandle");
		return true;
	}

}
