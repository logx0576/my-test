package me.logx.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SchoolPersonType {

	@RequestMapping(value = "/person")
	public String person() {
		return "/user/register";
	}
}
