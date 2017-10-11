package com.kosta.bookstagram.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateBoardDAO extends BoardDAO {
	// Singleton pattern
	private static CreateBoardDAO instance = new CreateBoardDAO();

	private CreateBoardDAO() {
	}

	public static CreateBoardDAO getInstance() {
		return instance;
	}

	// 창작 글 목록 start
	@Override
	public ArrayList<BoardVO> boardList() throws SQLException {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT b.board_no,m.nick,b.board_regdate,b.hit, cb.create_title ");
			sql.append("FROM board b,create_board cb,member m ");
			sql.append("WHERE b.board_no=cb.board_no and b.id=m.id order by b.board_no desc ");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new CreateBoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5)));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	// 창작 글 목록 end
	// 창작 글 상세보기 start
	@Override
	public BoardVO selectBoard(int boardNo) throws SQLException {
		CreateBoardVO cbvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT b.board_no,b.boardtype_no,m.nick,b.board_regdate,b.hit,b.authority,b.bg_no, ");
			sql.append("cb.create_title,cb.create_content,cb.category  ");
			sql.append("FROM board b,create_board cb,member m ");
			sql.append("WHERE b.board_no=cb.board_no and  b.id=m.id and b.board_no=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cbvo = new CreateBoardVO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			}

		} finally {
			closeAll(rs, pstmt, con);
		}

		return cbvo;
	}
	// 창작 글 상세보기 end

	// 창작 글 작성 start
	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		CreateBoardVO cbvo = (CreateBoardVO) board;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();

			// board table insert
			StringBuilder sql = new StringBuilder();
			sql.append("insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no) ");
			sql.append("values(board_seq.nextval, 3, ?, sysdate, 0, 1, 0) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, cbvo.getId());
			pstmt.executeUpdate();
			pstmt.close();

			// create_board table insert
			StringBuilder sql2 = new StringBuilder();
			sql2.append("insert into create_board(board_no, create_title, create_content, category) ");
			sql2.append("values(board_seq.currval, ?, ?, ?) ");
			pstmt = con.prepareStatement(sql2.toString());
			pstmt.setString(1, cbvo.getCreate_title());
			pstmt.setString(2, cbvo.getCreate_content());
			pstmt.setInt(3, cbvo.getCategory());
			pstmt.executeUpdate();

		} finally {
			closeAll(pstmt, con);
		}
	}
	// 창작 글 작성 end

	// 창작 글 수정 start
	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		System.out.println("CreateBoardDAO, updateBoard() 실행");
	}
	// 창작 글 수정 end

	// 창작 글 삭제 start
	@Override
	public void deleteBoard(int boardNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();

			String sql = "DELETE FROM create_board WHERE board_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();
			pstmt.close();

			String sql2 = "DELETE FROM board WHERE board_no=?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();

		} finally {
			closeAll(pstmt, con);
		}
	}
	// 창작 글 삭제 end

	@Override
	public int totalCountByBoard() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
