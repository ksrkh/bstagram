package com.kosta.bookstagram.model;

public class BoardTypeVO {
	/*
	 * 게시판 타입번호
	 */
	private int boardtype_no;
	/*
	 * 게시판 타입명
	 */
	private String boardtype_name;
	/*
	 * 기본생성자
	 */
	public BoardTypeVO() {}
	
	/**
	 * @param boardtype_no		게시판타입번호
	 * @param boardtype_name	게시판타입명
	 */
	public BoardTypeVO(int boardtype_no, String boardtype_name) {
		super();
		this.boardtype_no = boardtype_no;
		this.boardtype_name = boardtype_name;
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
	
	@Override
	public String toString() {
		return "BoardTypeVO [boardtype_no=" + boardtype_no + ", boardtype_name=" + boardtype_name + "]";
	}
}
