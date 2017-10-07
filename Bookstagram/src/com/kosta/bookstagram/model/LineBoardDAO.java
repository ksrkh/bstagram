package com.kosta.bookstagram.model;

import java.sql.SQLException;
import java.util.ArrayList;

public class LineBoardDAO extends BoardDAO{
	//Singleton pattern 
	private static LineBoardDAO instance = new LineBoardDAO();	
	private LineBoardDAO(){System.out.println("LineBoardDAO() 객체생성 싱글톤 적용");}
	public static LineBoardDAO getInstance(){return instance;}
	
	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		System.out.println("LineBoardDAO, insertBoard() 실행");}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		System.out.println("LineBoardDAO, updateBoard() 실행");}

	@Override
	public void deleteBoard(int boardNo) throws SQLException {
		System.out.println("LineBoardDAO, deleteBoard() 실행");}

	@Override
	public BoardVO selectBoard(int boardNo) throws SQLException {
		System.out.println("LineBoardDAO, selectBoard() 실행");
		return null;}
	
	@Override
	public ArrayList<BoardVO> boardList(int boardType) throws SQLException {
		//사용 예시
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		list.add(new LineBoardVO());
		list.add(new LineBoardVO());
		list.add(new LineBoardVO());
		
		return list;
	}

}
