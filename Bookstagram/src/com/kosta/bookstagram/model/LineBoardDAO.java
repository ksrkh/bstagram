package com.kosta.bookstagram.model;

import java.sql.SQLException;
import java.util.ArrayList;

public class LineBoardDAO extends BoardDAO{
	//Singleton pattern 
	private static LineBoardDAO instance = new LineBoardDAO();	
	private LineBoardDAO(){System.out.println("LineBoardDAO() 객체생성 싱글톤 적용");}
	public static LineBoardDAO getInstance(){return instance;}
	
	/*
	 * 한줄 글등록
	 * LineVO에 ArrayList<LineTendVO> 생성 controller에서 처리 후에 등록
	 */
	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		System.out.println("LineBoardDAO, insertBoard() 실행");
	}

	/*
	 * 한줄 수정하기
	 */
	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		System.out.println("LineBoardDAO, updateBoard() 실행");
	}
	
	/*
	 * 글 번호(검색)
	 * 한줄 삭제하기
	 */
	@Override
	public void deleteBoard(int boardNo) throws SQLException {
		System.out.println("LineBoardDAO, deleteBoard() 실행");
	}

	/*
	 * 글 번호(검색)
	 * 한줄 상세보기 
	 */
	@Override
	public BoardVO selectBoard(int boardNo) throws SQLException {
		BoardVO dvo=new BoardVO();
		
		return dvo;
	}
	
	/*
	* 첫 메인 페이지 view
	*/
	@Override
	public ArrayList<BoardVO> boardList(int boardType) throws SQLException {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		//사용 예시
		list.add(new LineBoardVO());
		list.add(new LineBoardVO());
		list.add(new LineBoardVO());
		
		return list;
	}
}
