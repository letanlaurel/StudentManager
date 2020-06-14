package com.tl666.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 拦截非教师和管理员的操作拦截器 
 * @author 19760
 *
 */
public class TeacherInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object teacher = request.getSession().getAttribute("teacher");
		Object admin = request.getSession().getAttribute("admin");
		if(teacher != null || admin!=null) {
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
