package com.registration.controllers.page;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    public String index() {
		return "fragments/login";
//		return "fragments/home";
    }
	
	@RequestMapping("/home")
    public String home(Model model, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		int role = (int) session.getAttribute("role");
		model.addAttribute("userId", userId);
		model.addAttribute("role", role);
		return "fragments/home";
    }

    @RequestMapping("/view")
    public String viewTest(Model model){
        model.addAttribute("message","Hello Spring Boot thymeleaf");
        return "fragments/view";
    }

}
