package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

/**
 * 전체 컨트롤러에 공통적인 기능들을 처리 
 */
public abstract class AbstractController {

	@Autowired
	private MessageSource messageSource;
	
	/**
	 * i18n 메시지 변환 후 반환
	 * @param code
	 * @return message
	 */
	protected String getMessage(String code) {
	    return messageSource.getMessage(code, null, null);
	}
	
	/**
	 * 현재 회원을 반환
	 * @param principal
	 * @return Member
	 */
//	protected User getCurrentUser(Authentication auth) {
//		if (auth != null ) {
//			CustomUserDetails user = (CustomUserDetails)auth.getPrincipal();
//			if( user != null ) {
//				return user.getMember();
//			}
//    	}
//   		return null;
//	}
}
