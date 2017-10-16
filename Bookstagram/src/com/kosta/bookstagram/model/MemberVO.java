package com.kosta.bookstagram.model;

public class MemberVO {
	/*
	 * 아이디(이메일)
	 */
	private String id;
	/*
	 * 패스워드
	 */
	private String pw;
	/*
	 * 닉네임
	 */
	private String nick;
	/*
	 * 나이
	 */
	private int age;
	/*
	 * 등록일자
	 */
	private String regdate;
	/*
	 * 프로필 사진
	 */
	private String m_photo;
	/*
	 * 성향코드1
	 */
	private int tend_code;
	/*
	 * 성향이름1
	 */
	private String tend_name;
	/*
	 * 성향코드2
	 */
	private int tend_code2;
	/*
	 * 성향이름2
	 */
	private String tend_name2;
	/*
	 * 성향코드3
	 */
	private int tend_code3;
	/*
	 * 성향이름3
	 */
	private String tend_name3;
	/*
	 * 회원등급
	 */
	private int tier;
	/*
	 * 등급명
	 */
	private String tier_name;
	/*
	 * 질문번호
	 */
	private int question_code;
	/*
	 * 질문번호에 해당하는 답변
	 */
	private String pw_ans;
	/*
	 * 기본생성자
	 */
	public MemberVO() {}
	/**
	 * -회원정보
	 * 
	 * @param id			아이디(이메일)
	 * @param pw			비밀번호
	 * @param nick			닉네임
	 * @param age			나이
	 * @param regdate		가입날짜
	 * @param m_photo		프로필사진
	 * @param tend_code		성향
	 * @param tend_code2	성향
	 * @param tend_code3	성향
	 * @param tier			회원등급
	 * @param question_code	비밀번호 찾기 질문코드
	 * @param pw_ans		비밀번호 찾기 질문답변
	 */
	public MemberVO(String id, String pw, String nick, int age, String regdate, String m_photo, int tend_code,
			int tend_code2, int tend_code3, int tier, int question_code, String pw_ans) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.age = age;
		this.regdate = regdate;
		this.m_photo = m_photo;
		this.tend_code = tend_code;
		this.tend_code2 = tend_code2;
		this.tend_code3 = tend_code3;
		this.tier = tier;
		this.question_code = question_code;
		this.pw_ans = pw_ans;
	}
	
	/**
	 * -회원가입
	 * 
	 * @param id			아이디(이메일)
	 * @param pw			비밀번호
	 * @param nick			닉네임
	 * @param age			나이
	 * @param tend_code		성향
	 * @param tend_code2	성향
	 * @param tend_code3	성향
	 * @param question_code	비밀번호 찾기 질문코드
	 * @param pw_ans		비밀번호 찾기 질문답변
	 */
	public MemberVO(String id, String pw, String nick, int age, int tend_code,
			int tend_code2, int tend_code3, int question_code, String pw_ans) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.age = age;
		this.tend_code = tend_code;
		this.tend_code2 = tend_code2;
		this.tend_code3 = tend_code3;
		this.question_code = question_code;
		this.pw_ans = pw_ans;
	}
	
	
	/**
	 * -회원정보 수정
	 * 
	 * @param id			아이디(이메일)
	 * @param pw			비밀번호
	 * @param m_photo		프로필사진
	 * @param tend_code		성향1
	 * @param tend_code2	성향2
	 * @param tend_code3	성향3
	 */
	public MemberVO(String id, String pw, String m_photo, int tend_code, int tend_code2, int tend_code3) {
		this.id = id;
		this.pw = pw;
		this.m_photo = m_photo;
		this.tend_code = tend_code;
		this.tend_code2 = tend_code2;
		this.tend_code3 = tend_code3;
	}
	
	/**
	 * -관리자 페이지 회원정보 수정
	 * 
	 * @param id			아이디(이메일)
	 * @param pw			비밀번호
	 * @param age			나이
	 * @param tend_code		성향1
	 * @param tend_code2	성향2
	 * @param tend_code3	성향3
	 * @param tier			회원등급
	 */
	public MemberVO(String id, String pw, int age, int tend_code, int tend_code2, int tend_code3, int tier) {
		this.id = id;
		this.pw = pw;
		this.tend_code = tend_code;
		this.tend_code2 = tend_code2;
		this.tend_code3 = tend_code3;
		this.tier = tier;
	}
	
	
	/**
	 * -관리자페이지 목록보여주기
	 * 
	 * @param id			아이디
	 * @param pw			비밀번호
	 * @param age			나이
	 * @param tend_name		성향1
	 * @param tend_name2	성향2
	 * @param tend_name3	성향3
	 * @param tier_name		회원등급1
	 * @param regdate		등록일자
	 */
	public MemberVO(String id, String pw, int age, String tend_name, String tend_name2, String tend_name3, String tier_name, String regdate) {
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.tend_name = tend_name;
		this.tend_name2 = tend_name2;
		this.tend_name3 = tend_name3;
		this.tier_name = tier_name;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getM_photo() {
		return m_photo;
	}

	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}

	public int getTend_code() {
		return tend_code;
	}

	public void setTend_code(int tend_code) {
		this.tend_code = tend_code;
	}

	public int getTend_code2() {
		return tend_code2;
	}

	public void setTend_code2(int tend_code2) {
		this.tend_code2 = tend_code2;
	}

	public int getTend_code3() {
		return tend_code3;
	}

	public void setTend_code3(int tend_code3) {
		this.tend_code3 = tend_code3;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

	public int getQuestion_code() {
		return question_code;
	}

	public void setQuestion_code(int question_code) {
		this.question_code = question_code;
	}

	public String getPw_ans() {
		return pw_ans;
	}

	public void setPw_ans(String pw_ans) {
		this.pw_ans = pw_ans;
	}
	
	public String getTend_name() {
		return tend_name;
	}
	
	public void setTend_name(String tend_name) {
		this.tend_name = tend_name;
	}
	
	public String getTend_name2() {
		return tend_name2;
	}
	
	public void setTend_name2(String tend_name2) {
		this.tend_name2 = tend_name2;
	}
	
	public String getTend_name3() {
		return tend_name3;
	}
	
	public void setTend_name3(String tend_name3) {
		this.tend_name3 = tend_name3;
	}
	
	public String getTier_name() {
		return tier_name;
	}
	
	public void setTier_name(String tier_name) {
		this.tier_name = tier_name;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", nick=" + nick + ", age=" + age + ", regdate=" + regdate
				+ ", m_photo=" + m_photo + ", tend_code=" + tend_code + ", tend_code2=" + tend_code2 + ", tend_code3="
				+ tend_code3 + ", tier=" + tier + ", question_code=" + question_code + ", pw_ans=" + pw_ans + "]";
	}
}
