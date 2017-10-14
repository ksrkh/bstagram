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
	 * 게시판 타입 명 
	 */
	private String boardtype_name;
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
	 * 관리자게시판 제목부분에 보여줄 편집 내용
	 */
	private String content;
	/*
	 * 기본 생성자
	 */
	public BoardVO() {}
	/**
	 * -모든 매개변수를 갖고있는 생성자 <br/>
	 * -닉네임 포함되어있음<br/>
	 * @param board_no			게시판번호
	 * @param boardtype_no		게시판타입번호
	 * @param id				아이디
	 * @param nick				닉네임
	 * @param board_regdate		등록날짜
	 * @param hit				조회수
	 * @param sympathy			공감
	 * @param authority			글 공개권한
	 * @param bg_no				게시글배경
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
	
	/**
	 * 창작 게시글 작성에 필요한 부모생성자<br/>
	 * -공감,닉네임 제외된 생성자<br/>
	 * @param boardtype_no		게시글타입번호
	 * @param id				아이디
	 * @param authority			공개권한
	 * @param bg_no				게시글배경번호
	 */
	public BoardVO(int boardtype_no, String id, int authority, int bg_no) {
		super();
		this.boardtype_no = boardtype_no;
		this.id = id;
		this.authority = authority;
		this.bg_no = bg_no;
	}

	/**
	 *  창작 게시글 업데이트에 필요한 부모생성자<br/>
	 * -공감,닉네임 제외된 생성자<br/>
	 * @param board_no
	 * @param boardtype_no
	 * @param id
	 * @param authority
	 * @param bg_no
	 */
	public BoardVO(int board_no,int boardtype_no, String id, int authority, int bg_no) {
		super();
		this.board_no = board_no;
		this.boardtype_no = boardtype_no;
		this.id = id;
		this.authority = authority;
		this.bg_no = bg_no;
	}
	
	/**
	 * 창작게시글 상세보기에 필요한 부모생성자 <br/>
	 * -아이디 제외, 닉네임 추가 <br/>
	 * @param board_no			게시글번호
	 * @param boardtype_no		게시글타입번호
	 * @param nick				닉네임
	 * @param board_regdate		게시글생성일짜
	 * @param hit				조회수
	 * @param authority			공개권한
	 * @param bg_no				배경번호
	 */
	public BoardVO(int board_no, int boardtype_no, String nick, String board_regdate, int hit,
	         int authority, int bg_no) {
	     super();
	     this.board_no = board_no;
	     this.boardtype_no = boardtype_no;
	     this.nick = nick;
	     this.board_regdate = board_regdate;
	     this.hit = hit;
	     this.authority = authority;
	     this.bg_no = bg_no;
	}
	
	/**
	 * 창작게시글 상세보기에 필요한 부모생성자 <br/>
	 * -기존 상세보기 생성자에서 id 추가 <br/>
	 * @param board_no
	 * @param boardtype_no
	 * @param id
	 * @param nick
	 * @param board_regdate
	 * @param hit
	 * @param authority
	 * @param bg_no
	 */
	public BoardVO(int board_no, int boardtype_no, String id,String nick, String board_regdate, int hit,
	         int authority, int bg_no) {
	     super();
	     this.board_no = board_no;
	     this.boardtype_no = boardtype_no;
	     this.id = id;
	     this.nick = nick;
	     this.board_regdate = board_regdate;
	     this.hit = hit;
	     this.authority = authority;
	     this.bg_no = bg_no;
	}
	
	/**
	 * 창작게시글 목록보기 필요한 부모 생성자<br/>
	 * @param board_no        	게시글번호
	 * @param nick            	닉네임
	 * @param board_regdate		게시글생성일짜
	 * @param hit				조회수
	 */
	public BoardVO(int board_no, String nick, String board_regdate, int hit) {
	    super();
	    this.board_no = board_no;
	    this.nick = nick;
	    this.board_regdate = board_regdate;
	    this.hit = hit;
	}

	/**
	 * 관리자페이지에서 목록보기에 필요한 생성자<br/>
	 * @param board_no
	 * @param boardtype_no
	 * @param boardtype_name
	 * @param id
	 * @param content
	 * @param board_regdate
	 * @param hit
	 */
	public BoardVO(int board_no, int boardtype_no, String boardtype_name,String id, String content, String board_regdate, int hit) {
		this.board_no = board_no;
		this.boardtype_no = boardtype_no;
		this.boardtype_name = boardtype_name;
		this.id = id;
		this.content = content;
		this.board_regdate = board_regdate;
		this.hit = hit;
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
	
	public String getBoardtype_name() {
		return boardtype_name;
	}
	
	public void setBoardtype_name(String boardtype_name) {
		this.boardtype_name = boardtype_name;
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

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "BoardVO [board_no=" + board_no + ", boardtype_no=" + boardtype_no + ", id=" + id + ", board_regdate="
				+ board_regdate + ", hit=" + hit + ", sympathy=" + sympathy + ", authority=" + authority + ", bg_no="
				+ bg_no + "]";
	}
}
