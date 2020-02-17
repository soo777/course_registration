package com.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registration.model.ShopList;

@Repository
public interface ShopListRepository extends JpaRepository<ShopList, Integer> {

}
