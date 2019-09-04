package com.khuongduy.controller;



import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khuongduy.business.LonginBusiness;
import com.khuongduy.entity.ObjCheck;
import com.khuongduy.entity.Users;
import com.khuongduy.service.impl.UsersSeviceImpl;


@Controller
public class LogInController {
	@Autowired
	LonginBusiness longinBusiness; 
	
   public boolean checklogin=false;
   
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		
		return "adminlogin";
	}
	
	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
	@ResponseBody
	public ObjCheck xacThucEnail(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String email,@RequestParam String pass,HttpSession session, Model model)
			throws SQLException, AddressException, MessagingException
	{
		ObjCheck objCheck = new ObjCheck();
		try
		{
			Users users = longinBusiness.kiemtradangnhap(email, pass);		
			if(users.getEmail() !=null ||"".equals(users.getEmail())){
				objCheck.setStatus(1);
				objCheck.setSuccess("đăng nhập thành công !");
				Cookie[] cookie= request.getCookies();
				session.setAttribute("checklogin", cookie[0].getValue());
			}else {
				objCheck.setStatus(0);
				objCheck.setSuccess("email hoặc pass k đúng !");
			}
		} catch (Exception e)
		{	
			objCheck.setStatus(0);
			objCheck.setSuccess(e.getMessage());
			return objCheck;
		}
		return objCheck;
		
	}

}
