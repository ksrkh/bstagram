package com.kosta.bookstagram.model;

import java.sql.SQLException;
import java.util.ArrayList;

public class CreateBoardDAO extends BoardDAO{
	//Singleton pattern 
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
	
	@Override
	public ArrayList<BoardVO> boardList(int boardType) throws SQLException {
		//사용 예시
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		list.add(new CreateBoardVO(3, 3, "orangss@naver.com", "2017-09-01", 0, 0, 1, 0, "창작의 시작1", "창작한 내용1", 4));
		list.add(new CreateBoardVO(4, 3, "kjhsc101218@naver.com", "2017-09-02", 0, 0, 1, 0, "창작의 시작2", "창작한 내용2", 5));
		list.add(new CreateBoardVO(5, 3, "asdfqwer@naver.com", "2017-09-03", 0, 0, 1, 0, "창작의 시작3", "창작한 내용3", 2));
		
		return list;
	}
}
