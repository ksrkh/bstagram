package com.kosta.bookstagram.model;

public class PasswordQuestionVO {
	/*
	 * 비밀번호 찾기 질문 코드
	 */
	private int question_code;
	/*
	 * 비밀번호 찾기 질문
	 */
 	private String question;
 	
 	/**
 	 * 기본생성자
 	 */
 	public PasswordQuestionVO() {}
 	
	public PasswordQuestionVO(int question_code, String question) {
		super();
		this.question_code = question_code;
		this.question = question;
	}
	
	public int getQuestion_code() {
		return question_code;
	}
	
	public void setQuestion_code(int question_code) {
		this.question_code = question_code;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "PasswordQuestionVO [question_code=" + question_code + ", question=" + question + "]";
	}
}
