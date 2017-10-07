package com.kosta.bookstagram.model;

import java.sql.SQLException;

public class ReviewBoardDAO extends BoardDAO{
	private static ReviewBoardDAO instance = new ReviewBoardDAO();	
	private ReviewBoardDAO(){System.out.println("ReviewBoardDAO() 객체생성 싱글톤 적용");}
	public static ReviewBoardDAO getInstance(){return instance;}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		System.out.println("ReviewBoardDAO, insertBoard() 실행");}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		System.out.println("ReviewBoardDAO, updateBoard() 실행");}

	@Override
	public void deleteBoard(int boardNo) throws SQLException {
		System.out.println("ReviewBoardDAO, deleteBoard() 실행");}

	@Override
	public BoardVO selectBoard(int boardNo) throws SQLException {
		System.out.println("ReviewBoardDAO, selectBoard() 실행");
		return null;}

}
