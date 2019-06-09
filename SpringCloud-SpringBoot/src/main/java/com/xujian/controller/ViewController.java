package com.xujian.controller;

import java.util.ArrayList;
import java.util.List;

import com.xujian.pojo.TestUsers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringBoot整合jsp、freemarker
 */
@Controller
public class ViewController {
	/*
	 * 处理请求，产生数据
	 */
	@RequestMapping("/showJsp")
	public String showUser(Model model){
		List<TestUsers> list = new ArrayList();
		list.add(new TestUsers(1,"张三",20));
		list.add(new TestUsers(2,"李四",22));
		list.add(new TestUsers(3,"王五",24));
		
		//需要一个Model对象
		model.addAttribute("list", list);
		//跳转视图
		return "userList"; //这里存在同时放到webapp、resources冲突，显示不了
	}

	@RequestMapping("/showFreeMarker")
	public String showFreeMarker(Model model){
		List<TestUsers> list = new ArrayList();
		list.add(new TestUsers(1,"张三",20));
		list.add(new TestUsers(2,"李四",22));
		list.add(new TestUsers(3,"王五",24));

		//需要一个Model对象
		model.addAttribute("list", list);
		//跳转视图
		return "freemarker";
	}
}
