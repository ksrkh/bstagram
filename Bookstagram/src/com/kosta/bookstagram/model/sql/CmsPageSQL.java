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
	 * 전체 회원 리스트
	 */
	public final static String allMemberList =
			"select * from member";
	
	/**
	 * 전체 게시글 리스트
	 */
	public final static String allBoardList =
			"select * from board";
	
}
