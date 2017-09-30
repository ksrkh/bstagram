package com.kosta.bookstagram.model;

public class LineBoardVO extends BoardVO{
	/*
	 * 한줄게시판 책 제목
	 */
	private String line_title;
	/*
	 * 한줄게시판 책 저자
	 */
	private String line_author;
	/*
	 * 한줄게시판 책 내용
	 */
	private String line_content;
	/*
	 * 한줄게시판 작성 글의대한 성향
	 */
	private int tend_code;
	
	/*
	 * 기본생성자
	 */
	public LineBoardVO() {}

	/**
	 * -----super-----
	 * @param board_no
	 * @param boardtype_no
	 * @param id
	 * @param board_regdate
	 * @param hit
	 * @param sympathy
	 * @param authority
	 * @param bg_no
	 * ------this------
	 * @param line_title
	 * @param line_author
	 * @param line_content
	 * @param tend_code
	 * 
	 * -매개변수 12개를 입력받아 부모클래스와 자식클래스의 변수에 데이터 세팅
	 */
	public LineBoardVO(int board_no, int boardtype_no, String id, String board_regdate, int hit, int sympathy,
			int authority, int bg_no, String line_title, String line_author, String line_content, int tend_code) {
		super(board_no, boardtype_no, id, board_regdate, hit, sympathy, authority, bg_no);
		this.line_title = line_title;
		this.line_author = line_author;
		this.line_content = line_content;
	}

	public String getLine_title() {
		return line_title;
	}

	public void setLine_title(String line_title) {
		this.line_title = line_title;
	}

	public String getLine_author() {
		return line_author;
	}

	public void setLine_author(String line_author) {
		this.line_author = line_author;
	}

	public String getLine_content() {
		return line_content;
	}

	public void setLine_content(String line_content) {
		this.line_content = line_content;
	}

	public int getTend_code() {
		return tend_code;
	}

	public void setTend_code(int tend_code) {
		this.tend_code = tend_code;
	}

	public LineBoardVO(String line_title, String line_author, String line_content, int tend_code) {
		super();
		this.line_title = line_title;
		this.line_author = line_author;
		this.line_content = line_content;
		this.tend_code = tend_code;
	}
}
