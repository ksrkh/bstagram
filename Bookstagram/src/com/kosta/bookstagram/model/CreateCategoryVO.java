package com.kosta.bookstagram.model;

public class CreateCategoryVO {
	/*
	 * 창작게시판 카테고리
	 */
	private int category;
	/*
	 * 창작게시판 카테고리 명
	 */
	private String category_name;
	/*
	 * 기본생성자
	 */
	public CreateCategoryVO() {}
	
	
	public CreateCategoryVO(String category_name) {
		super();
		this.category_name = category_name;
	}
	/**
	 * @param category		창작게시판 카테고리 분류
	 * @param category_name	창작게시판 카테고리 명
	 */
	public CreateCategoryVO(int category, String category_name) {
		super();
		this.category = category;
		this.category_name = category_name;
	}
	
	public int getCategory() {
		return category;
	}
	
	public void setCategory(int category) {
		this.category = category;
	}
	
	public String getCategory_name() {
		return category_name;
	}
	
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	@Override
	public String toString() {
		return "CreateCategoryVO [category=" + category + ", category_name=" + category_name + "]";
	}
}
