package com.kosta.bookstagram.model.listener;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kosta.bookstagram.model.common.ReReplyVO;
import com.kosta.bookstagram.model.common.ReplyVO;

public interface BoardListener {
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -리플을 등록하는 기능입니다.
	 * </pre>
	 * 
	 * @param	id				회원아이디
	 * @param 	replyNo			리플번호
	 * @param	content			리플내용
	 * @throws 	SQLException
	 */
	public void registerReply(String id, int boardNo, String content) throws SQLException;
	
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -리리플을 등록하는 기능입니다.
	 * </pre>
	 * 
	 * @param 	id			아이디
	 * @param 	replyNo		리플번호
	 * @param 	content		리리플내용
	 * @throws 	SQLException
	 */
	public void registerReReply(String id, int replyNo, String content) throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -리플번호를 통해 리플을 삭제합니다.
	 * </pre>
	 * 
	 * @param 	replyNo			리플번호
	 * @throws 	SQLException
	 */
	public void removeReply(int replyNo) throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -리리플번호를 통해 리리플을 삭제합니다.
	 * </pre>
	 * 
	 * @param 	reReplyNo			리리플번호
	 * @throws 	SQLException
	 */
	public void removeReReply(int rereplyNo) throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시판번호를 통해 해당 게시판의 리플들을 보여줍니다.
	 * </pre>
	 * 
	 * @param 	boardNo				게시판번호
	 * @return	ArrayList<ReplyVO>	리플들이 담긴 ArrayList
	 * @throws 	SQLException
	 */
	public ArrayList<ReplyVO> viewReply(int boardNo) throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -가져온 리플의 리플번호로 리리플을 조회해서 가져옵니다.
	 * </pre>
	 * 
	 * @param 	ArrayList<ReplyVO>		게시판에서 조회한 리플들의 ArrayList
	 * @return	ArrayList<ReReplyVO>	리리플들이 담긴 ArrayList
	 * @throws 	SQLException
	 */
	public ArrayList<ReReplyVO> viewReReply(ArrayList<ReplyVO> replyList) throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시글의 대한 공감을 표현하는 기능입니다.
	 * </pre>
	 * 
	 * @param	id				아이디
	 * @param 	boardNo			게시글번호
	 * @throws 	SQLException
	 */
	public void likeService(String id, int boardNo) throws SQLException;

	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시글의 대한 조회수를 증가하는 기능입니다.
	 * </pre>
	 * 
	 * @param 	boardNo			게시글번호
	 * @throws 	SQLException
	 */
	public void hits(int boardNo) throws SQLException;
	
}
