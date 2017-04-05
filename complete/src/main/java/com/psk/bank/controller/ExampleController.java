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

import com.psk.bank.model.User;
import com.psk.bank.repository.UserRepository;

@Controller
@ComponentScan(basePackageClasses = UserRepository.class)
public class ExampleController {

	@Autowired
	private UserRepository userRepository;
	
	private String viewPage = "infoPage";

	@GetMapping
	@RequestMapping(value = "/modelAndView")
	public ModelAndView modelAndView() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewPage);
		mav.addObject("message", "get request");

		return mav;
	}

	@GetMapping
	@RequestMapping(value = "/model")
	public String handleGetRequest(Model model) {

		model.addAttribute("message", "get request : variant 1");

		return viewPage;
	}

	/////// @Controler,ModelAndView,Model,@GetMapping

	@RequestMapping(value = "/variant2", method = RequestMethod.GET)
	public String handleGetRequestVariant2(Model model) {

		model.addAttribute("message", "get request : variant 2");

		return viewPage;
	}

	@PostMapping
	public String handlePostRequest(Model model,@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name) {

		model.addAttribute("message", id+" "+name);

		return viewPage;
	}

	@RequestMapping(value = "/variant2", method = RequestMethod.POST)
	public String handlePostRequestVariant2(Model model) {

		model.addAttribute("message", "post request : variant 2");

		return viewPage;
	}

	@PutMapping
	public ModelAndView handlePutRequest() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewPage);
		mav.addObject("message", "put request");

		return mav;
	}

	@DeleteMapping
	public ModelAndView handleDeleteRequest() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewPage);
		mav.addObject("message", "delete request");

		return mav;
	}

	@PatchMapping("test")
	public String handlePatchRequest() {

		return "PatchMapping-view";
	}

	////////// @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping)

	
	@RequestMapping(value = "pathVariableExample/{id}/{name}", method = RequestMethod.GET)
	public String getDetails(@PathVariable("id") long id, @PathVariable("name") String name, Model model) {

		model.addAttribute("message", id + " " + name);

		return viewPage;

	}

	/*@RequestMapping("pathVariable/{id}/{name}")
	public String pathVariable(@PathVariable("id") long id, @PathVariable("name") String name, Model model) {

		model.addAttribute("message", id + " " + name);

		return viewPage;

	}*/

	@RequestMapping(value = "/requestParamExample", method = RequestMethod.GET)
	public String getDetailsRequestParam(Model model, @RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name) {

		model.addAttribute("message", id + " " + name);

		return viewPage;

	}

	// http://localhost:8080/requestParamExample?id=testId&name=testName

	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public @ResponseBody User addUser(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name) {

		return userRepository.save(new User(id,name));
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
