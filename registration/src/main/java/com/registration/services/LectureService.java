package com.registration.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.model.Lecture;
import com.registration.model.ShopList;
import com.registration.repository.LectureRepository;
import com.registration.repository.ShopListRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LectureService {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private	LectureRepository lectureRepository;
	
	public Map<String, Object> getLectureList(Map<String, Object> requestMap, Map<String, Object> returnData) {
		//# 페이징 데이터
		int draw = Integer.parseInt(requestMap.get("draw").toString());
		int start = Integer.parseInt(requestMap.get("start").toString());
		int length = Integer.parseInt(requestMap.get("length").toString());
		
		String sqlQ = "SELECT SQL_CALC_FOUND_ROWS TOT.* " +
				" FROM ( " +  
				" SELECT wlt.user_id, wlt.alias, wlt.wlt_tp, wlt.blc, wlt.reg_dt, wlt.mod_dt from tb_wallet wlt" +
				" ) AS TOT";
		
		//# LIMIT 절
		sqlQ += " LIMIT " + start + "," + length + ";";
		
		List<Map<String, Object>> convData = new ArrayList<>();
		
		//## 쿼리 실행
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			//# 데이터 테이블 리스트
			List<Object[]> data = (List<Object[]>) entityManager.createNativeQuery(sqlQ).getResultList();
			//            log.debug(data.toString());
			//# 이전쿼리 총 row count
			Object dataCnt = (Object) entityManager.createNativeQuery("SELECT FOUND_ROWS() total").getSingleResult();
			//# 데이터 가공
			for (Object[] arr : data) {
				Map<String, Object> item = new HashMap<>();
				item.put("user_id", arr[0] == null ? "-" : arr[0]);
				item.put("alias", arr[1] == null ? "-" : arr[1]);
				item.put("wlt_tp", arr[2] == null ? "-" : arr[2]);
				item.put("blc", arr[3] == null ? "-" : arr[3]);
				item.put("reg_dt", arr[4] == null ? "-" : arr[4]);
				item.put("mod_dt", arr[5] == null ? "-" : arr[5]);
				convData.add(item);
			}

			returnData.put("page", (start+1) / 5);
			returnData.put("data", convData);
			returnData.put("draw", draw);
			returnData.put("recordsTotal", dataCnt);
			returnData.put("recordsFiltered", dataCnt);
		} catch (NoResultException e) {
		} finally {
			if (entityManager.isOpen())
				entityManager.close();
		}
		
		return returnData;
	}
	
	public List<Lecture> getLectureList() {
		return lectureRepository.findAll();
	}

	public void addCourse(Lecture lecture) {
		lectureRepository.save(lecture);
	}
}
