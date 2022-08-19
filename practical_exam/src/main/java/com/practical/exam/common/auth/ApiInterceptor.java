package com.practical.exam.common.auth;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.practical.exam.common.utils.RequestUtils;


/**
 * API Interceptor
 * 호출 URL 및 호출 Parameter LOGGING
 * 
 * @author 이동준 (blog.naver.com/adgjl1125)
 *
 */
public class ApiInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LogManager.getLogger(ApiInterceptor.class);
    private static final String REQUEST_METHODS_TYPE_OF_GET="GET";
    
    @Autowired
    
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	//GET 방식인 경우, log를 남기지 않음
		if(request.getMethod().equals(REQUEST_METHODS_TYPE_OF_GET)) {
    		return true;
    	}
		LOGGER.info("Request URL ==> "+request.getRequestURI());
		LOGGER.info("Request Params ==>"+RequestUtils.getParameter(request));
		
//		if(true) {
//			LOGGER.info(RequestUtils.getIp(request)+ " session has expired...");
//		}
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
