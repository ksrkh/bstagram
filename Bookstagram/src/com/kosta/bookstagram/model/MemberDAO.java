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
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	@Override
	public MemberVO checkMember(String id, String pw) throws SQLException {
		MemberVO member = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(MemberSQL.checkMember);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
	
			while (rs.next())
				member = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12),
						rs.getString(13));
		}finally {
			closeAll(rs, pstmt, con);
		}

		return member;
	}

	@Override
	public void addMember(MemberVO member) throws SQLException {
		Connection con = null;
	      PreparedStatement pstmt = null;
	      try {
	         con = getConnection();
	         pstmt = con.prepareStatement(MemberSQL.addMember);
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
	      }finally {
	         closeAll(pstmt, con);
	      }
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE Member SET pw=?, nick=?, age=?, tend_code=?, tend_code2=?, tend_code3=?, question_code=?, pw_ans=? WHERE id=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getNick());
			pstmt.setInt(3, member.getAge());
			pstmt.setInt(4, member.getTend_code());
			pstmt.setInt(5, member.getTend_code2());
			pstmt.setInt(6, member.getTend_code3());
			pstmt.setInt(7, member.getQuestion_code());
			pstmt.setString(8, member.getPw_ans());
			pstmt.setString(9, member.getId());
			pstmt.executeUpdate();

		} finally {
			closeAll(pstmt, con);
		}
		
	}

	/*public MemberVO MemberInfo(String id) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		MemberVO mvo=new MemberVO();
		try {
			con = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT id,nick,age,regdate FROM MEMBER where id=? ");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				mvo.set
			}
		} finally {
			closeAll(pstmt, con);
		}
		return mvo;
	}*/
	@Override
	public void withDrawMember(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("Update MEMBER set tier=0 where id=? ");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setString(1, id);
			pstmt.executeUpdate();

		} finally {
			closeAll(pstmt, con);
		}
	}

	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -한줄 게시판의 내 게시물 가져오기
	 * </pre>
	 * 
	 * @return 	ArrayList<LineBoardVO>		한줄 게시판 게시물
	 * @param 	id 							회원 id
	 * @param 	pagingBean 					PagingBean
	 * @throws SQLException
	 * 
	 */
	@Override
	public ArrayList<LineBoardVO> l_viewBoard(String id,PagingBean pagingBean) throws SQLException {
		ArrayList<LineBoardVO> list=new ArrayList<LineBoardVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT b.board_no,b.id,l.line_content,b.board_regdate,b.hit,l.tend_code FROM( ");
			sql.append("SELECT row_number() over(order by board_no desc) as rnum,board_no,id, ");
			sql.append("to_char(board_regdate,'YYYY.MM.DD') as board_regdate,hit ");
			sql.append("FROM BOARD WHERE id=? and boardtype_no=1 ");
			sql.append(") b,LINE_BOARD l where b.board_no=l.board_no and rnum between ? and ? ");
			sql.append("order by board_no desc ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setInt(2, pagingBean.getStartRowNumber());
			pstmt.setInt(3, pagingBean.getEndRowNumber());
			rs=pstmt.executeQuery();	
			//목록에서 게시물 content는 필요없으므로 null로 setting
			//select no,title,time_posted,hits,id,name
			while(rs.next()){		
				LineBoardVO bvo=new LineBoardVO();
				bvo.setBoard_no(rs.getInt(1));
				bvo.setId(rs.getString(2));
				bvo.setLine_content(rs.getString(3));
				bvo.setBoard_regdate(rs.getString(4));
				bvo.setHit(rs.getInt(5));
				bvo.setTend_code(rs.getInt(6));
				list.add(bvo);			
			}			
		}finally{
			closeAll(rs,pstmt,con);
		}
		return list;
	}
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -독후감 게시판의 내 게시물 가져오기
	 * </pre>
	 * 
	 * @return 	ArrayList<ReviewBoardVO>	독후감 게시판 게시물
	 * @param 	id 							회원 id
	 * @param 	pagingBean 					PagingBean
	 * @throws SQLException
	 * 
	 */
	@Override
	public ArrayList<ReviewBoardVO> r_viewBoard(String id,PagingBean pagingBean) throws SQLException {
		ArrayList<ReviewBoardVO> list=new ArrayList<ReviewBoardVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT b.board_no,b.id,r.review_title,b.board_regdate,b.hit FROM( ");
			sql.append("SELECT row_number() over(order by board_no desc) as rnum,board_no,id, ");
			sql.append("to_char(board_regdate,'YYYY.MM.DD') as board_regdate,hit ");
			sql.append("FROM BOARD WHERE id=? and boardtype_no=2 ");
			sql.append(") b,REVIEW_BOARD r where b.board_no=r.board_no and rnum between ? and ? ");
			sql.append("order by board_no desc ");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setString(1, id);
			pstmt.setInt(2, pagingBean.getStartRowNumber());
			pstmt.setInt(3, pagingBean.getEndRowNumber());
			rs=pstmt.executeQuery();	
			//목록에서 게시물 content는 필요없으므로 null로 setting
			//select no,title,time_posted,hits,id,name
			while(rs.next()){		
				ReviewBoardVO bvo=new ReviewBoardVO();
				bvo.setBoard_no(rs.getInt(1));
				bvo.setId(rs.getString(2));
				bvo.setReview_title(rs.getString(3));
				bvo.setBoard_regdate(rs.getString(4));
				bvo.setHit(rs.getInt(5));
				list.add(bvo);			
			}			
		}finally{
			closeAll(rs,pstmt,con);
		}
		return list;
	}

	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -창작 게시판의 내 게시물 가져오기
	 * </pre>
	 * 
	 * @return 	ArrayList<CreateBoardVO>	창작 게시판 게시물
	 * @param 	id 							회원 id
	 * @param 	pagingBean 					PagingBean
	 * @throws SQLException
	 * 
	 */
	@Override
	public ArrayList<CreateBoardVO> c_viewBoard(String id,PagingBean pagingBean) throws SQLException {
		ArrayList<CreateBoardVO> list=new ArrayList<CreateBoardVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT b.board_no,b.id,c.create_title,b.board_regdate,b.hit FROM( ");
			sql.append("SELECT row_number() over(order by board_no desc) as rnum,board_no,id, ");
			sql.append("to_char(board_regdate,'YYYY.MM.DD') as board_regdate,hit ");
			sql.append("FROM BOARD WHERE id=? and boardtype_no=3 ");
			sql.append(") b,CREATE_BOARD c where b.board_no=c.board_no and rnum between ? and ? ");
			sql.append("order by board_no desc ");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setString(1, id);
			pstmt.setInt(2, pagingBean.getStartRowNumber());
			pstmt.setInt(3, pagingBean.getEndRowNumber());
			
			rs=pstmt.executeQuery();	
			//목록에서 게시물 content는 필요없으므로 null로 setting
			//select no,title,time_posted,hits,id,name
			while(rs.next()){		
				CreateBoardVO bvo=new CreateBoardVO();
				bvo.setBoard_no(rs.getInt(1));
				bvo.setId(rs.getString(2));
				bvo.setCreate_title(rs.getString(3));
				bvo.setBoard_regdate(rs.getString(4));
				bvo.setHit(rs.getInt(5));
				list.add(bvo);			
			}			
		}finally{
			closeAll(rs,pstmt,con);
		}
		return list;
	}

	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    특정 회원의 특정 게시판 게시물의 개수를 받아오는 메서드
	 * </pre>
	 * 
	 * @return 	int							게시물 수 
	 * @param 	boardType 					게시판 번호 
	 * @param 	id 							회원 id
	 * @throws SQLException
	 * 
	 */
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
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(MemberSQL.dupleById);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
				member = new MemberVO();
			} finally {
			closeAll(rs,pstmt,con);
		}
		
		return member;
	}
	
	public MemberVO idCheckForPWFind(String id) throws SQLException {
		MemberVO member = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			con = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select question_code,pw_ans,pw ");
			sql.append("from member where id=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
				member = new MemberVO(id,rs.getInt(1),rs.getString(2),rs.getString(3));
		
		} finally {
			closeAll(rs,pstmt,con);
		}
		
		return member;
	}
	
	public MemberVO dupleByNick(String nick) throws SQLException {
		MemberVO member = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(MemberSQL.dupleByNick);
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();
			if(rs.next())
				member = new MemberVO();
		} finally {
			closeAll(rs,pstmt,con);
		}
		
		return member;
	}
	
	/**
	 * 회원가입 시 비밀번호 찾기 질문
	 */
	public ArrayList<PasswordQuestionVO> pwQuestionList() throws SQLException {
		ArrayList<PasswordQuestionVO> pwQv = new ArrayList<PasswordQuestionVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(MemberSQL.pwQuestionList);
			rs = pstmt.executeQuery();
			while(rs.next())
				pwQv.add(new PasswordQuestionVO(rs.getInt(1), rs.getString(2)));
			
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return pwQv;
	}
	
	/**
	 * 회원가입 시 성향선택 리스트
	 */
	public ArrayList<LineTendVO> tendList() throws SQLException {
		ArrayList<LineTendVO> tendList = new ArrayList<LineTendVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(MemberSQL.tendList);
			rs = pstmt.executeQuery();
			while(rs.next())
				tendList.add(new LineTendVO(rs.getInt(1), rs.getString(2)));
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return tendList;
	}
}

