package com.registration.model;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ShopListPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2513158028122240790L;

	@NonNull
	@Column(name = "user_id")
	private String userId;

	@NonNull
	private Integer no;
}
