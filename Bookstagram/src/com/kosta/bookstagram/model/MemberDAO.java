package com.kosta.bookstagram.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kosta.bookstagram.model.common.CommonDAO;
import com.kosta.bookstagram.model.listener.MemberListener;
import com.kosta.bookstagram.model.sql.MemberSQL;

public class MemberDAO extends CommonDAO implements MemberListener{
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO(){System.out.println("MemberDAO 객체 생성");}
	public static MemberDAO getInstance(){return instance;}

	@Override
	public MemberVO checkMember(String id, String pw) throws SQLException {
		MemberVO member = null;
		
		PreparedStatement pstmt = getConnection().prepareStatement(MemberSQL.checkMember);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
			member = new MemberVO(rs.getString(1),rs.getString(2), rs.getString(3),
					rs.getInt(4),rs.getString(5),rs.getString(6),
					rs.getInt(8),rs.getInt(9),rs.getInt(10),
					rs.getInt(11),rs.getInt(12),rs.getString(13));
		
		return member;
	}

	@Override
	public void addMember(MemberVO member) throws SQLException {
		
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
