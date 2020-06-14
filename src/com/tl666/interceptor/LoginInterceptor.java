package com.tl666.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 登录拦截器 
 * @author 19760
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object student = request.getSession().getAttribute("student");
		Object teacher = request.getSession().getAttribute("teacher");
		Object admin = request.getSession().getAttribute("admin");
		if(student != null || teacher != null || admin != null) {
			return true;
		}
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		System.out.println("拦截响应");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		System.out.println("(jsp)加载在浏览器显示完毕后执行我");
	}

}
