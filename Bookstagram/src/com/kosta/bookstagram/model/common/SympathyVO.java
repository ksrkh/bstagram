package com.kosta.bookstagram.model.common;

public class SympathyVO {
	/*
	 * 공감자 아이디
	 */
	private int likeCount;
	/*
	 * 공감 게시판 번호
	 */
	private int board_no;
	/*
	 * 기본생성자
	 */
	public SympathyVO() {}
	
	/**
	 * @param likeCount		공감자 아이디
	 * @param board_no	공감 게시판 번호
	 */
	public SympathyVO(int likeCount, int board_no) {
		super();
		this.likeCount = likeCount;
		this.board_no = board_no;
	}
	
	public int getlikeCount() {
		return likeCount;
	}
	
	public void setlikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	
	public int getBoard_no() {
		return board_no;
	}
	
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	
	@Override
	public String toString() {
		return "SympathyVO [id=" + likeCount + ", board_no=" + board_no + "]";
	}
}
