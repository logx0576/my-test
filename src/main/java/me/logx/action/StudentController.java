package me.logx.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import me.logx.domain.Student;

@Controller
public class StudentController {

//	@RequestMapping(value = "/student", method = RequestMethod.GET)
//	public ModelAndView student() {
//		return new ModelAndView("student", "command", new Student());
//	}

//	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
//	public String addStudent(@ModelAttribute("SpringWeb") Student student, ModelMap model, HttpServletRequest request) {
//		model.addAttribute("name", student.getName());
//		model.addAttribute("age", student.getAge());
//		model.addAttribute("id", student.getId());
//		request.setAttribute("mydata", "heihei");
//		HttpSession session = request.getSession();
//		session.setAttribute("sessiondata", "sessiondata");
//		return "result";
//	}
}