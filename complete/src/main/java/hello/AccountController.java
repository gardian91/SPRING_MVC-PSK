package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.psk.bank.repository.AccountRepository;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

	private String viewPage = "infoPage";

	@GetMapping
	public String handleGetRequest(Model model) {

		model.addAttribute("message", "get request");

		return viewPage;
	}

	@PostMapping
	public String handlePostRequest(Model model) {

		model.addAttribute("message", "post request");

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

	@RequestMapping("getDetails/{id}/{name}")
	public String getDetails(@PathVariable("id") long id, @PathVariable("name") String name, Model model) {

		model.addAttribute("message", id + " " + name);

		return viewPage;

	}

}
