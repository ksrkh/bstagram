package com.kosta.bookstagram.model.listener;

import java.sql.SQLException;

public interface BoardListener {
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -리플달기 기능을 구현합니다.
	 * </pre>
	 * 
	 * @param replyNo		리플번호
	 * @throws SQLException
	 */
	public void addReply(int boardNo) throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -리플번호를 통해 리플을 삭제합니다.
	 * </pre>
	 * 
	 * @param replyNo		리플번호
	 * @throws SQLException
	 */
	public void removeReply(int replyNo)  throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시글의 대한 공감을 표현하는 기능입니다.
	 * </pre>
	 * 
	 * @param boardNo		게시글번호
	 * @throws SQLException
	 */
	public void addLike(int boardNo) throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시글의 대한 공감을 취소하는 기능입니다.
	 * </pre>
	 * 
	 * @param boardNo		게시글번호
	 * @throws SQLException
	 */
	public void backLike(int boardNo) throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시글의 대한 조회수를 증가하는 기능입니다.
	 * </pre>
	 * 
	 * @param boardNo		게시글번호
	 * @throws SQLException
	 */
	public void addHit(int boardNo) throws SQLException;
}
