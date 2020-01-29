package com.registration.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.registration.controller.AbstractController;
import com.registration.messages.APIResponse;
import com.registration.model.Lecture;
import com.registration.model.User;
import com.registration.services.LectureService;
import com.registration.services.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/lecture")
public class LectureController extends AbstractController{
	
	@Autowired
	private LectureService lectureService;

	@PostMapping("/list")
	public ResponseEntity<APIResponse> login()  {
		
		APIResponse rsp = null;
		String url = "";
		
		List<Lecture> list = lectureService.getLectureList();
		
		rsp = new APIResponse(true, "login success", list);
		return ResponseEntity.ok(rsp);
	}
}
