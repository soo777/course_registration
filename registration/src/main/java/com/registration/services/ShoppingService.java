package com.registration.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.model.ShopList;
import com.registration.repository.ShopListRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ShoppingService {
	
	@Autowired
	private	ShopListRepository shopRepository;
	
	public void addShopList(ShopList shopList) {
		shopRepository.save(shopList);
	}
	
	public void deleteShopList(ShopList shopList) {
		shopRepository.delete(shopList);
	}
	
	public List<Map<String, Object>> getShopList(String userId) {
		return shopRepository.getShopListByUserId(userId);
	}
}
 