package sg.edu.iss.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.demo.model.Product;
import sg.edu.iss.demo.repo.ProductRepository;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepository prepo;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
				
	}
	
	@GetMapping("/add")
	public String showProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "productform";
	}
	
	@GetMapping("/save")
	public String saveProductForm(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) 
		{
			return "productform";
		}
		prepo.save(product);
		return "forward:/product/listproducts";
	}
	
	@GetMapping("/listproducts")
	public String listProducts(Model model) {
		model.addAttribute("products", prepo.findAll());
		return "products";
	}
	
	@GetMapping("/edit/{id}")
	  public String showEditForm(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("product", prepo.findById(id).get());
		return "productform";
	  }
	  
	  @GetMapping("/delete/{id}")
	  public String deleteMethod(Model model, @PathVariable("id") Integer id) {
		Product product = prepo.findById(id).get();
		prepo.delete(product);
		return "forward:/product/listproducts";
	  }


}
