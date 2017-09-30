package com.kosta.bookstagram.model;

public class ReviewGenreVO {
	/*
	 * 장르 코드
	 */
	private int genre;
	/*
	 * 장르 명
	 */
	private String genre_name;
	/*
	 * 기본생성자
	 */
	public ReviewGenreVO() {}
	
	/**
	 * @param genre			장르 코드
	 * @param genre_name	장르 명
	 */
	public ReviewGenreVO(int genre, String genre_name) {
		super();
		this.genre = genre;
		this.genre_name = genre_name;
	}
	
	public int getGenre() {
		return genre;
	}
	
	public void setGenre(int genre) {
		this.genre = genre;
	}
	
	public String getGenre_name() {
		return genre_name;
	}
	
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	
	@Override
	public String toString() {
		return "ReviewGenreVO [genre=" + genre + ", genre_name=" + genre_name + "]";
	}
}
