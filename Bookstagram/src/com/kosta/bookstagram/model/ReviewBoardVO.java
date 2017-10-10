package com.kosta.bookstagram.model;

public class ReviewBoardVO extends BoardVO{
	/*
	 * 책 리뷰 게시글 제목
	 */
	private  String review_title;
	/*
	 * 책 리뷰 게시글 내용
	 */
	private  String review_content;
	/*
	 * 작성자가 생각하는 책의 대한 별점
	 */
	private  int star_point;
	/*
	 * 책의 장르
	 */
	private  int genre;
	/*
	 * 책 번호
	 */
	private  int book_no;
	/*
	 * 기본 생성자
	 */
	public ReviewBoardVO() {}
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
	 * @param review_title		게시글제목
	 * @param review_content	게시글내용
	 * @param star_point		책별점
	 * @param genre				책장르
	 * @param book_no			책번호
	 * 
	 * -매개변수 13개를 입력받아 부모클래스와 자식클래스의 변수에 데이터 세팅
	 */
	public ReviewBoardVO(int board_no, int boardtype_no, String id, String board_regdate, int hit, int sympathy,
			int authority, int bg_no, String review_title, String review_content, int star_point, int genre, int book_no) {
		super(board_no, boardtype_no, id, board_regdate, hit, sympathy, authority, bg_no);
		this.review_title = review_title;
		this.review_content = review_content;
		this.star_point = star_point;
		this.genre = genre;
		this.book_no = book_no;
	}

	public String getReview_title() {
		return review_title;
	}

	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public int getStar_point() {
		return star_point;
	}

	public void setStar_point(int star_point) {
		this.star_point = star_point;
	}

	public int getGenre() {
		return genre;
	}

	public void setGenre(int genre) {
		this.genre = genre;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
}
