package sg.edu.iss.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/welcome")
public class YourFirstController {
	
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String welcomeMessage(Model model, @RequestParam String name) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
		Calendar cal = Calendar.getInstance();
		model.addAttribute("today", dateFormat.format(cal.getTime()));
		model.addAttribute("name", name);
		return "welcome";
	}

}
