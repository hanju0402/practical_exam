package com.practical.exam.common.utils;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 요청 정보 Utility
 * 
 * @author 이동준 (blog.naver.com/adgjl1125)
 *
 */
public class RequestUtils {
	private static final Logger logger = LogManager.getLogger(RequestUtils.class);
	/**
	 * 요청 파라미터 조회
	 * 
	 * @return HashMap<String,Object>
	 */
	public static HashMap<String,Object> getParameter(HttpServletRequest request){
		HashMap<String,Object> result = new HashMap<String,Object>();
		Enumeration enu = request.getParameterNames();
		
		while(enu.hasMoreElements()) {
			String key = (String)enu.nextElement();
			String value = request.getParameter(key);
			
			result.put(key, value);
		}
		return result;
	}
	
	/**
	 * 클라이언트 IP 정보 추출
	 * 
	 * @param request
	 * @return String
	 */
	public static String getIp(HttpServletRequest request){
		String ip= request.getHeader("X-Forwarded-For");
	    
	    if (ip == null) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip == null) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip == null) {
	        ip = request.getHeader("HTTP_CLIENT_IP");
	    }
	    if (ip == null) {
	        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	    }
	    if (ip == null) {
	        ip = request.getRemoteAddr();
	    }
	    logger.info("> Result : IP Address : "+ip);

		return ip;
	}
}
