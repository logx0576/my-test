package me.logx.action;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.logx.bean.Command;

@Controller
public class SpringBindAction {

	@RequestMapping(value = "/spring/bind", method = RequestMethod.GET)
	public String bindGet(@ModelAttribute("command")Command command) {
		System.out.println("bindGet...");
		return "/spring/bind";
	}

	@RequestMapping(value = "/spring/bind", method = RequestMethod.POST)
	public String bindPost(Command command) {
		System.out.println(command.getUsername() + "..." + command.getPassword());
//		errors.reject("loginfail", "使用者名称或密码错误");
		System.out.println("bindPost...");
		
		return "/spring/bind";
	}
}
