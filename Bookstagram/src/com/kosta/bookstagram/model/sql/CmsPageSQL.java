package com.kosta.bookstagram.model.sql;

/*
 * SQL문을 관리하는 클래스입니다.
 */
public class CmsPageSQL {
	/**
	 * 성향 추가
	 */
	public final static String ADD_TEND =
			"insert into tend(tend_code, tend_name) values(tend_seq.nextval, ?)";
	
	/**
	 * 장르 추가
	 */
	public final static String ADD_GENRE = 
			"insert into genre(genre, genre_name) values(genre_seq.nextval, ?)";
	
	/**
	 * 카테고리 추가
	 */
	public final static String ADD_CATEGORY =
			"insert into category(category, category_name) values(category_seq.nextval, ?)";
	
	/**
	 * 비밀번호찾기질문추가
	 */
	public final static String ADD_FIND_PW_QUESTION = 
			"insert into question(question_code, question) values(question_seq.nextval, ?)";
	
	/**
	 * 성향 리스트
	 */
	public final static String ALL_TEND_LIST =
			"select * from tend order by tend_code asc";
	
	/**
	 * 장르 리스트
	 */
	public final static String ALL_GENRE_LIST =
			"select * from genre order by genre asc";
	
	/**
	 * 카테고리 리스트
	 */
	public final static String ALL_CATEGORY_LIST =
			"select * from category order by category asc";
	
	/**
	 * 비밀번호찾기 질문 리스트
	 */
	public final static String ALL_QUESTION_LIST =
			"select * from question";
	
	/**
	 * 회원등급 리스트
	 */
	public final static String TIER_LIST =
			"select * from member_tier";
	
	/**
	 * 전체 회원 리스트
	 */
	/*public final static String ALL_MEMBER_LIST =
			"SELECT  m.id, m.pw, m.age, m.tend_name, m.tend_name2, m.tend_name3, mt.tier_name, m.regdate " + 
			"FROM (SELECT C.id, C.pw, C.age, C.regdate, C.tier, C.tend_name, C.tend_name2, D.tend_name AS tend_name3 " + 
			"FROM (SELECT A.id, A.pw, A.age, A.regdate, A.tier, A.tend_name, B.tend_name AS tend_name2 " + 
			"FROM (SELECT m.id, m.pw, m.age, m.regdate, m.tier, t.tend_name FROM member m, tend t WHERE m.tend_code = t.tend_code) A, " + 
			"(SELECT m.id, t.tend_name FROM member m, tend t WHERE m.tend_code2 = t.tend_code) B  WHERE A.id = B.id) C, " + 
			"(SELECT m.id, t.tend_name FROM member m, tend t WHERE m.tend_code3 = t.tend_code) D WHERE C.id = D.id) m , MEMBER_TIER mt " + 
			"WHERE m.tier=mt.tier";*/
	
	public final static String ALL_MEMBER_LIST =
			"SELECT D.id, D.pw, D.age, D.tend_name, D.tend_name2, D.tend_name3, D.tier_name, D.regdate " + 
			"FROM (SELECT row_number() over(order by m.regdate desc) as rnum, m.id, m.pw, m.age, m.tend_name, m.tend_name2, m.tend_name3, mt.tier_name, m.regdate " + 
			"FROM (SELECT C.id, C.pw, C.age, C.regdate, C.tier, C.tend_name, C.tend_name2, D.tend_name AS tend_name3 " + 
			"FROM (SELECT A.id, A.pw, A.age, A.regdate, A.tier, A.tend_name, B.tend_name AS tend_name2 " + 
			"FROM (SELECT m.id, m.pw, m.age, m.regdate, m.tier, t.tend_name FROM member m, tend t WHERE m.tend_code = t.tend_code) A, " + 
			"(SELECT m.id, t.tend_name FROM member m, tend t WHERE m.tend_code2 = t.tend_code) B  WHERE A.id = B.id) C, " + 
			"(SELECT m.id, t.tend_name FROM member m, tend t WHERE m.tend_code3 = t.tend_code) D WHERE C.id = D.id) m , MEMBER_TIER mt " + 
			"WHERE m.tier=mt.tier) D " + 
			"WHERE D.rnum BETWEEN ? AND ?";
	
	/**
	 * 전체 게시글 리스트
	 */
	public final static String ALL_BOARD_LIST= 
			"SELECT D.board_no, D.boardtype_no, D.boardtype_name, D.id, D.content, D.board_regdate, D.hit " + 
			"FROM(SELECT row_number() over(ORDER BY C.board_no DESC) AS rnum ,C.board_no , C.boardtype_no, bt.boardtype_name, C.id, C.content, C.board_regdate, C.hit " + 
			"FROM (SELECT B.board_no, B.id, substr(A.review_content,1,40) AS content, B.board_regdate, B.hit, B.boardtype_no " + 
			"FROM (SELECT board_no, review_content FROM review_board " + 
			"UNION ALL SELECT board_no, create_content FROM create_board " + 
			"UNION ALL SELECT board_no, line_content FROM line_board) A, " + 
			"board B WHERE A.board_no = B.board_no) C, board_type bt " + 
			"WHERE bt.boardtype_no = C.boardtype_no ORDER BY C.board_no DESC) D " + 
			"WHERE D.rnum between ? and ?";

	/**
	 * 성향 수정
	 */
	public final static String TEND_NAME_UPDATE = "update tend set tend_name = ? where tend_code = ?";
	
	/**
	 * 성향 삭제
	 */
	public final static String BOARD_TEND_UPDATE = "update line_board set tend_code = 0 where tend_code = ?";
	public final static String TEND_CODE1_UPDATE = "update member set tend_code = 0 where tend_code = ?";
	public final static String TEND_CODE2_UPDATE = "update member set tend_code2 = 0 where tend_code2 = ?";
	public final static String TEND_CODE3_UPDATE = "update member set tend_code3 = 0 where tend_code3 = ?";
	public final static String TEND_DELETE = "delete tend where tend_code = ?";
	
	/**
	 * 장르 수정
	 */
	public final static String GENRE_NAME_UPDATE = "UPDATE genre set genre_name = ? where genre = ?";
	
	/**
	 * 장르 삭제
	 */
	public final static String BOARD_GENRE_UPDATE = "UPDATE review_board set genre = 0 where genre = ?";
	public final static String GENRE_DELETE = "delete genre where genre = ?";
	
	/**
	 * 분야 수정
	 */
	public final static String CATEGORY_NAME_UPDATE = "UPDATE category set category_name = ? where category = ?";
	
	/**
	 * 분야 삭제
	 */
	public final static String BOARD_CATEGORY_UPDATE = "UPDATE create_board set category = 0 where category = ?";
	public final static String CATEGORY_DELETE = "delete category where category = ?";
	
	/**
	* 비밀번호 찾기 질문 수정
	*/
	public final static String PASSWORD_QUESTION_UPDATE = "update question set question = ? where question_code = ?";

	/**
	 * 전체 게시판 수 
	 */
	public final static String CMS_ALL_BOARD_COUNT = "SELECT COUNT(*) FROM BOARD";

	/**
	 * 전체 회원 수
	 */
	public final static String CMS_ALL_MEMBER_COUNT = "SELECT COUNT(*) FROM MEMBER";
}
