package com.registration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.model.Lecture;
import com.registration.repository.LectureRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LectureService {

	@Autowired
	private	LectureRepository lectureRepository;
	
	public List<Lecture> getLectureList() {
		return lectureRepository.findAll();
	}

	public void addCourse(Lecture lecture) {
		lectureRepository.save(lecture);
	}
}
