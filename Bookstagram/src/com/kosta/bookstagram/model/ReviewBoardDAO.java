package com.kosta.bookstagram.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.kosta.bookstagram.model.common.DataSourceManager;

public class ReviewBoardDAO extends BoardDAO{
	//Singleton pattern 
	private static ReviewBoardDAO instance = new ReviewBoardDAO();
	private DataSource dataSource;
	private ReviewBoardDAO(){
		dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static ReviewBoardDAO getInstance(){
		return instance;
	}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("");
			sql.append("");
			pstmt = con.prepareStatement(sql.toString());
			//set 값
			pstmt.executeUpdate();
			pstmt.close();
			StringBuffer sql2 = new StringBuffer();
			sql2.append("");
			sql2.append("");
			pstmt = con.prepareStatement(sql2.toString());
			//set 값
			pstmt.executeUpdate();
			pstmt.close();
			StringBuffer sql3 = new StringBuffer();
			sql3.append("");
			sql3.append("");
			pstmt = con.prepareStatement(sql3.toString());
			//set 값
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("");
			sql.append("");
			pstmt = con.prepareStatement(sql.toString());
			//set 값
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}

	@Override
	public void deleteBoard(int boardNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("");
			sql.append("");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo); //set값 게시물번호
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}

	@Override
	public BoardVO selectBoard(int boardNo) throws SQLException {
		BoardVO bvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT b.board_no, m.nick, b.board_regdate, b.hit, rb.review_title, rb.review_content, rb.star_point, rb.genre, bo.book_no, bo.book_title, bo.book_intro, bo.book_author, bo.book_publ, bo.book_sdate, bo.book_edate, bo.book_cate, bo.book_img ");
			sql.append("FROM board b,review_board rb,member m,book bo ");
			sql.append("WHERE b.board_no = rb.board_no and b.id=m.id and rb.book_no=bo.book_no and b.board_no=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo); //set값 게시물번호
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bvo = new ReviewBoardVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),new BookVO(rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15)));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return bvo;
	}
	
	@Override
	public ArrayList<BoardVO> boardList() throws SQLException {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT b.board_no, m.nick, b.board_regdate, b.hit, rb.review_title, rb.review_content, rb.star_point, rb.genre,bo.book_no, bo.book_title, bo.book_intro, bo.book_author, bo.book_publ, bo.book_sdate, bo.book_img ");
			sql.append("FROM board b,review_board rb,member m,book bo ");
			sql.append("WHERE b.board_no = rb.board_no and b.id=m.id and rb.book_no=bo.book_no order by b.board_no desc");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new ReviewBoardVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),new BookVO(rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15))));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	@Override
	public int totalCountByBoard() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
