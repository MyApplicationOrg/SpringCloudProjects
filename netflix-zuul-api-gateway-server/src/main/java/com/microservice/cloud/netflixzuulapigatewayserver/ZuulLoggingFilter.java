/**
 * 
 */
package com.microservice.cloud.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Object run() {
		HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
		logger.info("Request --> {} RequestURI --> {} ", req, req.getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
