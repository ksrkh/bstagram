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
	
	/**
	 * 회원 아이디 중복체크
	 */
	public final static String dupleById = 
			"select id,nick from member where id=?";
	
	/**
	 * 회원가입시 비밀번호 찾기 질문목록
	 */
	public final static String pwQuestionList = 
			"select * from question";
			
	/**
	* 회원가입시 성향 가져오기
	*/
	public final static String tendList =
			"select * from tend where tend_code != 0";
	
}
