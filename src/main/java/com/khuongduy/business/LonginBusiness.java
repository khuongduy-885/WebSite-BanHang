package com.khuongduy.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.khuongduy.service.impl.UsersSeviceImpl;

@Controller
public class LonginBusiness {
	@Autowired
	UsersSeviceImpl userSeviceImpl;
	
}
