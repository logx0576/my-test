package me.logx.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "hello";
	}
	
	@RequestMapping(value = "/vmview", method = RequestMethod.GET)
	public String vmview(ModelMap model) {
//		model.addAttribute("message", "Hello Spring MVC Framework!");
		System.out.println("vmview .....");
		return "vmview";
	}
}