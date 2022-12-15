package com.jh.busstops.controller.validatingkey;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class ApiController implements WebMvcConfigurer {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/")
	public String showForm(ValidatingKeyForm keyForm) {
		return "form";
	}

	@PostMapping("/")
	public String checkValidatingKeyForm(@Valid ValidatingKeyForm keyForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "form";
		} 
		else {
			return "redirect:/busstopsthyme?key="+keyForm.getApiKey();
		}
	}
}