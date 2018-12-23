package com.smartbiz.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;;

public class CORSFilter extends OncePerRequestFilter {

	private final Logger logger = Logger.getLogger(CORSFilter.class);
	
	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        response.addHeader("Access-Control-Allow-Origin", "*");
       // if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
        	logger.debug("Sending Header....");
            // CORS "pre-flight" request
            response.addHeader("Access-Control-Allow-Methods", "POST,GET, PUT, DELETE");
            response.addHeader("Allow", "POST,GET, PUT, DELETE");
            // response.addHeader("Access-Control-Allow-Headers", "Authorization");
            //response.addHeader("Access-Control-Allow-Headers", "Content-Type");
            //response.addHeader("Access-Control-Max-Age", "1");
      //  }
        filterChain.doFilter(request, response);
    }

}
