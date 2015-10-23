package me.logx.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

	@RequestMapping(value = "/form/test")
	public String FormTest(String inputText) {
		System.out.println(inputText);
		return "/form/test";
	}
}