package com.registration.controllers.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.registration.controller.AbstractController;
import com.registration.messages.APIResponse;
import com.registration.model.Lecture;
import com.registration.model.ShopList;
import com.registration.services.LectureService;
import com.registration.services.ShoppingService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/shopping")
public class ShoppingController extends AbstractController{
	 
	@Autowired
	private ShoppingService shoppingService;

	@PostMapping("/list")
	public ResponseEntity<APIResponse> getList(@RequestParam (value="user_id") String userId )  {
		
		APIResponse rsp = null;
		String url = "";
		 
		List<Map<String, Object>> list = shoppingService.getShopList(userId);
		
		HashMap returnData = new HashMap();
		
		returnData.put("data", list);
		returnData.put("draw", 1);
		returnData.put("recordsTotal", list.size());
		returnData.put("recordsFiltered", list.size());
		
		rsp = new APIResponse(true, "select list success", returnData);
		return ResponseEntity.ok(rsp);
	}
	
	@PostMapping("/addShopList")
	public ResponseEntity<APIResponse> addShopList(@RequestParam HashMap<String, Object> requestMap) {
		APIResponse rsp = null;
		
		log.debug("@@ map - {}", requestMap);
		
		int no = Integer.parseInt((String) requestMap.get("no"));
		String userId = (String) requestMap.get("user_id");
		
		ShopList shopList = new ShopList();
		shopList.setNo(no);
		shopList.setUserId(userId);

		shoppingService.addShopList(shopList);
		 
		rsp = new APIResponse(true, "add course success", null);
		return ResponseEntity.ok(rsp);
	}
	
	@PostMapping("/deleteShopList")
	public ResponseEntity<APIResponse> deleteShopList(@RequestParam HashMap<String, Object> requestMap) {
		APIResponse rsp = null;
		
		log.debug("@@ map - {}", requestMap);
		
		int no = Integer.parseInt((String) requestMap.get("no"));
		String userId = (String) requestMap.get("user_id");
		
		ShopList shopList = new ShopList();
		shopList.setNo(no);
		shopList.setUserId(userId);

		shoppingService.deleteShopList(shopList);
		 
		rsp = new APIResponse(true, "add course success", null);
		return ResponseEntity.ok(rsp);
	}
}
