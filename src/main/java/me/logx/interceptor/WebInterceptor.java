package me.logx.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class WebInterceptor implements WebRequestInterceptor {

	@Override
	public void preHandle(WebRequest request) throws Exception {
		System.out.println("request param nn is " + request.getParameter("nn"));
		System.out.println("preHandle...");
//		throw new Exception("occur exception...");
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		System.out.println("postHandle...");
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		System.out.println("afterCompletion...");
	}

}
