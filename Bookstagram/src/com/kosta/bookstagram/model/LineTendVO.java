package com.kosta.bookstagram.model;

public class LineTendVO {
	/*
	 * 성향코드
	 */
	private int tend_code;
	/*
	 * 성향 명
	 */
	private String tend_name;
	/*
	 * 기본생성자
	 */
	public LineTendVO() {}
	
	public LineTendVO(String tend_name) {
		super();
		this.tend_name = tend_name;
	}

	/**
	 * @param tend_code 성향코드
	 * @param tend_name 성향명
	 */
	public LineTendVO(int tend_code, String tend_name) {
		super();
		this.tend_code = tend_code;
		this.tend_name = tend_name;
	}
	
	public int getTend_code() {
		return tend_code;
	}
	
	public void setTend_code(int tend_code) {
		this.tend_code = tend_code;
	}
	
	public String getTend_name() {
		return tend_name;
	}
	
	public void setTend_name(String tend_name) {
		this.tend_name = tend_name;
	}
	
	@Override
	public String toString() {
		return "LineTendVO [tend_code=" + tend_code + ", tend_name=" + tend_name + "]";
	}
}
