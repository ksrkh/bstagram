package com.kosta.bookstagram.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kosta.bookstagram.model.common.CommonDAO;
import com.kosta.bookstagram.model.common.PagingBean;
import com.kosta.bookstagram.model.listener.MemberListener;
import com.kosta.bookstagram.model.sql.MemberSQL;

public class MemberDAO extends CommonDAO implements MemberListener {
	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {
		System.out.println("MemberDAO 객체 생성");
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	@Override
	public MemberVO checkMember(String id, String pw) throws SQLException {
		MemberVO member = null;

		PreparedStatement pstmt = getConnection().prepareStatement(MemberSQL.checkMember);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next())
			member = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
					rs.getString(6), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12),
					rs.getString(13));

		return member;
	}

	@Override
	public void addMember(MemberVO member) throws SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(MemberSQL.addMember);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPw());
		pstmt.setString(3, member.getNick());
		pstmt.setInt(4, member.getAge());
		pstmt.setInt(5, member.getTend_code());
		pstmt.setInt(6, member.getTend_code2());
		pstmt.setInt(7, member.getTend_code3());
		pstmt.setInt(8, member.getQuestion_code());
		pstmt.setString(9, member.getPw_ans());
		pstmt.executeUpdate();
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
	public ArrayList<BoardVO> viewBoard(int boardType, PagingBean pagingBean) throws SQLException {
		System.out.println("viewBoard() 실행");
		return null;
	}

	@Override
	public int totalCountByBoardNId(int boardType, String id) throws SQLException {
		int totalCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(*) ");
			sql.append("from BOARD ");
			sql.append("where boardtype_no=? and id=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardType);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return totalCount;
	}
	
	/**
	 * 아이디 중복 체크
	 */
	public MemberVO dupleById(String id) throws SQLException {
		MemberVO member = null;
		PreparedStatement pstmt = getConnection().prepareStatement(MemberSQL.dupleById);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
			member = new MemberVO();
		
		return member;
	}
	
	/**
	 * 회원가입 시 비밀번호 찾기 질문
	 */
	public ArrayList<PasswordQuestionVO> pwQuestionList() throws SQLException {
		ArrayList<PasswordQuestionVO> pwQv = new ArrayList<PasswordQuestionVO>();
		ResultSet rs = getConnection().prepareStatement(MemberSQL.pwQuestionList).executeQuery();
		while(rs.next())
			pwQv.add(new PasswordQuestionVO(rs.getInt(1), rs.getString(2)));
			
		return pwQv;
	}
	
	/**
	 * 회원가입 시 성향선택 리스트
	 */
	public ArrayList<LineTendVO> tendList() throws SQLException {
		ArrayList<LineTendVO> tendList = new ArrayList<LineTendVO>();
		ResultSet rs = getConnection().prepareStatement(MemberSQL.tendList).executeQuery();
		while(rs.next())
			tendList.add(new LineTendVO(rs.getInt(1), rs.getString(2)));
		
		return tendList;
	}
}
