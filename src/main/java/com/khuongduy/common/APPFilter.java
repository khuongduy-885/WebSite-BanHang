package com.khuongduy.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

public class APPFilter implements Filter
{

	public void init(FilterConfig filterConfig) throws ServletException
	{
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		// TODO Auto-generated method stub
		request.getParameter("");
		/*HttpSession session = ((Object) request).getSession();
        boolean isLogined = session.getAttribute("isLogin") != null ? (Boolean) session
                .getAttribute("isLogin") : false;*/
		
		chain.doFilter(request, response);
		
	}

	public void destroy()
	{
		// TODO Auto-generated method stub
		
	}

}
