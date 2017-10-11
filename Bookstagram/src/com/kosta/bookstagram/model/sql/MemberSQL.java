package com.kosta.bookstagram.model.sql;

/*
 * SQL문을 관리하는 클래스입니다.
 */
public class MemberSQL {
	/**
	 * 회원정보 체크
	 */
	public final static String checkMember = 
			"select * from member where id=? and pw=?";
	
	/**
	 * <pre>회원가입</pre>
	 * 
	 * [m_photo] 	회원사진		[default] null	<br/>
	 * [temp] 		임시컬럼		[default] null	<br/>
	 * [tend_code] 	성향코드		[default] 0(없음)	<br/>
	 * [tend_code2] 성향코드		[default] 0(없음)	<br/>
	 * [tend_code3] 성향코드		[default] 0(없음)	<br/>
	 * [tier] 		성향코드		[default] 1(회원)	<br/>
	 * 
	 */
	public final static String addMember = 
			"insert into member"+
			"(id, pw, nick, age, regdate, m_photo, temp, tend_code, tend_code2, tend_code3, tier, question_code, pw_ans) " + 
			"values(?, ?, ?, ?, sysdate, null, null, ?, ?, ?, 1, ?, ?)";
	
}
