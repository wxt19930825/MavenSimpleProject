package com.springMvcTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springMvcTest.model.ModelTest;

@Controller
public class HelloController {

	@RequestMapping("/index")
	public String Hello(){
		return "index";	
	}
	
	@RequestMapping("/adviceTest")
	public String getException(@ModelAttribute("msg") String msg,ModelTest modelTest) {
		throw new IllegalArgumentException("非诚抱歉，参数有误//"+"来自ModelAttribute:"+msg);
	}
	
	
}
