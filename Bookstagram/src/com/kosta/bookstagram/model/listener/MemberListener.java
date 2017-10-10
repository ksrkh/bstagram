package com.kosta.bookstagram.model.listener;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kosta.bookstagram.model.BoardVO;
import com.kosta.bookstagram.model.MemberVO;

public interface MemberListener {
	/**
	 * <pre>
	 * <b>기능</b>
	 *    -아이디와 비밀번호를 입력받아 로그인기능을 수행합니다.
	 * </pre>
	 * 
	 * @param 	id				회원 아이디
	 * @param 	pw				회원 비밀번호
	 * @return 	MemberVO		회원객체를 리턴합니다.
	 * @throws	SQLException
	 */
	public MemberVO checkMember(String id, String pw) throws SQLException;
	
	/**
	 * <pre>
	 * <b>기능</b>
	 *    -새로운 회원의 정보를 입력받아 회원가입기능을 수행합니다.
	 * </pre>
	 * 
	 * @description 			회원가입 기능을 구현합니다.
	 * @param 	member			새로운 멤버객체
	 * @throws	SQLException
	 */
	public void addMember(MemberVO member) throws SQLException;
	
	/**
	 * <pre>
	 * <b>기능</b>
	 *    -수정될 회원의 정보 입력받아 회원의 정보를 수정합니다.
	 * </pre>
	 * 
	 * @description 			회원정보 수정
	 * @param 	member			수정 될 회원의 정보가 담긴 MemberVO
	 * @throws 	SQLException
	 */
	public void updateMember(MemberVO member) throws SQLException;
	
	/**
	 * <pre>
	 * <b>기능</b>
	 *    -아이디를 입력받아 회원정보의 권한을 0(탈퇴회원)으로 변경합니다.
	 * </pre>
	 * 
	 *  @description 		회원탈퇴
	 *  @param 	id			탈퇴할 회원의 아이디
	 *  @throws SQLException
	 */
	public void withDrawMember(String id) throws SQLException;
	
	
	/**
	 * 
	 * <pre>
	 * <b>기능</b>
	 *    -내가 작성한 게시글들을 확인합니다.
	 * </pre>
	 * 
	 *  @description 			내 게시글 보기
	 *  @param 	boardType		[게시판 타입]		<br/>
	 *  		BOARDTYPE_NO |	BOARDTYPE_NAME	<br/>
	 *				1		 :	한줄게시판			<br/>
	 *				2		 :	책리뷰게시판		<br/>
	 *				3		 :	창작게시판			<br/>
	 *
	 *  @throws SQLException
	 */
	public ArrayList<BoardVO> viewBoard(int boardType) throws SQLException;
}
