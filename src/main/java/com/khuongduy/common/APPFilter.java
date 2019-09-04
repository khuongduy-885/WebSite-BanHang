package com.khuongduy.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class APPFilter implements Filter
{

	final String IS_AUTHENTICATED = "isAuthenticated";

	public void init(FilterConfig filterConfig) throws ServletException
	{
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		// TODO Auto-generated method stub
		String tmp = ((HttpServletRequest) request).getRequestURI();
		if("/WebBanHang/themdanhmuc".equals(tmp)||"/WebBanHang/themsanpham".equals(tmp) ||"/WebBanHang/themnhanvien".equals(tmp)
				||"/WebBanHang".equals(tmp)||"/WebBanHang".equals(tmp)) {
			HttpSession session = ((HttpServletRequest) request).getSession();
			String api = (String) session.getAttribute("checklogin");
			if (api != null && !tmp.equals("/WebBanHang/signin"))
			{
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.sendRedirect("/WebBanHang/login");
			} else
			{
				chain.doFilter(request, response);
			}
		}else {
			chain.doFilter(request, response);
		}
	}

	public void destroy()
	{
		// TODO Auto-generated method stub

	}
}
