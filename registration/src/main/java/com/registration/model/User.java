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
@Table(name = "tb_user")
public class User {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String user_id;
	      
	@Column
	private String pw;
	
	@Column
	private String nm;
	
	
}
