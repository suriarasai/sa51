package sg.edu.iss.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.test.model.User;
import sg.edu.iss.test.service.UserImplementation;
import sg.edu.iss.test.service.UserInterface;

@Controller
public class UserController {

	@Autowired 
	UserInterface uservice;
	
	@Autowired
	public void setUserImplementation(UserImplementation uimpl) {
		this.uservice = uimpl;
	}
	
	@RequestMapping(path = "/login")
	public String login(Model model) {
		User u = new User();
		model.addAttribute("user", u);
		return "login";
	}
	
	@RequestMapping(path = "/authenticate")
	public String authenticate(@ModelAttribute("user") User user, Model model, HttpSession session) {
		if(uservice.authenticate(user)) 
		{
			User u = uservice.findByName(user.getUserName());
			session.setAttribute("usession", u);
			return "welcome";
		}
		else
			return "login";
	}
	
	
}
