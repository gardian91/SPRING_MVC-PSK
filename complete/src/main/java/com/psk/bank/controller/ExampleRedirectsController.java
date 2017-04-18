package com.psk.bank.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExampleRedirectsController {

    @GetMapping(value = "/do-and-redirect-1")
    public ModelAndView doAndRedirect1() {
        return new ModelAndView("redirect:/destination");
    }
    
    @GetMapping(value = "/do-and-redirect-2")
    public String doAndRedirect2() {
        return "redirect:/destination";
    }
    
    @GetMapping(value = "/do-and-forward")
    public String doAndForward() {
        return "forward:/destination";
    }
    
    
    @GetMapping(value = "/destination", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String redirectDestination() {
        return "redirect destination";
    }
}
