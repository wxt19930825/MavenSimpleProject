package com.SpringBootProject.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringBootProject.study.viewModel.Msg;

@Controller
public class PageHomeController {

	@RequestMapping("/loginSuccess")
	public String index(Model model) {
		Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
		model.addAttribute("msg", msg);
		return "home";
	}
}
