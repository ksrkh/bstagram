package com.kosta.bookstagram.model.listener;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kosta.bookstagram.model.BoardVO;
import com.kosta.bookstagram.model.MemberVO;
import com.kosta.bookstagram.model.common.PagingBean;

public interface MemberListener {
	/**
	 * <pre>
	 * <b>기능</b>
	 *    -아이디와 비밀번호를 입력받아 로그인기능을 수행합니다.
	 *    
	 * <b>조건</b>
	 * 	  -아이디와 비밀번호가 일치하는 회원의 정보를 가져옵니다.
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
	 *    
	 * <b>조건</b>
	 * 	  -성향 선택안했을시 없음으로 처리하여야합니다.
	 * 	  -성향 1개 선택시 tend_code에만 입력후 나머지 2개는 없음으로 처리하여야합니다.
	 * 	  -성향 2개 선택시 tend_code에만 입력후 나머지 1개는 없음으로 처리하여야합니다.
	 * 	  -성향 3개 선택시 tend_code에만 입력후 나머지 0개는 없음으로 처리하여야합니다.
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
	public ArrayList<BoardVO> viewBoard(int boardType, PagingBean pagingBean) throws SQLException;


	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시글의 개수를 받아오는 기능입니다
	 * </pre>
	 * 
	 * @param    boardType     게시글 타입번호
	 * @param    id            사용자 id
	 * @throws   SQLException
	 */
	public int totalCountByBoardNId(int boardType, String id) throws SQLException;
}
