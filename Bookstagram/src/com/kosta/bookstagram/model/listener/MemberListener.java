package com.kosta.bookstagram.model.listener;

import java.sql.SQLException;

import com.kosta.bookstagram.model.MemberVO;

public interface MemberListener {
	/**
	 * <pre>
	 * <b>기능</b>
	 *    -아이디와 비밀번호를 입력받아 로그인기능을 수행합니다.
	 * </pre>
	 * 
	 * @param id			회원 아이디
	 * @param pw			회원 비밀번호
	 * @return MemberVO		회원객체를 리턴합니다.
	 * @throws SQLException
	 */
	public MemberVO logIn(String id, String pw) throws SQLException;
	
	/**
	 * <pre>
	 * <b>기능</b>
	 *    -새로운 회원의 정보를 입력받아 회원가입기능을 수행합니다.
	 * </pre>
	 * 
	 * @description 		회원가입 기능을 구현합니다.
	 * @param				새로운 멤버객체
	 * @throws SQLException
	 */
	public void addMember(MemberVO member) throws SQLException;
	
	/**
	 * <pre>
	 * <b>기능</b>
	 *    -아이디를 입력받아 회원의 정보를 수정합니다.
	 * </pre>
	 * 
	 * @description 		회원정보 수정
	 * @param id			회원의 아이디
	 * @return MemberVO		수정된 회원객체를 리턴합니다.
	 * @throws SQLException
	 */
	public MemberVO updateMember(String id) throws SQLException;
	
	/**
	 * <pre>
	 * <b>기능</b>
	 *    -아이디를 입력받아 회원정보의 권한을 0(탈퇴회원)으로 변경합니다.
	 * </pre>
	 * 
	 *  @description 		회원탈퇴
	 *  @param id			탈퇴할 회원의 아이디
	 *  @throws SQLException
	 */
	public void deleteMember(String id) throws SQLException;
}
