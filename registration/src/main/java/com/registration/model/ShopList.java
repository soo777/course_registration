package com.registration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString
@Getter
@Entity 
@IdClass(ShopListPK.class)
@Table(name = "tb_shoppinglist")
public class ShopList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int no;
	     
	@Id
	@Column(name = "user_id")
	private String userId;
	
	@Column
	private String type = "A";
}
