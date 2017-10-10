package com.kosta.bookstagram.model;

public class LineBoardVO extends BoardVO{
	/*
	 * 한줄게시판 책 내용
	 */
	private String line_content;
	/*
	 * 한줄게시판 작성 글의대한 성향
	 */
	private int tend_code;
	/*
	 * 책번호
	 */
	private int book_no;
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
	 * @param sympathy		공감
	 * @param authority		공개권한
	 * @param bg_no			게시판배경번호
	 * ------this------
	 * @param line_content	한줄게시판 책 내용
	 * @param tend_code		한줄게시판 한줄의 성향
	 * @param book_no		책 번호
	 * 
	 * -매개변수 11개를 입력받아 부모클래스와 자식클래스의 변수에 데이터 세팅
	 */
	public LineBoardVO(int board_no, int boardtype_no, String id, String board_regdate, int hit, int sympathy,
			int authority, int bg_no, String line_content, int tend_code, int book_no) {
		super(board_no, boardtype_no, id, board_regdate, hit, sympathy, authority, bg_no);
		this.line_content = line_content;
		this.tend_code = tend_code;
		this.book_no = book_no;
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
	
	public int getBook_no() {
		return book_no;
	}
	
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	
	@Override
	public String toString() {
		return "LineBoardVO [line_content=" + line_content + ", tend_code=" + tend_code + ", book_no=" + book_no + "]";
	}
}
