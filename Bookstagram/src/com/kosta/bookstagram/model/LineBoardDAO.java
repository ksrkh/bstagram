package com.kosta.bookstagram.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LineBoardDAO extends BoardDAO{
	//Singleton pattern 
	private static LineBoardDAO instance = new LineBoardDAO();	
	private LineBoardDAO(){System.out.println("LineBoardDAO() 객체생성 싱글톤 적용");}
	public static LineBoardDAO getInstance(){return instance;}
	
	/*
	 * 한줄 글등록
	 * LineVO에 ArrayList<LineTendVO> 생성 controller에서 처리 후에 등록
	 */
	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		System.out.println("LineBoardDAO, insertBoard() 실행");
		BookVO bookVO=new BookVO();
		LineBoardVO lineVO=new LineBoardVO();
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no) ");
			sql.append("values(board_seq.nextval, 1, ?, sysdate, 0, 1, ?)");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, board.getId());
			pstmt.setInt(2, board.getBg_no());
			pstmt.executeUpdate();
			pstmt.close();
			StringBuilder sql1 = new StringBuilder();
			sql1.append("insert into book(book_no, book_title, book_intro, book_author, book_publ, ");
			sql1.append("book_sdate, book_edate, book_cate,  book_img) ");
			sql1.append("values(book_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?");
			pstmt=con.prepareStatement(sql1.toString());
			pstmt.setString(1, bookVO.getBook_title());
			pstmt.setString(2, bookVO.getBook_intro());
			pstmt.setString(3, bookVO.getBook_author());
			pstmt.setString(4, bookVO.getBook_publ());
			pstmt.setString(5, bookVO.getBook_sdate());
			pstmt.setString(6, bookVO.getBook_edate());
			pstmt.setString(7, bookVO.getBook_cate());
			pstmt.setString(8, bookVO.getBook_img());
			pstmt.executeUpdate();
			pstmt.close();
			StringBuilder sql2 = new StringBuilder();
			sql2.append("insert into line_board(board_no, line_content, tend_code, book_no)");
			sql2.append("values(board_seq.currval, ?, ?, ?)");
			pstmt=con.prepareStatement(sql2.toString());
			pstmt.setString(1, lineVO.getLine_content());
			pstmt.setInt(3, lineVO.getTend_code());
			pstmt.setInt(3, lineVO.getBook_no());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}

	/*
	 * 한줄 수정하기
	 */
	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		System.out.println("LineBoardDAO, updateBoard() 실행");
	}
	
	/*
	 * 글 번호(검색)
	 * 한줄 삭제하기
	 */
	@Override
	public void deleteBoard(int boardNo) throws SQLException {
		System.out.println("LineBoardDAO, deleteBoard() 실행");
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="delete from board where board_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	/*
	 * 글 번호(검색)
	 * 한줄 상세보기 
	 * 
	 * SELECT br.board_no,br.boardtype_no,m.nick,br.board_regdate,br.hit,br.authority,
	 * br.bg_no,lb.line_content, lb.tend_code,lb.book_no
     * FROM line_board lb,board br,member m
     * WHERE lb.board_no=br.board_no and m.id=br.id  and br.board_no='2';
     * int board_no, int boardtype_no, String nick, String board_regdate, int hit, int sympathy,
	 * int authority, int bg_no, String line_content, int tend_code, int book_no
     * **sympathy 수**
     * select count(*) from sympathy where board_no='1'
	 */
	@Override
	public BoardVO selectBoard(int boardNo) throws SQLException {
		BoardVO dvo=new LineBoardVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			/*//sympathy 먼저 처리 후 Board로 set 아래에서 get
			String sql1="select count(*) from sympathy where board_no=?";
			pstmt=con.prepareStatement(sql1);
			pstmt.setInt(1, boardNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dvo.setSympathy(rs.getInt(1));
			}
			pstmt.close();
			rs.close();*/
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT br.board_no,br.boardtype_no,m.nick,br.board_regdate,br.hit,br.authority, ");
			sql.append("br.bg_no,lb.line_content, lb.tend_code,lb.book_no ");
			sql.append("FROM line_board lb,board br,member m ");
			sql.append("WHERE lb.board_no=br.board_no and m.id=br.id  and br.board_no=?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo);
			rs=pstmt.executeQuery();
			/*int board_no, int boardtype_no, String nick, String board_regdate, int hit,
			int authority, int bg_no, String line_content, int tend_code, int book_no*/
			if(rs.next()) {
				dvo=new LineBoardVO(rs.getInt(1),rs.getInt(2),rs.getString(3),
						rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),
						rs.getString(8),rs.getInt(9),rs.getInt(10));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return dvo;
	}
	/*
	 * 책 게시판 번호로 검색
	 * SELECT bk.book_no,bk.book_title,bk.book_intro,bk.book_author,
	 * bk.book_publ,bk.book_sdate,bk.book_edate,bk.book_cate,bk.book_img
	 * FROM line_board lb,board br,book bk
	 * WHERE lb.board_no=br.board_no and bk.book_no=lb.book_no and br.board_no=?;
	 * 
	 */
	public BookVO selectBook(int boardNo) throws SQLException {
		BookVO bvo=new BookVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT bk.book_no,bk.book_title,bk.book_intro,bk.book_author, ");
			sql.append("bk.book_publ,bk.book_sdate,bk.book_edate,bk.book_cate,bk.book_img ");
			sql.append("FROM line_board lb,board br,book bk ");
			sql.append("WHERE lb.board_no=br.board_no and bk.book_no=lb.book_no and br.board_no=?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bvo=new BookVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getString(9));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return bvo;
	}
	
	/*
	 * 첫 메인 페이지 view down casting Servlet
	 * 
	 * 
	 *SELECT lb.line_content,m.nick,
	 *FROM line_board lb,board br,member m
	 *WHERE lb.board_no=br.board_no and m.id=br.id 
	 */
	@Override
	public ArrayList<BoardVO> boardList() throws SQLException {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT br.board_no,m.nick,br.board_regdate,br.hit,lb.line_content,lb.tend_code,lb.book_no ");
			sql.append("FROM line_board lb,board br,member m ");
			sql.append("WHERE lb.board_no=br.board_no and m.id=br.id order by br.board_no desc");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			/*int board_no, String nick, String board_regdate, int hit, String line_content,
			int tend_code, int book_no*/
			while (rs.next()) {
				list.add(new LineBoardVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),
						rs.getInt(6),rs.getInt(7)));
			}
			
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	/*
	 * 총게시물 수 찾는 메서드 
	 */
	@Override
	public int totalCountByBoard() throws SQLException {
		int totalCount=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select count(board_no) from line_board";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				totalCount=rs.getInt(1);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return totalCount;
	}
	/*
	 * 성향 찾는 메서드
	 * int tend_code, String tend_name
	 */
	public ArrayList<LineTendVO> tendList() throws SQLException{
		ArrayList<LineTendVO> ltList=new ArrayList<LineTendVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select tend_code,tend_name from tend";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ltList.add(new LineTendVO(rs.getInt(1),rs.getString(2)));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return ltList;
	}
}
