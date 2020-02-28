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
import org.springframework.util.StringUtils;

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
		log.debug("@@ map - {}", requestMap);
		//# 페이징 데이터
		int draw = Integer.parseInt(requestMap.get("draw").toString());
		int start = Integer.parseInt(requestMap.get("start").toString());
		int length = Integer.parseInt(requestMap.get("length").toString());
		
		String searchLecture = requestMap.get("columns[0][search][value]").toString();
		
		log.debug("searchLecture:{}", searchLecture);
		
		ArrayList<String> whereStrArr = new ArrayList<String>();
		
//		String sqlQ = "SELECT SQL_CALC_FOUND_ROWS TOT.* " +
//				" FROM ( " +  
//				" SELECT * FROM scheduler.tb_lecture " +
//				" ) AS TOT";
		String sqlQ = "SELECT SQL_CALC_FOUND_ROWS TOT.* " +
				" FROM ( " +  
				" SELECT * FROM scheduler.tb_lecture ";
		
		if (!StringUtils.isEmpty(searchLecture))
			whereStrArr.add(" lecture_name = '" + searchLecture + "'");


		if (whereStrArr.size() > 0)
			sqlQ += " WHERE " + String.join(" AND ", whereStrArr);
		
		sqlQ +=		" ) AS TOT";
		
		//# LIMIT 절
		sqlQ += " LIMIT " + start + "," + length + ";";
		
		log.debug("@@ sql - {}", sqlQ);
		
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
				item.put("no", arr[0] == null ? "-" : arr[0]);
				item.put("lectureName", arr[1] == null ? "-" : arr[1]);
				item.put("grade", arr[2] == null ? "-" : arr[2]);
				item.put("personnel", arr[3] == null ? "-" : arr[3]);
				item.put("lectureTime", arr[4] == null ? "-" : arr[4]);
				item.put("professor", arr[5] == null ? "-" : arr[5]);
				item.put("lectureRoom", arr[6] == null ? "-" : arr[6]);
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
