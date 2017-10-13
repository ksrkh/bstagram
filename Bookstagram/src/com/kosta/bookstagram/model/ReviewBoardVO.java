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
	
	private BookVO bookVO;
	/*
	 * 기본 생성자
	 */
	public ReviewBoardVO() {}
	/**
	 * -모든 매개변수를 갖고있는 생성자<br/>
	 * @param board_no			게시글번호
	 * @param boardtype_no		게시글타입번호
	 * @param id				아이디
	 * @param nick				닉네임
	 * @param board_regdate		게시글등록일짜
	 * @param hit				조회수
	 * @param sympathy			공감
	 * @param authority			게시글공개권한
	 * @param bg_no				게시글배경번호
	 * @param review_title		독후감제목
	 * @param review_content	독후감내용
	 * @param star_point		독후감별점
	 * @param genre				독후감장르
	 * @param book_no			독후감 책번호
	 */
	public ReviewBoardVO(int board_no, int boardtype_no, String id, String nick, String board_regdate, int hit,
			int sympathy, int authority, int bg_no, String review_title, String review_content, int star_point,
			int genre, int book_no) {
		super(board_no, boardtype_no, id, nick, board_regdate, hit, sympathy, authority, bg_no);
		this.review_title = review_title;
		this.review_content = review_content;
		this.star_point = star_point;
		this.genre = genre;
		this.book_no = book_no;
	}
	
	/**
	 * -리뷰 게시글 작성용 생성자입니다.<br/>
	 * @param boardtype_no		게시글타입번호
	 * @param id				아이디
	 * @param authority			공개권한
	 * @param bg_no				게시글배경번호
	 * @param review_title		리뷰제목
	 * @param review_content	리뷰내용
	 * @param star_point		리뷰별점
	 * @param genre				리뷰장르
	 * @param book_no			책번호
	 */
	public ReviewBoardVO(int boardtype_no, String id, int authority, int bg_no,
			String review_title, String review_content, int star_point, int genre, int book_no) {
		super(boardtype_no, id, authority, bg_no);
		this.review_title = review_title;
		this.review_content = review_content;
		this.star_point = star_point;
		this.genre = genre;
		this.book_no = book_no;
	}
	
	/**
	 * -리뷰 게시글 상세보기용 생성자입니다.<br/>
	 * @param board_no			게시글번호
	 * @param boardtype_no		게시글타입번호
	 * @param nick				닉네임
	 * @param board_regdate		게시글등록일자
	 * @param hit				조회수
	 * @param authority			공개권한
	 * @param bg_no				게시글배경번호
	 * @param review_title		리뷰제목
	 * @param review_content	리뷰내용
	 * @param star_point		리뷰별점
	 * @param genre				리뷰장르
	 * @param book_no			리뷰책번호
	 */
	public ReviewBoardVO(int board_no, int boardtype_no, String nick, String board_regdate, int hit,
			int authority, int bg_no, String review_title, String review_content, int star_point, int genre,
			int book_no) {
		super(board_no, boardtype_no, nick, board_regdate, hit, authority, bg_no);
		this.review_title = review_title;
		this.review_content = review_content;
		this.star_point = star_point;
		this.genre = genre;
		this.book_no = book_no;
	}
	
	/**
	 * 리뷰 게시글  목록 보기에 필요<br/>
	 * @param board_no			게시판번호
	 * @param nick				작성자
	 * @param board_regdate		등록일자
	 * @param hit				조회수
	 * @param review_title		리뷰제목
	 * @param review_content	리뷰내용
	 * @param star_point		리뷰별점
	 * @param genre				리뷰장르
	 * @param bookVO			책정보
	 */
	public ReviewBoardVO(int board_no, String nick, String board_regdate, int hit,
			String review_title, String review_content, int star_point, int genre, int book_no, BookVO bookVO) {
		super(board_no, nick, board_regdate, hit);
		this.review_title = review_title;
		this.review_content = review_content;
		this.star_point = star_point;
		this.genre = genre;
		this.book_no =book_no;
		this.bookVO=bookVO;
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
	public BookVO getBookVO() {
		return bookVO;
	}
	public void setBookVO(BookVO bookVO) {
		this.bookVO = bookVO;
	}
	
}
