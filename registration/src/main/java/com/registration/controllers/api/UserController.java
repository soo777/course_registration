package com.registration.controllers.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.registration.controller.AbstractController;
import com.registration.messages.APIResponse;
import com.registration.model.User;
import com.registration.services.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController extends AbstractController{
	
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<APIResponse> login(Model model, HttpSession session, @RequestParam(value = "id") String userId, @RequestParam(value = "pw") String pw)  {
		
		APIResponse rsp = null;
		String url = "";
		
		log.debug("@@@ id - {}", userId);
		log.debug("@@@ pw - {}", pw);
		
		User user = userService.getUser(userId);
		if(user == null) {
			log.error("Invalid ID");
			rsp = new APIResponse(false, "invalid ID", null);
			return ResponseEntity.ok(rsp);
		}
		
		log.debug("@@@ user - {}", user);
		if(pw.equals(user.getPw())) {
			url = "/home";
		} else {
			log.error("Invalid ID");
			rsp = new APIResponse(false, "invalid Password", null);
			return ResponseEntity.ok(rsp);
		}
		
		int role = userService.getUserRole(userId);
		
		session.setAttribute("userId", userId);
		session.setAttribute("role", role);
		
		rsp = new APIResponse(true, "login success", url);
		return ResponseEntity.ok(rsp);
	}
}
