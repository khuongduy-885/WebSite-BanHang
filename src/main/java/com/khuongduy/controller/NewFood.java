package com.khuongduy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NewFood
{
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		
		return "adminlogin";
	}
}
