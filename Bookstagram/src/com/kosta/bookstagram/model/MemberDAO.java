package com.kosta.bookstagram.model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kosta.bookstagram.model.common.CommonDAO;
import com.kosta.bookstagram.model.listener.MemberListener;

public class MemberDAO extends CommonDAO implements MemberListener{
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO(){System.out.println("MemberDAO 객체 생성");}
	public static MemberDAO getInstance(){return instance;}

	@Override
	public MemberVO checkMember(String id, String pw) throws SQLException {
		System.out.println("logIn() 실행");
		return null;
	}

	@Override
	public void addMember(MemberVO member) throws SQLException {
		System.out.println("addMember() 실행");
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		System.out.println("updateMember() 실행");
	}
	
	@Override
	public void withDrawMember(String id) throws SQLException {
		System.out.println("withDrawMember() 실행");
	}
	
	@Override
	public ArrayList<BoardVO> viewBoard(int boardType) throws SQLException {
		System.out.println("viewBoard() 실행");
		return null;
	}
}
