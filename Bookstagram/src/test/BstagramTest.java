package test;

import com.kosta.bookstagram.model.LineBoardVO;

public class BstagramTest {
	public static void main(String[] args) {
		/*
		 * 한줄게시판 생성자 테스트
		 */
		System.out.println("****************************** LineBoardVO VO객체 테스트 ********************************");
		LineBoardVO vo = new LineBoardVO(1,1,"kjhsc101218@naver.com","2017-08-12",0,0,1,0,"언어의온도","이기주","화장실을 깨끗하게 사용해주세요. 이곳을 청소해주시는 분들, 누군가에겐 전부인 사람들입니다.",8);
		System.out.println("게시판번호 :" + vo.getBoard_no());
		System.out.println("게시판타입번호 :" + vo.getBoardtype_no());
		System.out.println("작성자 :" + vo.getId());
		System.out.println("게시판등록일자 :" + vo.getBoard_regdate());
		System.out.println("조회수 :" + vo.getHit());
		System.out.println("좋아요 :" + vo.getSympathy());
		System.out.println("공개권한 :" + vo.getAuthority());
		System.out.println("배경번호 :" + vo.getBg_no());
		System.out.println("한줄게시판 책 제목 :" + vo.getLine_title());
		System.out.println("한줄게시판 책 저자 :" + vo.getLine_author());
		System.out.println("한줄게시판 내용 :" + vo.getLine_content());
		System.out.println("한줄게시판 성향코드 :" + vo.getTend_code());
		System.out.println("**************************************************************************************");
	}
}
