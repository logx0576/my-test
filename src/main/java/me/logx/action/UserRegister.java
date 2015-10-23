package me.logx.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.logx.edit.CustomNumberEditor;
import me.logx.service.StudentService;

@Controller
public class UserRegister {
	Log log = LogFactory.getLog(this.getClass());

	@Autowired
	private StudentService studentService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(int.class, new CustomNumberEditor());
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "nn", required = false) int number, String name) {
		log.info("enter register page...");
		log.info("number is " + number);
		log.info("name is " + name);
		studentService.printStudent();
//		return "/user/register";
		return "/vm/vmview";
	}
}
