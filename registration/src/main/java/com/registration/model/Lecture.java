package com.registration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity 
@Table(name = "tb_lecture")
public class Lecture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	      
	@Column(name = "lecture_name")
	private String lectureName;
	
	@Column
	private int grade;
	
	@Column
	private String personnel;
	
	@Column(name = "lecture_time")
	private String lectureTime;
	
	@Column
	private String professor;
	
	@Column(name = "lecture_room")
	private String lectureRoom;
	
	
}
