package com.kosta.bookstagram.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kosta.bookstagram.model.common.BookSearchInfo;
import com.kosta.bookstagram.model.common.CommonDAO;
import com.kosta.bookstagram.model.common.PagingBean;
import com.kosta.bookstagram.model.common.ReReplyVO;
import com.kosta.bookstagram.model.common.ReplyVO;
import com.kosta.bookstagram.model.common.SympathyVO;
import com.kosta.bookstagram.model.listener.BoardListener;

/**
 * 추상클래스와 인터페이스의 설계목적
 * 1. CRUD의 메서드는 게시판에 무조건적으로 존재해야하는 기능이므로 abstract method로 정의
 * 2. 목적은 같으나 각각 성격이다른 게시판이므로 다른 DAO클래스에서 CRUD를 다르게 정의
 * 3. 리플,공감,조회수는 인터페이스로 정의하여 선택사항으로 분리, 하나의 공통된 기능으로써 사용한다.
 * 
 */
public abstract class BoardDAO extends CommonDAO implements BoardListener{
	
	public BoardDAO(){System.out.println("BoardDAO 객체생성");}

	@Override
	public void registerReply(String id, int boardNo, String content) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
			sql.append("insert into reply(reply_no, reply_content, board_no, id) ");
			sql.append("values(replyno_seq.nextval, ?, ?, ?) ");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setString(1, content);
			pstmt.setInt(2, boardNo);
			pstmt.setString(3, id);
			pstmt.executeUpdate();	
	
		}finally {
			closeAll(pstmt, con);
		}
	}

	@Override
	public void registerReReply(String id, int replyNo, String content) throws SQLException {
		System.out.println("registerReReply() 실행");
	}

	@Override
	public void removeReply(int replyNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=getConnection(); 
			//리덧글 먼저 삭제
			StringBuilder sql1=new StringBuilder();
			sql1.append("delete from RE_REPLY where reply_no=?");
			pstmt=con.prepareStatement(sql1.toString());	
			pstmt.setInt(1, replyNo);
			pstmt.executeUpdate();	
			pstmt.close();
			
			StringBuilder sql2=new StringBuilder();
			sql2.append("delete from REPLY where reply_no=?");
			pstmt=con.prepareStatement(sql2.toString());	
			pstmt.setInt(1, replyNo);
			pstmt.executeUpdate();	
			con.commit();
		}finally {
			con.rollback();
			closeAll(pstmt, con);
		}
	}

	@Override
	public void removeReReply(int rereplyNo) throws SQLException {
		System.out.println("removeReReply() 실행");
	}

	@Override
	public ArrayList<ReplyVO> viewReply(int boardNo) throws SQLException {
		ArrayList<ReplyVO> list= new ArrayList<ReplyVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
			sql.append("select reply_no,reply_content,board_no,id from REPLY where board_no=? order by reply_no desc");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setInt(1, boardNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ReplyVO vo= new ReplyVO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
				list.add(vo);
			}
	
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	@Override
	public ArrayList<ReReplyVO> viewReReply(ArrayList<ReplyVO> replyList) throws SQLException {
		System.out.println("viewReReply() 실행");
		return null;
	}

	
	@Override
	public int likeService(String id, int boardNo) throws SQLException {
		//liked가  1일 경우 기존에 해당 id, 해당 boardNo에 대한 공감 존재
		int likeCount=0;
		int liked=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			con=getConnection(); 
			StringBuilder sql1=new StringBuilder();
			sql1.append("select * from SYMPATHY where id=? and board_no=?");
			pstmt=con.prepareStatement(sql1.toString());	
			pstmt.setString(1, id);
			pstmt.setInt(2, boardNo);
			rs=pstmt.executeQuery();	
			if(rs.next()) {
				liked=1;
			}
			pstmt.close();
			if(liked==0) {
				StringBuilder sql2=new StringBuilder();
				sql1.append("insert into sympathy(id, board_no) values(?,?)");
				pstmt=con.prepareStatement(sql2.toString());	
				pstmt.setString(1, id);
				pstmt.setInt(2, boardNo);
				pstmt.executeUpdate();	
			}
			else {
				StringBuilder sql2=new StringBuilder();
				sql1.append("delete from SYMPATHY where id=? and board_no=?");
				pstmt=con.prepareStatement(sql2.toString());	
				pstmt.setString(1, id);
				pstmt.setInt(2, boardNo);
				pstmt.executeUpdate();	
			}
			pstmt.close();
			likeCount=likeCount(boardNo);
			con.commit();
			}finally {
				con.rollback();
				closeAll(pstmt, con);
		}
		return likeCount;
	}
	
	/*
	 * 전체 게시물에 
	 */
	@Override
	public ArrayList<SympathyVO> allLikeCount(int startNum,int endNum) throws SQLException {
		ArrayList<SympathyVO> list= new ArrayList<SympathyVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
			sql.append("select count,B.board_no ");
			sql.append("from(select row_number() over(order by board_no desc) as rnum,board_no,count(*) as count ");
			sql.append("from SYMPATHY group by board_no) B ");
			sql.append("where B.rnum between ? and ? ");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				SympathyVO vo= new SympathyVO(rs.getInt(1),rs.getInt(2));
				list.add(vo);
			}
	
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	/*
	 * ajax 이용하여 하나의 게시물에 대한 변화를 갱신해야하는 경우 
	 */
	@Override
	public int likeCount(int boardNo) throws SQLException {
		int likeCount=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
			sql.append("select count(*) from SYMPATHY where board_no=?");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setInt(1, boardNo);
			rs=pstmt.executeQuery();	
			if(rs.next())
				likeCount=rs.getInt(1);
			pstmt.close();
	
		}finally {
			closeAll(pstmt, con);
		}
		return likeCount;
		
	}

	@Override
	public void hits(int boardNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=getConnection(); 
			StringBuilder sql=new StringBuilder();
			sql.append("Update board set hit=hit+1 where board_no=?");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();	
			pstmt.close();
	
		}finally {
			closeAll(pstmt, con);
		}
	}
	
	/**
	 * 게시판에서 책을 검색하는 기능입니다.
	 * @throws IOException 
	 */
	public String searchBook(String book_name) throws IOException, NullPointerException {
		String text 				= URLEncoder.encode(book_name, "UTF-8");
		String apiURL 				= "https://openapi.naver.com/v1/search/book.json?query="+text+"&sort=sim"; // json 결과
		String inputLine			= null;
		BufferedReader br 			= null;
		HttpURLConnection con 		= null;
		URL url 					= new URL(apiURL);
		StringBuffer responseBook	= new StringBuffer();
		
		try {
			
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", BookSearchInfo.BOOK_SEARCH_CLIENT_ID);
			con.setRequestProperty("X-Naver-Client-Secret", BookSearchInfo.BOOK_SEARCH_CLIENT_SECRET);
			int responseCode = con.getResponseCode();
			System.out.println("responseCode"+responseCode);
			if (responseCode == 200) {
				// 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			} else {
				// 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
			}
			
			while ((inputLine = br.readLine()) != null)
				responseBook.append(inputLine);
			
		}finally {
			br.close();
		}
		return responseBook.toString();
	}

	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시글 작성 기능을 구현합니다.
	 * </pre>
	 * 
	 * @param	BoardVO			BoardVO객체를 통해 전달받습니다.
	 * @throws	SQLException
	 */
	public abstract void insertBoard(BoardVO boardVO) throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시글 수정 기능을 구현합니다.
	 * </pre>
	 * 
	 * @param	BoardVO			BoardVO객체를 통해 전달받습니다.
	 * @throws	SQLException
	 */
	public abstract void updateBoard(BoardVO boardVO) throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시글 삭제 기능을 구현합니다.
	 * </pre>
	 * 
	 * @param 	boardNo			삭제할 게시판번호
	 * @throws	SQLException
	 */
	public abstract void deleteBoard(int boardNo) throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시글 상세보기 기능을 구현합니다.
	 * </pre>
	 * 
	 * @param	boardNo			상세보기할 게시판 번호
	 * @return	BoardVO			게시판번호로 조회한 게시판의 정보
	 * @throws	SQLException
	 */
	public abstract BoardVO selectBoard(int boardNo) throws SQLException;
	
	/**
	 * <pre>
	 * <b>메서드 설명</b>
	 *    -게시글 상세보기 기능을 구현합니다.
	 *    
	 *    1.ArrayList의 Element를 부모클래스인 BoardVO 타입으로 받습니다.
	 *    2.ArrayList의 Generic은 형변환을 허용하지 않기 때문에 VO 타입을 형변환 하여
	 *    새로운 ArrayList에 for문으로 하나씩 add하셔서 사용하셔야합니다.
	 *    
	 *    ex)
	 *    
	 *    1.
	 *    //메서드 선언
	 *    public ArrayList<BoardVO> boardList(int boardType){
	 *   	 ArrayList<BoardVO> list = new ArrayList<BoardVO>();
	 *   	 list.add(new CreateBoardVO());
	 *   	 return list;
	 *    }
	 *    
	 *    2.
	 *    //리턴받은 list객체의 element로 접근하는 방법
	 *    ArrayList<CreateBoardVO> list = new ArrayList<CreateBoardVO>();
	 *    for(){
	 *    	 list.add((CreateBoardVO)boardList().get(i));
	 *    }
	 *    
	 *    //BoardVO가 아닌 CreateBoardVO클래스의 변수에 접근 가능.
	 *    System.out.println("캐스팅 리스트 제목 : " + list.get(0).getCreate_title());
	 *    System.out.println("캐스팅 리스트 내용 : " + list.get(0).getCreate_content());
	 *	  System.out.println("캐스팅 리스트 분류 : " + list.get(0).getCategory());
	 *
	 * </pre>
	 * 
	 * @param	boardType			리스트를 보여줄 게시판의 타입번호
	 * @return	ArrayList<BoardVO>	게시판의 타입번호로 조회한 게시판의 리스트
	 * @throws	SQLException
	 */
	public abstract ArrayList<BoardVO> boardList(PagingBean pagingBean) throws SQLException;
	
	/*
	 * 게시판의 전체 게시글을 보여주는 내용입니다.
	 */
	public abstract int totalCountByBoard() throws SQLException;    
}
