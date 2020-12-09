package sg.edu.iss.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sg.edu.iss.test.model.Product;
import sg.edu.iss.test.service.CatalogueInterface;

@Controller
@RequestMapping("/catalogue")
public class CatalogueController {
	
	@Autowired
	private CatalogueInterface cservice;
	
	@Autowired
	public void setCatalogue(CatalogueInterface catalogue) {
		this.cservice = catalogue;
	}
	
	@RequestMapping(value = "/showform", method = RequestMethod.GET)
	public String showForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "catalogueform";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
		cservice.save(product);
		return "forward:/catalogue/list";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		List<Product> plist = cservice.list();
		model.addAttribute("plist", plist);
		return "catalogue";
	}

}
