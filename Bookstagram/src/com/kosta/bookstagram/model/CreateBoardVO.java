package com.kosta.bookstagram.model;

public class CreateBoardVO extends BoardVO{
	/*
	 * 창작 게시판 제목
	 */
	private String create_title;
	/*
	 * 창작 게시판 내용
	 */
	private String create_content;
	/*
	 * 창작 게시판 분류
	 */
	private int category;
	/*
	 * 기본생성자
	 */
	public CreateBoardVO() {}
	/**
	 * -----super-----
	 * @param board_no			게시판번호
	 * @param boardtype_no		게시판타입번호
	 * @param id				아이디
	 * @param board_regdate		등록일자
	 * @param hit				조회수
	 * @param sympathy			공감
	 * @param authority			공개권한
	 * @param bg_no				게시판배경번호
	 * ------this------
	 * @param create_title		창작게시판 제목
	 * @param create_content	창작게시판 내용
	 * @param category			창작게시판 분류
	 * 
	 * -매개변수 11개를 입력받아 부모클래스와 자식클래스의 변수에 데이터 세팅
	 */
	public CreateBoardVO(int board_no, int boardtype_no, String id, String board_regdate, int hit, int sympathy,
			int authority, int bg_no, String create_title, String create_content, int category) {
		super(board_no, boardtype_no, id, board_regdate, hit, sympathy, authority, bg_no);
		this.create_title = create_title;
		this.create_content = create_content;
		this.category = category;
	}

	public String getCreate_title() {
		return create_title;
	}
	
	public void setCreate_title(String create_title) {
		this.create_title = create_title;
	}
	
	public String getCreate_content() {
		return create_content;
	}
	
	public void setCreate_content(String create_content) {
		this.create_content = create_content;
	}
	
	public int getCategory() {
		return category;
	}
	
	public void setCategory(int category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "CreateBoardVO [create_title=" + create_title + ", create_content=" + create_content + ", category="
				+ category + ", getBoard_no()=" + getBoard_no() + ", getBoardtype_no()=" + getBoardtype_no()
				+ ", getId()=" + getId() + ", getBoard_regdate()=" + getBoard_regdate() + ", getHit()=" + getHit()
				+ ", getSympathy()=" + getSympathy() + ", getAuthority()=" + getAuthority() + ", getBg_no()="
				+ getBg_no() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
}
