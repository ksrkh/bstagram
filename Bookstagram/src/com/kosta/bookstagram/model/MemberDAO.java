package com.kosta.bookstagram.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		MemberVO member = null;
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from member where id=? and pw=?");
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			member = new MemberVO();
		}
		return member;
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
