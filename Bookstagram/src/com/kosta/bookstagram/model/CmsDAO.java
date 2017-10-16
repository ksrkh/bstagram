package com.kosta.bookstagram.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kosta.bookstagram.model.common.CommonDAO;
import com.kosta.bookstagram.model.sql.CmsPageSQL;

public class CmsDAO extends CommonDAO {
	private static CmsDAO instance = new CmsDAO();

	private CmsDAO() {
		System.out.println("MemberDAO 객체 생성");
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
			pstmt = con.prepareStatement(CmsPageSQL.allTendList);
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
			pstmt = con.prepareStatement(CmsPageSQL.allGenreList);
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
			pstmt = con.prepareStatement(CmsPageSQL.allCategoryList);
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
			pstmt = con.prepareStatement(CmsPageSQL.allQuestionList);
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
			pstmt = con.prepareStatement(CmsPageSQL.tierList);
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
	public ArrayList<MemberVO> getAllMemberList() throws SQLException {
		ArrayList<MemberVO> member = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.allMemberList);
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
	public ArrayList<BoardVO> getAllBoardList() throws SQLException {
		ArrayList<BoardVO> board = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(CmsPageSQL.allBoardList);
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
			pstmt = con.prepareStatement(CmsPageSQL.addTend);
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
			pstmt = con.prepareStatement(CmsPageSQL.addGenre);
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
			pstmt = con.prepareStatement(CmsPageSQL.addCategory);
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
			pstmt = con.prepareStatement(CmsPageSQL.addFindPwQuestion);
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
			pstmt = con.prepareStatement(CmsPageSQL.tendNameUpdate);
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
			pstmt = con.prepareStatement(CmsPageSQL.boardTendUpdate);
			pstmt.setInt(1, tendCode);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = con.prepareStatement(CmsPageSQL.tendCode1Update);
			pstmt.setInt(1, tendCode);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = con.prepareStatement(CmsPageSQL.tendCode2Update);
			pstmt.setInt(1, tendCode);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = con.prepareStatement(CmsPageSQL.tendCode3Update);
			pstmt.setInt(1, tendCode);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = con.prepareStatement(CmsPageSQL.tendDelete);
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
			pstmt = con.prepareStatement(CmsPageSQL.genreNameUpdate);
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
			pstmt = con.prepareStatement(CmsPageSQL.boardGenreUpdate);
			pstmt.setInt(1, genreCode);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = con.prepareStatement(CmsPageSQL.genreDelete);
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
			pstmt = con.prepareStatement(CmsPageSQL.categoryNameUpdate);
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
			pstmt = con.prepareStatement(CmsPageSQL.boardCategoryUpdate);
			pstmt.setInt(1, categoryCode);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = con.prepareStatement(CmsPageSQL.categoryDelete);
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
			pstmt = con.prepareStatement(CmsPageSQL.passwordQuestionUpdate);
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
	 */
	public void cmsMemberUpdate(MemberVO member) {
		//MemberDAO.getInstance().updateMember(member);
	}
}
