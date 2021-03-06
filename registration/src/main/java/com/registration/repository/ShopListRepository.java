package com.registration.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registration.model.ShopList;
import com.registration.model.ShopListPK;

@Repository
public interface ShopListRepository extends JpaRepository<ShopList, ShopListPK> {
	
//	@Query(value = "SELECT * from tb_lecture as a JOIN tb_shoppinglist as b on a.no = b.no WHERE b.user_id = :userId", nativeQuery = true)
	@Query(value = "SELECT a.no as no, b.user_id as user_id, b.type, a.lecture_name, "
					+ "a.grade, a.personnel, a.lecture_time, a.professor, "
					+ "a.lecture_room from tb_lecture as a "
					+ "JOIN tb_shoppinglist as b on a.no = b.no "
					+ "WHERE b.user_id = :userId", nativeQuery = true)
	List<Map<String, Object>> getShopListByUserId(String userId);
	
//	@Query(value = "\"SELECT \\n\" + \n" + 
//			"			\"   aaa.*,\\n\" + \n" + 
//			"			\"  (SELECT COUNT(*) FROM tb_USER WHERE comp_id=aaa.user_id AND user_tp ='ESO')  AS oper_cnt,\\n\" + \n" + 
//			"			\"  (SELECT CONCAT( lnm, ' ', fnm, ' (',  USER_id, ')') FROM tb_USER WHERE comp_id=aaa.user_id AND user_tp='ESA') AS manager,\\n\" + \n" + 
//			"			\"  (SELECT COUNT(*) FROM tb_USER WHERE aaa.user_id=comp_id and user_tp = 'CVS')  AS aff_cnt\\n\"", nativeQuery = true)
//	List<Map<String, Object>> getShopListByUserIdAndNo1(String userId, int a);
}
