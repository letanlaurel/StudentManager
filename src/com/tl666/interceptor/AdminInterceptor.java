package com.tl666.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 拦截非管理的操作 拦截器 
 * @author 19760
 *
 */
public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object admin = request.getSession().getAttribute("admin");
		if(admin!=null) {
			return true;
		}
		response.getWriter().write("<script>alert('Permission denied!');</script>");
		return false;//true表示拦截后放行
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//System.out.println("拦截响应2");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//System.out.println("(jsp)加载在浏览器显示完毕后执行我2");
	}

}
