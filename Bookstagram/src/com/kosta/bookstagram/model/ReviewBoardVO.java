package com.kosta.bookstagram.model;

public class ReviewBoardVO extends BoardVO{
	/*
	 * 도서 제목
	 */
	private  String book_title;
	/*
	 * 도서 저자
	 */
	private  String book_author;
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
	 * 책 썸네일(미리보기 이미지)
	 */
	private  String book_img;
	/*
	 * 책의 장르
	 */
	private  int genre;
	/*
	 * 기본생성자
	 */
	public ReviewBoardVO() {}
	
	/**
	 * -----super-----
	 * @param board_no			게시판번호
	 * @param boardtype_no		게시판타입번호
	 * @param id				아이디
	 * @param board_regdate		등록일자
	 * @param hit				조회수
	 * @param sympathy			좋아요
	 * @param authority			공개권한
	 * @param bg_no				게시판배경번호
	 * ------this------
	 * @param book_title		책제목
	 * @param book_author		책저자
	 * @param review_title		게시글제목
	 * @param review_content	게시글내용
	 * @param star_point		책별점
	 * @param book_img			책썸네일
	 * @param genre				책장르
	 * 
	 * -매개변수 15개를 입력받아 부모클래스와 자식클래스의 변수에 데이터 세팅
	 */
	public ReviewBoardVO(int board_no, int boardtype_no, String id, String board_regdate, int hit, int sympathy,
			int authority, int bg_no, String book_title, String book_author, String review_title, String review_content,
			int star_point, String book_img, int genre) {
		super(board_no, boardtype_no, id, board_regdate, hit, sympathy, authority, bg_no);
		this.book_title = book_title;
		this.book_author = book_author;
		this.review_title = review_title;
		this.review_content = review_content;
		this.star_point = star_point;
		this.book_img = book_img;
		this.genre = genre;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
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

	public String getBook_img() {
		return book_img;
	}

	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}

	public int getGenre() {
		return genre;
	}

	public void setGenre(int genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "ReviewBoardVO [book_title=" + book_title + ", book_author=" + book_author + ", review_title="
				+ review_title + ", review_content=" + review_content + ", star_point=" + star_point + ", book_img="
				+ book_img + ", genre=" + genre + ", getBoard_no()=" + getBoard_no() + ", getBoardtype_no()="
				+ getBoardtype_no() + ", getId()=" + getId() + ", getBoard_regdate()=" + getBoard_regdate()
				+ ", getHit()=" + getHit() + ", getSympathy()=" + getSympathy() + ", getAuthority()=" + getAuthority()
				+ ", getBg_no()=" + getBg_no() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
}
