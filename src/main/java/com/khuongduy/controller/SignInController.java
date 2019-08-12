package com.khuongduy.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.khuongduy.common.UitiuCommon;
import com.khuongduy.entity.ObjCheck;
import com.khuongduy.entity.Users;
import com.khuongduy.sevice.UsersSevice;

@Controller
public class SignInController
{

	@Autowired
	UsersSevice userSeviceImpl;
	
	@Autowired
	LogInController logInController;
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signIn()
	{
		if(logInController.checklogin) {
			return "adminsignin";
		}else {
			return "redirect:login";
		}
		
	}

	@RequestMapping(value = "/xacthucmail", method = RequestMethod.POST)
	@ResponseBody
	public ObjCheck xacThucEnail(HttpServletRequest request, HttpServletResponse response, @RequestParam String email, Model model)
			throws SQLException, AddressException, MessagingException
	{
		ObjCheck objCheck = new ObjCheck();
		UitiuCommon maHoaAES = new UitiuCommon();
		String host = "smtp.gmail.com";
		String port = "587";
		String mailFrom = "khuongduy885@gmail.com";
		String password = "khuongduy196@";
		// outgoing message information
		String mailTo = email;
		String subject = "Hello my friend";
		String originalString = maHoaAES.maRanDom();
		String encryptedString = maHoaAES.encrypt(originalString);
		String message = "Xin chào"+mailTo+"đây là mã xác nhận của bạn: "+originalString.substring(0, 6);
		Users user1= new Users();
		user1.setEmail(email);
		user1.setHoten(password);
		user1.setMatkhau(mailFrom);
		try
		{
			sendPlainTextEmail(host, port, mailFrom, password, mailTo, subject, message);
			objCheck.setStatus(1);
			objCheck.setSuccess("Mã xác thực đã được gửi đến email " + mailTo+"."+encryptedString);
			objCheck.setCheck(encryptedString);
		} catch (Exception e)
		{	
			objCheck.setStatus(0);
			objCheck.setSuccess("không gửi được email" + e);
			return objCheck;
		}
		return objCheck;

	}

	@RequestMapping(value = "/themthanhvien", method = RequestMethod.POST)
	@ResponseBody
	public ObjCheck dangky(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam String fullname, @RequestParam String email,
			@RequestParam String pass,@RequestParam String authentic,
			@RequestParam String maxn,Model model) throws SQLException
	{
		ObjCheck objCheck = new ObjCheck();
		UitiuCommon maHoaAES = new UitiuCommon();
		String decryptedString = maHoaAES.decrypt(authentic).substring(0, 6);
		Users users = new Users();
		users.setEmail(email);
		users.setPass(pass);
		users.setFullname(fullname);
		try
		{
			if(maxn.equals(decryptedString)) {
				boolean ktdangky = userSeviceImpl.themnhanvien(users);
				if(ktdangky) {
					objCheck.setStatus(1);
					objCheck.setSuccess("đăng ký thành công !");
				}else {
					throw new Exception("đăng không thành công !");
				}
			}else {
				throw new Exception("Mã xác nhận không đúng");
			}
		} catch (Exception e)
		{	
			objCheck.setStatus(0);
			objCheck.setSuccess(""+e);
			return objCheck;
		}
		
		return objCheck;

	}
	public void sendPlainTextEmail(String host, String port, final String userName, final String password, String toAddress, String subject, String message)
			throws AddressException, MessagingException
	{
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(properties, auth);
		// creates a new e-mail message
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		// set plain text message
		msg.setText(message);
		// sends the e-mail
		Transport.send(msg);

	}
}
