package com.psk.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExercisesController {
	private String viewPage = "infoPage";
	
	@RequestMapping(value = "/calc/{operation}", method = RequestMethod.GET)
	public String calc(@PathVariable("operation") String operation,
			@RequestParam(value = "value1", required = true) double value1,
			@RequestParam(value = "value2", required = true) double value2, 
			Model model) {
		
		model.addAttribute("message", operation+" "+value1+" "+value2);
		
		return viewPage;
	}
	
	
}
