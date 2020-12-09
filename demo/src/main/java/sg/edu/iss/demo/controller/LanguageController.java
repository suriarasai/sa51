package sg.edu.iss.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LanguageController {
  
	@GetMapping("/language")
	public String getpage() {
		return "language";
	}
	
	 
}
