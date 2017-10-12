package test;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kosta.bookstagram.model.CreateBoardVO;
import com.kosta.bookstagram.model.LineBoardVO;
import com.kosta.bookstagram.model.MemberDAO;
import com.kosta.bookstagram.model.ReviewBoardVO;
import com.kosta.bookstagram.model.common.ListVO;
import com.kosta.bookstagram.model.common.PagingBean;

public class BstagramBoardTest {
	public static void main(String[] args) {
		/*
		 * 한줄게시판 생성자 테스트
		 */
		System.out.println("****************************** LineBoardVO VO객체 테스트 ********************************");
		LineBoardVO lineVO = new LineBoardVO(1,1,"kjhsc101218@naver.com","java","2017-08-12",0,0,1,0,"화장실을 깨끗하게 사용해주세요. 이곳을 청소해주시는 분들, 누군가에겐 전부인 사람들입니다.",8, 1);
		System.out.println("게시판번호 :" + lineVO.getBoard_no());
		System.out.println("게시판타입번호 :" + lineVO.getBoardtype_no());
		System.out.println("작성자 :" + lineVO.getId());
		System.out.println("게시판등록일자 :" + lineVO.getBoard_regdate());
		System.out.println("조회수 :" + lineVO.getHit());
		System.out.println("좋아요 :" + lineVO.getSympathy());
		System.out.println("공개권한 :" + lineVO.getAuthority());
		System.out.println("배경번호 :" + lineVO.getBg_no());
		System.out.println("한줄게시판 내용 :" + lineVO.getLine_content());
		System.out.println("한줄게시판 성향코드 :" + lineVO.getTend_code());
		System.out.println("한줄게시판 책 :" + lineVO.getBook_no());
		System.out.println("**************************************************************************************");
		System.out.println();
		
		/*
		 * 책 리뷰 게시판 생성자 테스트
		 */
		System.out.println("****************************** ReviewBoardVO VO객체 테스트 ********************************");
		String reviewContent = "독후감을 심사할 때 중요하게 여기는 부분은 처음 시작 대목이다. 첫 부분이 어색하거나 밋밋하다면 한 수준 아래로 글을 평가한다. 심사해야 할 원고가 많으면 많을수록 첫 부분은 더욱 중요해진다. "+
				"가장 재미없는 독후감 제목은 책 이름을 그대로 쓰는 경우다. 그보다 조금 나은 제목은 ‘~을 읽고’라는 제목이다. 그렇다면 최고 수준의 제목은 무엇일까. 가장 눈길을 끄는 제목은 자신이 생각하는 책에 대한 주제를 주제목으로 하고 부제목으로 ‘~을 읽고’라고 쓴 제목이다."+
				" 예를 들어 피노키오를 읽고 ‘인간이 되고픈 피노키오의 간절한 소망을 응원하며’ ‘인간으로 다시 탄생한 착한 목각 인형’ 등과 같이 주제목으로 결정할 수 있다. 그러나 제목은 글을 쓴 후 가장 나중에 붙여도 된다는 것을 명심하자.";
		ReviewBoardVO reviewVO = new ReviewBoardVO(2, 2, "will0324@hanmail.net", "spring","2017-08-27", 0, 0, 1, 0, "매력적인 제목, 인상적인 시작", reviewContent,0,5,2);
		System.out.println("게시판번호 :" + reviewVO.getBoard_no());
		System.out.println("게시판타입번호 :" + reviewVO.getBoardtype_no());
		System.out.println("작성자 :" + reviewVO.getId());
		System.out.println("게시판등록일자 :" + reviewVO.getBoard_regdate());
		System.out.println("조회수 :" + reviewVO.getHit());
		System.out.println("좋아요 :" + reviewVO.getSympathy());
		System.out.println("공개권한 :" + reviewVO.getAuthority());
		System.out.println("배경번호 :" + reviewVO.getBg_no());
		System.out.println("게시글제목 :" + reviewVO.getReview_title());
		System.out.println("게시글내용 :" + reviewVO.getReview_content());
		System.out.println("책별점 :" + reviewVO.getStar_point());
		System.out.println("책썸네일 :" + reviewVO.getBook_no());
		System.out.println("책장르 :" + reviewVO.getGenre());
		System.out.println("**************************************************************************************");
		System.out.println();
		
		/*
		 * 창작게시판 테스트
		 */
		System.out.println("****************************** CreateBoard VO객체 테스트 ********************************");
		CreateBoardVO createVO = new CreateBoardVO(3, 3, "orangss@naver.com", "2017-09-01", 0, 1, 0, "창작의 시작", "창작한 내용", 4);
		System.out.println("게시판번호 :" + createVO.getBoard_no());
		System.out.println("게시판타입번호 :" + createVO.getBoardtype_no());
		System.out.println("작성자 :" + createVO.getId());
		System.out.println("게시판등록일자 :" + createVO.getBoard_regdate());
		System.out.println("조회수 :" + createVO.getHit());
		System.out.println("좋아요 :" + createVO.getSympathy());
		System.out.println("공개권한 :" + createVO.getAuthority());
		System.out.println("배경번호 :" + createVO.getBg_no());
		System.out.println("창작게시판 제목 :" + createVO.getCreate_title());
		System.out.println("창작게시판 내용 :" + createVO.getCreate_content());
		System.out.println("창작게시판 분류 :" + createVO.getCategory());
		System.out.println("**************************************************************************************");
		System.out.println();
		System.out.println();
		
		/*
		 * DAO 테스트
		 */
		try {
			// ****************************************************************************
			
			//Generic 이용
			ArrayList<CreateBoardVO> createList = new ArrayList<CreateBoardVO>();
			ListVO<CreateBoardVO> listvo = new ListVO<CreateBoardVO>(createList, new PagingBean());
			listvo.getList().get(0).getAuthority();			//BoardVO
			listvo.getList().get(0).getCreate_content();	//CreateBoardVO
			
			//Generic 이용
			//ArrayList<LineBoardVO> LineList = new ArrayList<LineBoardVO>();
			//ListVO<LineBoardVO> listvo2 = new ListVO<LineBoardVO>(LineList, new PagingBean());
			//listvo2.getList().get(0).getAuthority();		//BoardVO
			//listvo2.getList().get(0).getLine_content();		//LineBoardVO
			
			//Generic 이용
			//ArrayList<ReviewBoardVO> ReviewList = new ArrayList<ReviewBoardVO>();
			//ListVO<ReviewBoardVO> listvo3 = new ListVO<ReviewBoardVO>(ReviewList, new PagingBean());
			//listvo3.getList().get(0).getAuthority();		//BoardVO
			//listvo3.getList().get(0).getReview_content();	//ReviewBoardVO
			
			System.out.println("[ MemberDAO ]");
			//조회테스트
			System.out.println(MemberDAO.getInstance().checkMember("a", "1").toString());
			//회원가입테스트
			//MemberDAO.getInstance().addMember(new MemberVO("b", "1234", "n", 23, null, 0, 0, 0, 1, 2, "주녕이형"));
			System.out.println(MemberDAO.getInstance().checkMember("b", "1234").toString());

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
