package com.kosta.bookstagram.model.common;

public class ReplyVO {
	/*
	 * 리플번호
	 */
	private int reply_no;
	/*
	 * 리플내용
	 */
	private String reply_content;
	/*
	 * 작성 게시판번호
	 */
	private int board_no;
	/*
	 * 작성자 아이디
	 */
	private String id;
	/*
	 * 기본생성자
	 */
	public ReplyVO() {}
	
	/**
	 * @param reply_no			리플번호
	 * @param reply_content		리플내용
	 * @param board_no			게시판번호
	 * @param id				작성자아이디
	 */
	public ReplyVO(int reply_no, String reply_content, int board_no, String id) {
		super();
		this.reply_no = reply_no;
		this.reply_content = reply_content;
		this.board_no = board_no;
		this.id = id;
	}

	public int getReply_no() {
		return reply_no;
	}

	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ReplyVO [reply_no=" + reply_no + ", reply_content=" + reply_content + ", board_no=" + board_no + ", id="
				+ id + "]";
	}
}
