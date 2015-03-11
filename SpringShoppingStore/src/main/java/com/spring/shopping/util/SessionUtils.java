package com.spring.shopping.util;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {

	@SuppressWarnings("unchecked")
	public static <T> T createSession(HttpServletRequest request) {
		return (T) request.getSession();
	}

	@SuppressWarnings("unchecked")
	public static <T> T getSessionVariables(HttpServletRequest request, String value) {
		return (T) request.getSession().getAttribute(value);
	}

	public static <T> void setSessionVariables(T obj, HttpServletRequest request,
			String value) {
		request.getSession().setAttribute(value, obj);
	}
	
	public static void removeSessionVariables(String value,HttpServletRequest request){
		request.getSession().removeAttribute(value);
	}
}
