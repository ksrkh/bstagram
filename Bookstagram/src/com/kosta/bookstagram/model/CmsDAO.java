package com.kosta.bookstagram.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kosta.bookstagram.model.common.CommonDAO;
import com.kosta.bookstagram.model.sql.CmsPageSQL;

public class CmsDAO extends CommonDAO{
	private static CmsDAO instance = new CmsDAO();
	private CmsDAO() {System.out.println("MemberDAO 객체 생성");}
	public static CmsDAO getInstance() {
		return instance;
	}
	
	/**
	 * 성향 리스트를 가져오는 메서드입니다.
	 * @throws SQLException 
	 */
	public ArrayList<LineTendVO> getTendList() throws SQLException{
		ArrayList<LineTendVO> tend = new ArrayList<LineTendVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.allTendList);
			rs = pstmt.executeQuery();
			while(rs.next())
				tend.add(new LineTendVO(rs.getInt(1), rs.getString(2)));
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return tend;
	}
	
	/**
	 * 장르 리스트를 가져오는 메서드입니다.
	 */
	public ArrayList<ReviewGenreVO> getGenreList() throws SQLException{
		ArrayList<ReviewGenreVO> genre = new ArrayList<ReviewGenreVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.allGenreList);
			rs = pstmt.executeQuery();
			while(rs.next())
				genre.add(new ReviewGenreVO(rs.getInt(1), rs.getString(2)));
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return genre;
	}
	
	/**
	 * 분야 리스트를 가져오는 메서드입니다.
	 */
	public ArrayList<CreateCategoryVO> getCategoryList() throws SQLException{
		ArrayList<CreateCategoryVO> category = new ArrayList<CreateCategoryVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.allCategoryList);
			rs = pstmt.executeQuery();
			while(rs.next())
				category.add(new CreateCategoryVO(rs.getInt(1), rs.getString(2)));
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return category;
	}
	
	
	
	/**
	 * 비밀번호 찾기 질문 리스트를 가져오는 메서드입니다.
	 */
	public ArrayList<PasswordQuestionVO> getPwQuestionList() throws SQLException{
		ArrayList<PasswordQuestionVO> answer = new ArrayList<PasswordQuestionVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.allQuestionList);
			rs = pstmt.executeQuery();
			while(rs.next())
				answer.add(new PasswordQuestionVO(rs.getInt(1), rs.getString(2)));
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return answer;
	}
	
	/**
	 * 회원등급 리스트를 가져오는 메서드입니다.
	 */
	public ArrayList<MemberTierVO> getTierList()  throws SQLException{
		ArrayList<MemberTierVO> tier = new ArrayList<MemberTierVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.tierList);
			rs = pstmt.executeQuery();
			while(rs.next())
				tier.add(new MemberTierVO(rs.getInt(1), rs.getString(2)));
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return tier;
	}
	
	
	/**
	 * 관리자페이지 : 전체회원의 리스트를 가져오는 메서드입니다.
	 */
	public ArrayList<MemberVO> getAllMemberList() throws SQLException{
		ArrayList<MemberVO> member = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.allMemberList);
			rs = pstmt.executeQuery();
			while(rs.next())
				member.add(new MemberVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return member;
	}
	
	/**
	 * 관리자페이지 : 전체 게시판 리스트를 가져오는 메서드입니다.
	 */
	public ArrayList<BoardVO> getAllBoardList() throws SQLException{
		ArrayList<BoardVO> board = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.allBoardList);
			rs = pstmt.executeQuery();
			while(rs.next())
				board.add(new BoardVO(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5),rs.getInt(6)));
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return board;
	}
}
