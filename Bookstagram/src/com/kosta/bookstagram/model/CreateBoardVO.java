package com.kosta.bookstagram.model;

public class CreateBoardVO extends BoardVO {
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
	public CreateBoardVO() {
	}

	/**
	 * -모든 매개변수를 갖고있는 생성자<br/>
	 * 
	 * @param board_no			게시판번호
	 * @param boardtype_no		게시판타입번호
	 * @param id				아이디
	 * @param nick				닉네임
	 * @param board_regdate		게시판 등록일짜
	 * @param hit				조회수
	 * @param sympathy			공감
	 * @param authority			글공개권한
	 * @param bg_no				글배경
	 * @param create_title		창작게시글제목
	 * @param create_content	창작게시글내용
	 * @param category			게시글분류
	 */
	public CreateBoardVO(int board_no, int boardtype_no, String id, String nick, String board_regdate, int hit,
			int sympathy, int authority, int bg_no, String create_title, String create_content, int category) {
		super(board_no, boardtype_no, id, nick, board_regdate, hit, sympathy, authority, bg_no);
		this.create_title = create_title;
		this.create_content = create_content;
		this.category = category;
	}

	/**
	 * 창작게시글 작성에 필요<br/>
	 * 
	 * @param boardtype_no		게시글타입번호
	 * @param id				아이디
	 * @param authority			공개권한
	 * @param bg_no				게시글배경번호
	 * @param create_title		창작게시글제목
	 * @param create_content	창작게시글내용
	 * @param category			창작게시물분류
	 */
	public CreateBoardVO(int boardtype_no, String id, int authority, int bg_no, String create_title,
			String create_content, int category) {
		super(boardtype_no, id, authority, bg_no);
		this.create_title = create_title;
		this.create_content = create_content;
		this.category = category;
	}
	
	/**
	 * 창작게시글 업데이트에 필요<br/>
	 * @param board_no			게시판번호
	 * @param boardtype_no		게시글타입번호
	 * @param id				아이디
	 * @param authority			공개권한
	 * @param bg_no				게시글배경번호
	 * @param create_title		창작게시글제목
	 * @param create_content	창작게시글내용
	 * @param category			창작게시물분류
	 */
	public CreateBoardVO(int board_no,int boardtype_no, String id, int authority, int bg_no,
			String create_title, String create_content, int category) {
		super(board_no,boardtype_no, id, authority, bg_no);
		this.create_title = create_title;
		this.create_content = create_content;
		this.category = category;
	}
	
	/**
	 * 창작게시글 상세보기에 필요<br/>
	 * 
	 * @param board_no			게시글번호
	 * @param boardtype_no		게시글타입
	 * @param id				아이디
	 * @param nick				닉네임
	 * @param board_regdate		게시글작성일자
	 * @param hit				조회수
	 * @param authority			공개권한
	 * @param bg_no				게시글배경번호
	 * @param create_title		창작게시글제목
	 * @param create_content	창작게시글내용
	 * @param category			창작게시글분류
	 */
	public CreateBoardVO(int board_no, int boardtype_no,String id, String nick, String board_regdate, int hit, int authority,
			int bg_no, String create_title, String create_content, int category) {
		super(board_no, boardtype_no,id, nick, board_regdate, hit, authority, bg_no);
		this.create_title = create_title;
		this.create_content = create_content;
		this.category = category;
	}
	/**
	 * 창작게시글 상세보기에 필요<br/>
	 * 
	 * @param board_no			게시글번호
	 * @param boardtype_no		게시글타입
	 * @param id				아이디
	 * @param nick				닉네임
	 * @param board_regdate		게시글작성일자
	 * @param hit				조회수
	 * @param authority			공개권한
	 * @param bg_no				게시글배경번호
	 * @param bg_path			게시글배경경로
	 * @param create_title		창작게시글제목
	 * @param create_content	창작게시글내용
	 * @param category			창작게시글분류
	 */
	public CreateBoardVO(int board_no, int boardtype_no,String id, String nick, String board_regdate, int hit, int authority,
			int bg_no,String bg_path, String create_title, String create_content, int category) {
		super(board_no, boardtype_no,id, nick, board_regdate, hit, authority, bg_no, bg_path);
		this.create_title = create_title;
		this.create_content = create_content;
		this.category = category;
	}

	/**
	 * 창작게시글 목록 보기에 필요<br/>
	 * 
	 * @param board_no
	 * @param nick
	 * @param board_regdate
	 * @param hit
	 * @param create_title
	 */
	public CreateBoardVO(int board_no, String nick, String board_regdate, int hit, String create_title) {
		super(board_no, nick, board_regdate, hit);
		this.create_title = create_title;

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
				+ getBg_no()+ getBg_path() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
}
