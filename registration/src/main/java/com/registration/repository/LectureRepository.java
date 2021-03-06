package com.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registration.model.Lecture;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Integer> {
	
	Lecture findByNo(int no);

}
