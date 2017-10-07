package com.kosta.bookstagram.model.common;

public class ReReplyVO {
	/*
	 * 리리플 번호
	 */
	private int re_reply_no;
	/*
	 * 리리플 내용
	 */
	private String re_reply_content;
	/*
	 * 리플번호
	 */
	private int reply_no;
	/*
	 * 아이디
	 */
	private String id;
	/*
	 * 기본생성자
	 */
	public ReReplyVO() {}
	
	/**
	 * @param re_reply_no		리리플번호
	 * @param re_reply_content	리리플내용
	 * @param reply_no			리플번호
	 * @param id				아이디
	 */
	public ReReplyVO(int re_reply_no, String re_reply_content, int reply_no, String id) {
		super();
		this.re_reply_no = re_reply_no;
		this.re_reply_content = re_reply_content;
		this.reply_no = reply_no;
		this.id = id;
	}

	public int getRe_reply_no() {
		return re_reply_no;
	}

	public void setRe_reply_no(int re_reply_no) {
		this.re_reply_no = re_reply_no;
	}

	public String getRe_reply_content() {
		return re_reply_content;
	}

	public void setRe_reply_content(String re_reply_content) {
		this.re_reply_content = re_reply_content;
	}

	public int getReply_no() {
		return reply_no;
	}

	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ReReplyVO [re_reply_no=" + re_reply_no + ", re_reply_content=" + re_reply_content + ", reply_no="
				+ reply_no + ", id=" + id + "]";
	}
}
