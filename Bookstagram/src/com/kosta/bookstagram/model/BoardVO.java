package com.kosta.bookstagram.model;

public class BoardVO {
	/*
	 * 게시판번호
	 */
	private int board_no;
	/*
	 * 게시판 타입번호
	 */
	private int boardtype_no;
	/*
	 * 사용자 아이디(이메일)
	 */
	private String id;
	/*
	 * 닉네임
	 */
	private String nick;
	/*
	 * 게시판 등록일자
	 */
	private String board_regdate;
	/*
	 * 조회수
	 */
	private int hit;
	/*
	 * 공감
	 */
	private int sympathy;
	/*
	 * 공개권한
	 */
	private int authority;
	/*
	 * 게시판 배경 번호
	 */
	private int bg_no;
	
	/*
	 * 기본 생성자
	 */
	public BoardVO() {}
	
	/**
	 * @param board_no		게시판번호
	 * @param boardtype_no	게시판타입번호
	 * @param id			아이디
	 * @param board_regdate	등록일자
	 * @param hit			조회수
	 * @param sympathy		공감
	 * @param authority		공개권한
	 * @param bg_no			게시판배경번호
	 */
	public BoardVO(int board_no, int boardtype_no, String id, String board_regdate, int hit, int sympathy,
			int authority, int bg_no) {
		super();
		this.board_no = board_no;
		this.boardtype_no = boardtype_no;
		this.id = id;
		this.board_regdate = board_regdate;
		this.hit = hit;
		this.sympathy = sympathy;
		this.authority = authority;
		this.bg_no = bg_no;
	}
	
	/**
	 * @param board_no		게시판번호
	 * @param boardtype_no	게시판타입번호
	 * @param id			아이디
	 * @param nick			닉네임
	 * @param board_regdate	등록일자
	 * @param hit			조회수
	 * @param sympathy		공감
	 * @param authority		공개권한
	 * @param bg_no			게시판배경번호
	 */
	public BoardVO(int board_no, int boardtype_no, String id, String nick, String board_regdate, int hit, int sympathy,
			int authority, int bg_no) {
		super();
		this.board_no = board_no;
		this.boardtype_no = boardtype_no;
		this.id = id;
		this.nick = nick;
		this.board_regdate = board_regdate;
		this.hit = hit;
		this.sympathy = sympathy;
		this.authority = authority;
		this.bg_no = bg_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getBoardtype_no() {
		return boardtype_no;
	}

	public void setBoardtype_no(int boardtype_no) {
		this.boardtype_no = boardtype_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getBoard_regdate() {
		return board_regdate;
	}

	public void setBoard_regdate(String board_regdate) {
		this.board_regdate = board_regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getSympathy() {
		return sympathy;
	}

	public void setSympathy(int sympathy) {
		this.sympathy = sympathy;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public int getBg_no() {
		return bg_no;
	}

	public void setBg_no(int bg_no) {
		this.bg_no = bg_no;
	}

	@Override
	public String toString() {
		return "BoardVO [board_no=" + board_no + ", boardtype_no=" + boardtype_no + ", id=" + id + ", board_regdate="
				+ board_regdate + ", hit=" + hit + ", sympathy=" + sympathy + ", authority=" + authority + ", bg_no="
				+ bg_no + "]";
	}
}
