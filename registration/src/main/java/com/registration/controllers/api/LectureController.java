package com.registration.controllers.api;

import java.util.ArrayList;
import java.util.HashMap;
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
	public ResponseEntity<APIResponse> getList()  {
		
		APIResponse rsp = null;
		String url = "";
		
		List<Lecture> list = lectureService.getLectureList();
		
		HashMap returnData = new HashMap();
		
		returnData.put("data", list);
		returnData.put("draw", 1);
		returnData.put("recordsTotal", list.size());
		returnData.put("recordsFiltered", list.size());
		
		rsp = new APIResponse(true, "select list success", returnData);
		return ResponseEntity.ok(rsp);
	}
	
	@PostMapping("/addCourse")
	public ResponseEntity<APIResponse> addCourse(@RequestParam HashMap<String, Object> requestMap) {
		APIResponse rsp = null;
		
		log.debug("@@ map - {}", requestMap);
		log.debug("@@ map - {}", requestMap.values());
		
		List list = new ArrayList(requestMap.values());
//		log.debug("@@ map - {}", list.get(3));
		

		String lectureName = (String) requestMap.get("lecture_name");
		String grade = (String) requestMap.get("grade");
		String personnel = (String) requestMap.get("personnel");
		List lectureTime = (List) requestMap.get("lecture_time");
		String professor = (String) requestMap.get("professor");
		String lectureRoom = (String) requestMap.get("lecture_room");
		
		log.debug("@@ lectureName - {}", lectureName );
		log.debug("@@ grade - {}", grade );
		log.debug("@@ personnel- {}", personnel);
		log.debug("@@ lectureTime- {}", lectureTime);
		log.debug("@@ professor- {}", professor);
		log.debug("@@ lectureRoom- {}", lectureRoom);
		
		HashMap returnData = new HashMap();
		
		
		rsp = new APIResponse(true, "login success", returnData);
		return ResponseEntity.ok(rsp);
	}

}
