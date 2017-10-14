package com.kosta.bookstagram.model.sql;

/*
 * SQL문을 관리하는 클래스입니다.
 */
public class CmsPageSQL {
	/**
	 * 성향 추가
	 */
	public final static String addTend =
			"insert into tend(tend_code, tend_name) values(tend_seq.nextval, ?)";
	
	/**
	 * 장르 추가
	 */
	public final static String addGenre = 
			"insert into genre(genre, genre_name) values(genre_seq.nextval, ?)";
	
	/**
	 * 카테고리 추가
	 */
	public final static String addCategory =
			"insert into category(category, category_name) values(category_seq.nextval, ?)";
	
	/**
	 * 비밀번호찾기질문추가
	 */
	public final static String addFindPwQuestion = 
			"insert into question(question_code, question) values(question_seq.nextval, ?)";
	
	/**
	 * 성향 리스트
	 */
	public final static String allTendList =
			"select * from tend";
	
	/**
	 * 장르 리스트
	 */
	public final static String allGenreList =
			"select * from genre";
	
	/**
	 * 카테고리 리스트
	 */
	public final static String allCategoryList =
			"select * from category";
	
	/**
	 * 비밀번호찾기 질문 리스트
	 */
	public final static String allQuestionList =
			"select * from question";
	
	/**
	 * 회원등급 리스트
	 */
	public final static String tierList =
			"select * from member_tier";
	
	/**
	 * 전체 회원 리스트
	 */
	public final static String allMemberList =
			"SELECT  m.id, m.pw, m.age, m.tend_name, m.tend_name2, m.tend_name3, mt.tier_name, m.regdate " + 
			"FROM (SELECT C.id, C.pw, C.age, C.regdate, C.tier, C.tend_name, C.tend_name2, D.tend_name AS tend_name3 " + 
			"FROM (SELECT A.id, A.pw, A.age, A.regdate, A.tier, A.tend_name, B.tend_name AS tend_name2 " + 
			"FROM (SELECT m.id, m.pw, m.age, m.regdate, m.tier, t.tend_name FROM member m, tend t WHERE m.tend_code = t.tend_code) A, " + 
			"(SELECT m.id, t.tend_name FROM member m, tend t WHERE m.tend_code2 = t.tend_code) B  WHERE A.id = B.id) C, " + 
			"(SELECT m.id, t.tend_name FROM member m, tend t WHERE m.tend_code3 = t.tend_code) D WHERE C.id = D.id) m , MEMBER_TIER mt " + 
			"WHERE m.tier=mt.tier";
	
	/**
	 * 전체 게시글 리스트
	 */
	public final static String allBoardList =
			"SELECT B.board_no, B.boardtype_no, B.id, substr(A.review_content,1,40) AS content, B.board_regdate, B.hit " + 
			"FROM (SELECT board_no, review_content FROM review_board " + 
			"UNION ALL SELECT board_no, create_content FROM create_board " + 
			"UNION ALL SELECT board_no, line_content FROM line_board) A, " + 
			"board B WHERE A.board_no = B.board_no";
	
}
