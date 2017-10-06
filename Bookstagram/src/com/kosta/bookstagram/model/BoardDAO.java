package com.kosta.bookstagram.model;

import java.sql.SQLException;

import com.kosta.bookstagram.model.common.CommonDAO;
import com.kosta.bookstagram.model.listener.BoardListener;

public abstract class BoardDAO extends CommonDAO implements BoardListener{
	
	public BoardDAO(){System.out.println("BoardDAO 객체생성");}
	
	@Override
	public void addReply(int replyNo) throws SQLException {
		System.out.println("addReply() 실행");
	}

	@Override
	public void removeReply(int replyNo) throws SQLException {
		System.out.println("removeReply() 실행");
	}

	@Override
	public void addLike(int boardNo) throws SQLException {
		System.out.println("addLike() 실행");
	}

	@Override
	public void backLike(int boardNo) throws SQLException {
		System.out.println("backLike() 실행");
	}

	@Override
	public void addHit(int boardNo) throws SQLException {
		System.out.println("addHit() 실행");
	}
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시글 작성 기능을 구현합니다.
	 * </pre>
	 * 
	 * @throws SQLException
	 */
	public abstract void insertBoard() throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시글 수정 기능을 구현합니다.
	 * </pre>
	 * 
	 * @throws SQLException
	 */
	public abstract void updateBoard() throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시글 삭제 기능을 구현합니다.
	 * </pre>
	 * 
	 * @throws SQLException
	 */
	public abstract void deleteBoard() throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시글 상세보기 기능을 구현합니다.
	 * </pre>
	 * 
	 * @throws SQLException
	 */
	public abstract void selectBoard() throws SQLException;
}
