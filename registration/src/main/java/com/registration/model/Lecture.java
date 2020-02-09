package com.registration.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@Getter
@Entity 
@Table(name = "tb_lecture")
public class Lecture implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
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
