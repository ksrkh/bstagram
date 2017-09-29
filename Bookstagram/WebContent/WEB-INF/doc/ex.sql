/*
 * 회원등급 데이터
 */
create sequence tier_seq;
insert into member_tier(tier, tier_name) values(0,'탈퇴회원');
insert into member_tier(tier, tier_name) values(tier_seq.nextval,'회원');
insert into member_tier(tier, tier_name) values(tier_seq.nextval,'운영자');
insert into member_tier(tier, tier_name) values(tier_seq.nextval,'시스템관리자');
commit;

/*
 * 비밀번호찾기질문 
 */
create sequence question_seq;
insert into question(question_code, question) values(question_seq.nextval,'당신의 고향은?');					--1
insert into question(question_code, question) values(question_seq.nextval,'당신의 어머니 성함은?');				--2
insert into question(question_code, question) values(question_seq.nextval,'당신의 아버지 성함은?');				--3
insert into question(question_code, question) values(question_seq.nextval,'당신의 출신 중학교는?');				--4
insert into question(question_code, question) values(question_seq.nextval,'당신이 감명깊게 읽은 책 제목은?');		--5
insert into question(question_code, question) values(question_seq.nextval,'당신의 직업은?');					--6
insert into question(question_code, question) values(question_seq.nextval,'당신의 제일 기억에 남는 기억은?');		--7
insert into question(question_code, question) values(question_seq.nextval,'당신이 소중하게 생각하는 사람의 이름은?'); --8
insert into question(question_code, question) values(question_seq.nextval,'당신의 제일 친한 친구 이름은?');		--9
insert into question(question_code, question) values(question_seq.nextval,'당신이 태어난 고향은?');				--10
commit;

/*
 * 성향 데이터
 */
create sequence tend_seq;
insert into tend(tend_code, tend_name) values(0,'없음');
insert into tend(tend_code, tend_name) values(tend_seq.nextval,'슬픈'); --1
insert into tend(tend_code, tend_name) values(tend_seq.nextval,'분노'); --2
insert into tend(tend_code, tend_name) values(tend_seq.nextval,'사랑'); --3
insert into tend(tend_code, tend_name) values(tend_seq.nextval,'허무'); --4
insert into tend(tend_code, tend_name) values(tend_seq.nextval,'기쁜'); --5
insert into tend(tend_code, tend_name) values(tend_seq.nextval,'우정'); --6
insert into tend(tend_code, tend_name) values(tend_seq.nextval,'믿음'); --7
insert into tend(tend_code, tend_name) values(tend_seq.nextval,'성찰'); --8
insert into tend(tend_code, tend_name) values(tend_seq.nextval,'행복'); --9
insert into tend(tend_code, tend_name) values(tend_seq.nextval,'여유'); --10
insert into tend(tend_code, tend_name) values(tend_seq.nextval,'희망'); --11
insert into tend(tend_code, tend_name) values(tend_seq.nextval,'기타'); --12
commit;

/*
 * 장르 데이터
 */
create sequence genre_seq;
insert into genre(genre, genre_name) values(genre_seq.nextval,'소설');
insert into genre(genre, genre_name) values(genre_seq.nextval,'에세이/시');
insert into genre(genre, genre_name) values(genre_seq.nextval,'경영/경제');
insert into genre(genre, genre_name) values(genre_seq.nextval,'자기계발');
insert into genre(genre, genre_name) values(genre_seq.nextval,'인문/사회/역사');
insert into genre(genre, genre_name) values(genre_seq.nextval,'건강/다이어트');
insert into genre(genre, genre_name) values(genre_seq.nextval,'가정/생활');
insert into genre(genre, genre_name) values(genre_seq.nextval,'종교');
insert into genre(genre, genre_name) values(genre_seq.nextval,'여행');
commit;

/*
 * 분야 데이터
 */
create sequence category_seq;
insert into category(category, category_name) values(category_seq.nextval,'소설');
insert into category(category, category_name) values(category_seq.nextval,'에세이/시');
insert into category(category, category_name) values(category_seq.nextval,'경영/경제');
insert into category(category, category_name) values(category_seq.nextval,'자기계발');
insert into category(category, category_name) values(category_seq.nextval,'인문/사회/역사');
insert into category(category, category_name) values(category_seq.nextval,'건강/다이어트');
insert into category(category, category_name) values(category_seq.nextval,'가정/생활');
insert into category(category, category_name) values(category_seq.nextval,'종교');
insert into category(category, category_name) values(category_seq.nextval,'여행');
commit;

/*
 * 게시판타입 데이터
 */
create sequence boardtype_seq;
insert into board_type(boardtype_no, boardtype_name) values(boardtype_seq.nextval,'한줄게시판');
insert into board_type(boardtype_no, boardtype_name) values(boardtype_seq.nextval,'책리뷰게시판');
insert into board_type(boardtype_no, boardtype_name) values(boardtype_seq.nextval,'창작게시판');
commit;


/*
 * 임시회원정보
 */
create sequence member_seq;
insert into member(id, pw,nick,age,regdate,m_photo,temp,tend_code,tend_code2,tend_code3,tier,question_code,pw_ans)
values('kjhsc101218@naver.com','1234','hsc',26,sysdate,null,null,0,0,0,3,3,'황운');
insert into member(id, pw,nick,age,regdate,m_photo,temp,tend_code,tend_code2,tend_code3,tier,question_code,pw_ans)
values('dnwjdrnl2@naver.com','1234','kwj',24,sysdate,null,null,1,2,6,3,1,'안양');
insert into member(id, pw,nick,age,regdate,m_photo,temp,tend_code,tend_code2,tend_code3,tier,question_code,pw_ans)
values('will0324@hanmail.net','1234','sjy',28,sysdate,null,null,3,5,6,3,9,'류향걸');
insert into member(id, pw,nick,age,regdate,m_photo,temp,tend_code,tend_code2,tend_code3,tier,question_code,pw_ans)
values('ryuhyg@naver.com','1234','rhg',28,sysdate,null,null,3,9,11,3,8,'신준영');
insert into member(id, pw,nick,age,regdate,m_photo,temp,tend_code,tend_code2,tend_code3,tier,question_code,pw_ans)
values('orangss@naver.com','1234','ksh',30,sysdate,null,null,7,8,11,3,4,'수지중학교');
commit;


/*
 * 한줄게시판 글등록
 */

/*
 * 책리뷰 글등록
 */

/*
 * 창작게시판 글등록
 */