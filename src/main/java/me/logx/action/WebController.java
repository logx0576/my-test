package me.logx.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class WebController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(@ModelAttribute String nn, HttpServletRequest request) {
		System.out.println("nn... " + nn);
		
		if(request != null) {
			System.out.println("requsest nn " + request.getParameter("nn"));
		} else {
			System.out.println("request is null...");
		}
		
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println("cookie " + cookies[i].getName() + " " + cookies[i].getValue());
		}
		return "index";
	}

//	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
//	public String redirect() {
//		return "redirect:finalPage";
//	}

	@RequestMapping(value = "/finalPage", method = RequestMethod.GET)
	public String finalPage() {
		return "final";
	}

	@RequestMapping(value = "/staticPage", method = RequestMethod.GET)
	public String redirect() {
		System.out.println("test redirect static view");
		return "redirect:/pages/final.html";
	}
}