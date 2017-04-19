package com.psk.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDateTime;
import com.psk.bank.model.User;
import com.psk.bank.repository.UserRepository;

@Controller
@ComponentScan(basePackageClasses = UserRepository.class)
public class ExampleController {

	@Autowired
	private UserRepository userRepository;

	private String VIEW_PAGE = "infoPage";

	@RequestMapping(value = "/modelAndView", method = RequestMethod.GET)
	public ModelAndView modelAndView() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName(VIEW_PAGE);
		mav.addObject("message", "modelAndView");

		return mav;
	}

	@RequestMapping(value = "/model", method = RequestMethod.GET)
	public String model(Model model) {

		model.addAttribute("message", "model");

		return VIEW_PAGE;
	}
	
	
	@GetMapping("/get")
	public String handleGetRequest(Model model) {

		model.addAttribute("message", "get request : variant 1");

		return VIEW_PAGE;
	}

	/////// @Controler,ModelAndView,Model,@GetMapping

	@RequestMapping(value = "/variant2", method = RequestMethod.GET)
	public String handleGetRequestVariant2(Model model) {

		model.addAttribute("message", "get request : variant 2");

		return VIEW_PAGE;
	}

	@PostMapping
	public String handlePostRequest(Model model, @RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name) {

		model.addAttribute("message", id + " " + name);

		return VIEW_PAGE;
	}

	@RequestMapping(value = "/variant2", method = RequestMethod.POST)
	public String handlePostRequestVariant2(Model model) {

		model.addAttribute("message", "post request : variant 2");

		return VIEW_PAGE;
	}



	////////// @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping)

	@RequestMapping(value = "pathVariableExample/{id}/{name}", method = RequestMethod.GET)
	public String getDetails(@PathVariable("id") long id, @PathVariable("name") String name, Model model) {

		model.addAttribute("message", id + " " + name);

		return VIEW_PAGE;

	}


	@RequestMapping(value = "/requestParamExample", method = RequestMethod.GET)
	public String getDetailsRequestParam(Model model, @RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name) {

		model.addAttribute("message", id + " " + name);

		return VIEW_PAGE;

	}

	// http://localhost:8080/requestParamExample?id=testId&name=testName

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public @ResponseBody String addUser(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "date", required = false) String date) {

		userRepository.save(new User(id, name, LocalDateTime.parse(date)));

		return "User added successfully";
	}

	@RequestMapping(value = "/deleteUserWithGivenId/{id}", method = RequestMethod.DELETE)
	public @ResponseBody User deleteUserWithGivenId(@PathVariable("id") String id) {

		return userRepository.deleteOne(id);
	}

	@RequestMapping(value = "/getUserWithGivenId/{id}", method = RequestMethod.GET)
	public @ResponseBody User getUserWithGivenId(@PathVariable("id") String id) {

		return userRepository.findOne(id);
	}
	
	
}
