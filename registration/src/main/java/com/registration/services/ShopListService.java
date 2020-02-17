package com.registration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.model.Lecture;
import com.registration.model.ShopList;
import com.registration.repository.LectureRepository;
import com.registration.repository.ShopListRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ShopListService {
	
	@Autowired
	private	ShopListRepository shopRepository;
	
	public void addShopList(ShopList shopList) {
		shopRepository.save(shopList);
	}
}
 