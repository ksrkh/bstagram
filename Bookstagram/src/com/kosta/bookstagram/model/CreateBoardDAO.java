package com.kosta.bookstagram.model;

import java.sql.SQLException;

public class CreateBoardDAO extends BoardDAO{
	
	private static CreateBoardDAO instance = new CreateBoardDAO();	
	private CreateBoardDAO(){System.out.println("CreateBoardDAO() 객체생성 싱글톤 적용");}
	public static CreateBoardDAO getInstance(){return instance;}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		//객체 캐스팅하여 사용
		@SuppressWarnings("unused")
		CreateBoardVO boardVO = (CreateBoardVO) board;
		System.out.println("CreateBoardDAO, insertBoard() 실행");}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		System.out.println("CreateBoardDAO, updateBoard() 실행");}

	@Override
	public void deleteBoard(int boardNo) throws SQLException {
		System.out.println("CreateBoardDAO, deleteBoard() 실행");}

	@Override
	public BoardVO selectBoard(int boardNo) throws SQLException {
		System.out.println("CreateBoardDAO, selectBoard() 실행");
		return null;}
}
