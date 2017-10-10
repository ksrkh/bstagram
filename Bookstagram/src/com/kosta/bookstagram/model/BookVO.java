package com.kosta.bookstagram.model;

public class BookVO {
	/*
	 * 책번호
	 */
	private int book_no;
	/*
	 * 책제목
	 */
	private String book_title;
	/*
	 * 책소개
	 */
	private String book_intro;
	/*
	 * 책저자
	 */
	private String book_author;
	/*
	 * 책출판사
	 */
	private String book_publ;
	/*
	 * 책출간시작일
	 */
	private String book_sdate;
	/*
	 * 책출간종료일
	 */
	private String book_edate;
	/*
	 * 책검색카테고리
	 */
	private String book_cate;
	/*
	 * 책썸네일
	 */
	private String book_img;
	/*
	 * 기본생성자
	 */
	public BookVO() {}

	/**
	 * @param book_no 		책번호
	 * @param book_title	책제목
	 * @param book_intro	책소개
	 * @param book_author	책저자
	 * @param book_publ		출판사
	 * @param book_sdate	출간시작날짜
	 * @param book_edate	출간종료날짜
	 * @param book_cate		검색카테고리
	 * @param book_img		책이미지
	 */
	public BookVO(int book_no, String book_title, String book_intro, String book_author, String book_publ,
			String book_sdate, String book_edate, String book_cate, String book_img) {
		super();
		this.book_no = book_no;
		this.book_title = book_title;
		this.book_intro = book_intro;
		this.book_author = book_author;
		this.book_publ = book_publ;
		this.book_sdate = book_sdate;
		this.book_edate = book_edate;
		this.book_cate = book_cate;
		this.book_img = book_img;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBook_intro() {
		return book_intro;
	}

	public void setBook_intro(String book_intro) {
		this.book_intro = book_intro;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_publ() {
		return book_publ;
	}

	public void setBook_publ(String book_publ) {
		this.book_publ = book_publ;
	}

	public String getBook_sdate() {
		return book_sdate;
	}

	public void setBook_sdate(String book_sdate) {
		this.book_sdate = book_sdate;
	}

	public String getBook_edate() {
		return book_edate;
	}

	public void setBook_edate(String book_edate) {
		this.book_edate = book_edate;
	}

	public String getBook_cate() {
		return book_cate;
	}

	public void setBook_cate(String book_cate) {
		this.book_cate = book_cate;
	}

	public String getBook_img() {
		return book_img;
	}

	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}

	@Override
	public String toString() {
		return "BookVO [book_no=" + book_no + ", book_title=" + book_title + ", book_intro=" + book_intro
				+ ", book_author=" + book_author + ", book_publ=" + book_publ + ", book_sdate=" + book_sdate
				+ ", book_edate=" + book_edate + ", book_cate=" + book_cate + ", book_img=" + book_img + "]";
	}
}
