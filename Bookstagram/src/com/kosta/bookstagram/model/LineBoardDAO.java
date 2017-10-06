package com.kosta.bookstagram.model;

import java.sql.SQLException;

public class LineBoardDAO extends BoardDAO{
	private static LineBoardDAO instance = new LineBoardDAO();	
	private LineBoardDAO(){System.out.println("LineBoardDAO() 객체생성 싱글톤 적용");}
	public static LineBoardDAO getInstance(){return instance;}
	
	@Override
	public void insertBoard() throws SQLException {
		System.out.println("LineBoardDAO, insertBoard() 실행");}

	@Override
	public void updateBoard() throws SQLException {
		System.out.println("LineBoardDAO, updateBoard() 실행");}

	@Override
	public void deleteBoard() throws SQLException {
		System.out.println("LineBoardDAO, deleteBoard() 실행");}

	@Override
	public void selectBoard() throws SQLException {
		System.out.println("LineBoardDAO, selectBoard() 실행");}

}
