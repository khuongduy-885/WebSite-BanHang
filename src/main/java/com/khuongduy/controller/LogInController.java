package com.khuongduy.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khuongduy.service.impl.UsersSeviceImpl;


@Controller
public class LogInController {
	
	@Autowired
	UsersSeviceImpl userSeviceImpl;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		
		return "adminlogin";
	}

}
