package com.sam.basic.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter{

//	<interceptors>
//	<!-- 아직 추가 안함 -->
//	<interceptor>
//		<!-- url 포함하는 것 -->
//		<mapping path="/problem/*"/>
//		<!-- url제외 하는 것 -->
//		<exclude-mapping path="/problem/list"/>
//		<beans:ref bean="memberCheckInterceptor"/>
//	</interceptor>
//</interceptors>
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Object loginInfo = request.getSession().getAttribute("loginInfo");
		if(loginInfo != null) {
			request.setAttribute("message", "강한나한나한나");
			request.setAttribute("url","/problem/list");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			dispatcher.forward(request, response);
			
			return true;
		}else {
			response.sendRedirect("/");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
}
