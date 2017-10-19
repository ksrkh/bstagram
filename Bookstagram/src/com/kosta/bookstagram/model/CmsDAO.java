package com.kosta.bookstagram.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kosta.bookstagram.model.common.CommonDAO;
import com.kosta.bookstagram.model.common.PagingBean;
import com.kosta.bookstagram.model.sql.CmsPageSQL;

public class CmsDAO extends CommonDAO {
	private static CmsDAO instance = new CmsDAO();

	private CmsDAO() {
	}

	public static CmsDAO getInstance() {
		return instance;
	}

	/**
	 * 성향 리스트를 가져오는 메서드입니다.
	 * 
	 * @throws SQLException
	 */
	public ArrayList<LineTendVO> getTendList() throws SQLException {
		ArrayList<LineTendVO> tend = new ArrayList<LineTendVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.ALL_TEND_LIST);
			rs = pstmt.executeQuery();
			while (rs.next())
				tend.add(new LineTendVO(rs.getInt(1), rs.getString(2)));

		} finally {
			closeAll(rs, pstmt, con);
		}

		return tend;
	}

	/**
	 * 장르 리스트를 가져오는 메서드입니다.
	 */
	public ArrayList<ReviewGenreVO> getGenreList() throws SQLException {
		ArrayList<ReviewGenreVO> genre = new ArrayList<ReviewGenreVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.ALL_GENRE_LIST);
			rs = pstmt.executeQuery();
			while (rs.next())
				genre.add(new ReviewGenreVO(rs.getInt(1), rs.getString(2)));

		} finally {
			closeAll(rs, pstmt, con);
		}

		return genre;
	}

	/**
	 * 분야 리스트를 가져오는 메서드입니다.
	 */
	public ArrayList<CreateCategoryVO> getCategoryList() throws SQLException {
		ArrayList<CreateCategoryVO> category = new ArrayList<CreateCategoryVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.ALL_CATEGORY_LIST);
			rs = pstmt.executeQuery();
			while (rs.next())
				category.add(new CreateCategoryVO(rs.getInt(1), rs.getString(2)));

		} finally {
			closeAll(rs, pstmt, con);
		}

		return category;
	}

	/**
	 * 비밀번호 찾기 질문 리스트를 가져오는 메서드입니다.
	 */
	public ArrayList<PasswordQuestionVO> getPwQuestionList() throws SQLException {
		ArrayList<PasswordQuestionVO> answer = new ArrayList<PasswordQuestionVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.ALL_QUESTION_LIST);
			rs = pstmt.executeQuery();
			while (rs.next())
				answer.add(new PasswordQuestionVO(rs.getInt(1), rs.getString(2)));

		} finally {
			closeAll(rs, pstmt, con);
		}

		return answer;
	}

	/**
	 * 회원등급 리스트를 가져오는 메서드입니다.
	 */
	public ArrayList<MemberTierVO> getTierList() throws SQLException {
		ArrayList<MemberTierVO> tier = new ArrayList<MemberTierVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.TIER_LIST);
			rs = pstmt.executeQuery();
			while (rs.next())
				tier.add(new MemberTierVO(rs.getInt(1), rs.getString(2)));

		} finally {
			closeAll(rs, pstmt, con);
		}

		return tier;
	}

	/**
	 * 관리자페이지 : 전체회원의 리스트를 가져오는 메서드입니다.
	 */
	public ArrayList<MemberVO> getAllMemberList(PagingBean pagingbean) throws SQLException {
		ArrayList<MemberVO> member = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.ALL_MEMBER_LIST);
			pstmt.setInt(1, pagingbean.getStartRowNumber());
			pstmt.setInt(2, pagingbean.getEndRowNumber());
			rs = pstmt.executeQuery();
			while (rs.next())
				member.add(new MemberVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));

		} finally {
			closeAll(rs, pstmt, con);
		}

		return member;
	}

	/**
	 * 관리자페이지 : 전체 게시판 리스트를 가져오는 메서드입니다.
	 */
	public ArrayList<BoardVO> getAllBoardList(PagingBean pagingbean) throws SQLException {
		ArrayList<BoardVO> board = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.ALL_BOARD_LIST);
			pstmt.setInt(1, pagingbean.getStartRowNumber());
			pstmt.setInt(2, pagingbean.getEndRowNumber());
			rs = pstmt.executeQuery();
			while (rs.next())
				board.add(new BoardVO(rs.getInt(1), rs.getInt(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));

		} finally {
			closeAll(rs, pstmt, con);
		}

		return board;
	}

	/**
	 * 성향 추가
	 */
	public void addTend(LineTendVO tend) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.ADD_TEND);
			pstmt.setString(1, tend.getTend_name());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	/**
	 * 장르 추가
	 */
	public void addGenre(ReviewGenreVO genre) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.ADD_GENRE);
			pstmt.setString(1, genre.getGenre_name());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	/**
	 * 분야 추가
	 */
	public void addCategory(CreateCategoryVO category) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.ADD_CATEGORY);
			pstmt.setString(1, category.getCategory_name());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	/**
	 * 비밀번호찾기질문 추가
	 */
	public void addFindPwQuestion(PasswordQuestionVO question) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.ADD_FIND_PW_QUESTION);
			pstmt.setString(1, question.getQuestion());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	/**
	 * 성향 수정
	 */
	public void updateTend(LineTendVO tend) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.TEND_NAME_UPDATE);
			pstmt.setString(1, tend.getTend_name());
			pstmt.setInt(2, tend.getTend_code());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	/**
	 * 성향 삭제
	 */
	public void deleteTend(int tendCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.BOARD_TEND_UPDATE);
			pstmt.setInt(1, tendCode);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = con.prepareStatement(CmsPageSQL.TEND_CODE1_UPDATE);
			pstmt.setInt(1, tendCode);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = con.prepareStatement(CmsPageSQL.TEND_CODE2_UPDATE);
			pstmt.setInt(1, tendCode);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = con.prepareStatement(CmsPageSQL.TEND_CODE3_UPDATE);
			pstmt.setInt(1, tendCode);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = con.prepareStatement(CmsPageSQL.TEND_DELETE);
			pstmt.setInt(1, tendCode);
			pstmt.executeUpdate();
			pstmt.close();
			
			con.commit();
		} finally {
			con.rollback();
			closeAll(pstmt, con);
		}
	}
	
	/**
	 * 장르 수정
	 */
	public void updateGenre(ReviewGenreVO genre) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.GENRE_NAME_UPDATE);
			pstmt.setString(1, genre.getGenre_name());
			pstmt.setInt(2, genre.getGenre());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	/**
	 * 장르 삭제
	 */
	public void deleteGenre(int genreCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.BOARD_GENRE_UPDATE);
			pstmt.setInt(1, genreCode);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = con.prepareStatement(CmsPageSQL.GENRE_DELETE);
			pstmt.setInt(1, genreCode);
			pstmt.executeUpdate();
			pstmt.close();
			
			con.commit();
		} finally {
			con.rollback();
			closeAll(pstmt, con);
		}
	}
	
	/**
	 * 분류 수정
	 */
	public void updateCategory(CreateCategoryVO category) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.CATEGORY_NAME_UPDATE);
			pstmt.setString(1, category.getCategory_name());
			pstmt.setInt(2, category.getCategory());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	/**
	 * 분류 삭제
	 */
	public void deleteCategory(int categoryCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.BOARD_CATEGORY_UPDATE);
			pstmt.setInt(1, categoryCode);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = con.prepareStatement(CmsPageSQL.CATEGORY_DELETE);
			pstmt.setInt(1, categoryCode);
			pstmt.executeUpdate();
			pstmt.close();
			
			con.commit();
		} finally {
			con.rollback();
			closeAll(pstmt, con);
		}
	}
	
	/**
	 * 비밀번호찾기 질문 수정
	 */
	public void updatePwFindQuestion(PasswordQuestionVO question) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.PASSWORD_QUESTION_UPDATE);
			pstmt.setString(1, question.getQuestion());
			pstmt.setInt(2, question.getQuestion_code());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	/**
	 * 관리자페이지 게시판 삭제
	 */
	public void cmsBoardDelete(int boardType_no, int boardNo) throws SQLException {
		if(boardType_no == 1)
			LineBoardDAO.getInstance().deleteBoard(boardNo);
		else if(boardType_no == 2)
			ReviewBoardDAO.getInstance().deleteBoard(boardNo);
		else if(boardType_no == 3)
			CreateBoardDAO.getInstance().deleteBoard(boardNo);
	}
	
	/**
	 * 관리자 페이지 회원정보 수정
	 * @throws SQLException 
	 */
	public void cmsMemberUpdate(MemberVO member) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE Member SET pw=?, age=?, tend_code=?, tend_code2=?, tend_code3=?, tier=? WHERE id=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, member.getPw());
			pstmt.setInt(2, member.getAge());
			pstmt.setInt(3, member.getTend_code());
			pstmt.setInt(4, member.getTend_code2());				
			pstmt.setInt(5, member.getTend_code3());
			pstmt.setInt(6, member.getTier());
			pstmt.setString(7, member.getId());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	
	/*
	 * 전체 게시물 수를 구하는 메서드입니다.
	 */
	public int totalCountByCmsBoard() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCount=0;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.CMS_ALL_BOARD_COUNT);
			rs=pstmt.executeQuery();
		if(rs.next())
			totalCount=rs.getInt(1);
		} finally {
			closeAll(rs, pstmt, con);
		}
		return totalCount;
	}
	
	/*
	 * 전체 회원 수를 구하는 메서드입니다.
	 */
	public int totalCountByCmsMember() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCount=0;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.CMS_ALL_MEMBER_COUNT);
			rs=pstmt.executeQuery();
			if(rs.next())
				totalCount=rs.getInt(1);
		} finally {
			closeAll(rs, pstmt, con);
		}
		return totalCount;
	}
	
	/*
	 * 회원의 등급을 가져오는 메서드입니다.
	 */
	public int getMemberTier(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int tier = 0;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.CMS_MEMBER_TIER);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
				tier=rs.getInt(1);
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return tier;
	}
}
