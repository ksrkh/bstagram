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
	 * 모든 매개변수를 갖고있는 생성자
	 * @param board_no			게시판번호
	 * @param boardtype_no		게시판타입번호
	 * @param id				아이디
	 * @param nick				닉네임
	 * @param board_regdate		게시판등록일짜
	 * @param hit				조회수
	 * @param sympathy			공감
	 * @param authority			공개권한
	 * @param bg_no				게시글배경번호
	 * @param line_content		한줄게시판내용
	 * @param tend_code			한줄게시판성향
	 * @param book_no			책 번호
	 */
	public LineBoardVO(int board_no, int boardtype_no, String id, String nick, String board_regdate, int hit,
			int sympathy, int authority, int bg_no, String line_content, int tend_code, int book_no) {
		super(board_no, boardtype_no, id, nick, board_regdate, hit, sympathy, authority, bg_no);
		this.line_content = line_content;
		this.tend_code = tend_code;
		this.book_no = book_no;
	}

	/**
	 * -한줄 게시판 글 작성용 생성자<br/>
	 * @param board_no		게시글번호
	 * @param boardtype_no	게시글타입번호
	 * @param id			아이디
	 * @param board_regdate	게시글등록일자
	 * @param hit			조회수
	 * @param authority		공개권한
	 * @param bg_no			게시글배경번호
	 * @param line_content	한줄게시판 내용
	 * @param tend_code		한줄게시판 성향
	 * @param book_no		책번호
	 */
	public LineBoardVO(int board_no, int boardtype_no, String id, String board_regdate, int hit, int authority,
			int bg_no, String line_content, int tend_code, int book_no) {
		super(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no);
		this.line_content = line_content;
		this.tend_code = tend_code;
		this.book_no = book_no;
	}
	
	/**
	 * -한줄게시판 글 상세보기용 생성자<br/>
	 * @param board_no		게시글번호
	 * @param boardtype_no	게시글타입번호
	 * @param nick			닉네임
	 * @param board_regdate	게시글등록일자
	 * @param hit			조회수
	 * @param sympathy		공감
	 * @param authority		공개권한
	 * @param bg_no			게시글배경번호
	 * @param line_content	한줄게시판 내용
	 * @param tend_code		한줄게시판 성향
	 * @param book_no		책번호
	 */
	public LineBoardVO(int board_no, int boardtype_no, String nick, String board_regdate, int hit, int sympathy,
			int authority, int bg_no, String line_content, int tend_code, int book_no) {
		super(board_no, boardtype_no, nick, board_regdate, hit, sympathy, authority, bg_no);
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
