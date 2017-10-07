package com.kosta.bookstagram.model.common;

public class SympathyVO {
	/*
	 * 공감자 아이디
	 */
	private String id;
	/*
	 * 공감 게시판 번호
	 */
	private int board_no;
	/*
	 * 기본생성자
	 */
	public SympathyVO() {}
	
	/**
	 * @param id		공감자 아이디
	 * @param board_no	공감 게시판 번호
	 */
	public SympathyVO(String id, int board_no) {
		super();
		this.id = id;
		this.board_no = board_no;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getBoard_no() {
		return board_no;
	}
	
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	
	@Override
	public String toString() {
		return "SympathyVO [id=" + id + ", board_no=" + board_no + "]";
	}
}
