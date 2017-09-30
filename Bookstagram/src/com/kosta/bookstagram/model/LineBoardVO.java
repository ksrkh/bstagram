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
	 * @param board_no		게시판번호
	 * @param boardtype_no	게시판타입번호
	 * @param id			아이디
	 * @param board_regdate	등록일자
	 * @param hit			조회수
	 * @param sympathy		좋아요
	 * @param authority		공개권한
	 * @param bg_no			게시판배경번호
	 * ------this------
	 * @param line_title	한줄게시판 책 제목
	 * @param line_author	한줄게시판 책 저자
	 * @param line_content	한줄게시판 책 내용
	 * @param tend_code		한줄게시판 한줄의 성향
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

	@Override
	public String toString() {
		return "LineBoardVO [line_title=" + line_title + ", line_author=" + line_author + ", line_content="
				+ line_content + ", tend_code=" + tend_code + ", getBoard_no()=" + getBoard_no()
				+ ", getBoardtype_no()=" + getBoardtype_no() + ", getId()=" + getId() + ", getBoard_regdate()="
				+ getBoard_regdate() + ", getHit()=" + getHit() + ", getSympathy()=" + getSympathy()
				+ ", getAuthority()=" + getAuthority() + ", getBg_no()=" + getBg_no() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
