package com.kosta.bookstagram.model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kosta.bookstagram.model.common.CommonDAO;
import com.kosta.bookstagram.model.common.ReReplyVO;
import com.kosta.bookstagram.model.common.ReplyVO;
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
		System.out.println("registerReply() 실행");
	}

	@Override
	public void registerReReply(String id, int replyNo, String content) throws SQLException {
		System.out.println("registerReReply() 실행");
	}

	@Override
	public void removeReply(int replyNo) throws SQLException {
		System.out.println("removeReply() 실행");
	}

	@Override
	public void removeReReply(int rereplyNo) throws SQLException {
		System.out.println("removeReReply() 실행");
	}

	@Override
	public ArrayList<ReplyVO> viewReply(int boardNo) throws SQLException {
		System.out.println("viewReply() 실행");
		return null;
	}

	@Override
	public ArrayList<ReReplyVO> viewReReply(ArrayList<ReplyVO> replyList) throws SQLException {
		System.out.println("viewReReply() 실행");
		return null;
	}

	@Override
	public void likeService(String id, int boardNo) throws SQLException {
		System.out.println("likeBoard() 실행");
	}

	@Override
	public void hits(int boardNo) throws SQLException {
		System.out.println("hits() 실행");
	}

	@Override
	public int totalCountByBoardNId(int boardType, String id) throws SQLException {
		return 0;
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
	public abstract ArrayList<BoardVO> boardList() throws SQLException;
	
	/*
	 * 게시판의 전체 게시글을 보여주는 내용입니다.
	 */
	public abstract int totalCountByBoard() throws SQLException;    
}
