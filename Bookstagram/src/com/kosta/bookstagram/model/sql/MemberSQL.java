package com.kosta.bookstagram.model.sql;

/*
 * SQL문을 관리하는 클래스입니다.
 */
public class MemberSQL {
	/*
	 * 회원정보 체크
	 */
	public final static String checkMember = 
			"select * from member where id=? and pw=?";
	
	
	
}
