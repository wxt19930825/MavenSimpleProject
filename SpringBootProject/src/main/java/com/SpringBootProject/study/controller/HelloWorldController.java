package com.SpringBootProject.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	@RequestMapping("/sayHello.html")
	public @ResponseBody String say() {
		return "Hello Spring Boot";
	}
	
	@RequestMapping("/testException")
	public @ResponseBody String test() throws IllegalAccessException {
		throw new IllegalAccessException("无权限");
	}
	
	/*@RequestMapping("/index")
	public  String say1() {
		return "index";
	}*/
	
}
