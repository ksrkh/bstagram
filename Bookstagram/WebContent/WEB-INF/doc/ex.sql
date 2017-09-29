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
 * 게시판 타입
 */
create sequence boardtype_seq;
insert into board_type(boardtype_no, boardtype_name) values(boardtype_seq.nextval,'한줄게시판');
insert into board_type(boardtype_no, boardtype_name) values(boardtype_seq.nextval,'책리뷰게시판');
insert into board_type(boardtype_no, boardtype_name) values(boardtype_seq.nextval,'창작게시판');
commit;

/*
 * 게시판 배경화면
 */
create sequence background_seq;
insert into board_background(bg_no, bg_path) values(0,'empty');
insert into board_background(bg_no, bg_path) values(background_seq.nextval,'1.jpg');
insert into board_background(bg_no, bg_path) values(background_seq.nextval,'2.jpg');
insert into board_background(bg_no, bg_path) values(background_seq.nextval,'3.jpg');
insert into board_background(bg_no, bg_path) values(background_seq.nextval,'4.jpg');
insert into board_background(bg_no, bg_path) values(background_seq.nextval,'5.jpg');
insert into board_background(bg_no, bg_path) values(background_seq.nextval,'6.jpg');
insert into board_background(bg_no, bg_path) values(background_seq.nextval,'7.jpg');
insert into board_background(bg_no, bg_path) values(background_seq.nextval,'8.jpg');
insert into board_background(bg_no, bg_path) values(background_seq.nextval,'9.jpg');
insert into board_background(bg_no, bg_path) values(background_seq.nextval,'10.jpg');
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
insert into member(id, pw, nick, age, regdate, m_photo, temp, tend_code, tend_code2, tend_code3, tier, question_code, pw_ans)
values('orangss@naver.com','1234','ksh',30,sysdate,null,null,7,8,11,3,4,'수지중학교');
commit;


/*
 * 한줄게시판 글등록
 */
create sequence board_seq;
insert into board(board_no, boardtype_no, id, board_regdate, hit, sympathy, authority, bg_no)
values(board_seq.nextval, 1, 'kjhsc101218@naver.com', sysdate, 0, 0, 1, 0);
insert into line_board(board_no, line_title, line_author, line_content, tend_code)
values(board_seq.currval, '언어의온도', '이기주', '화장실을 깨끗하게 사용해주세요. 이곳을 청소해주시는 분들, 누군가에겐 전부인 사람들입니다.', 8);

insert into board(board_no, boardtype_no, id, board_regdate, hit, sympathy, authority, bg_no)
values(board_seq.nextval, 1, 'kjhsc101218@naver.com', sysdate, 0, 0, 1, 1);
insert into line_board(board_no, line_title, line_author, line_content, tend_code)
values(board_seq.currval, '말의품격', '이기주', '당신의 입이아닌 귀를 내어주라', 8);

insert into board(board_no, boardtype_no, id, board_regdate, hit, sympathy, authority, bg_no)
values(board_seq.nextval, 1, 'kjhsc101218@naver.com', sysdate, 0, 0, 1, 2);
insert into line_board(board_no, line_title, line_author, line_content, tend_code)
values(board_seq.currval, '오직두사람', '김영하', '똑같은 패턴이 반복됬어요. 제가 호감을 느끼는 남자를 만나고, 그 남자가 절 이상해하고, 저는 그 남자에게 실망하고, 그러다 헤어지고...', 4);

insert into board(board_no, boardtype_no, id, board_regdate, hit, sympathy, authority, bg_no)
values(board_seq.nextval, 1, 'kjhsc101218@naver.com', sysdate, 0, 0, 1, 3);
insert into line_board(board_no, line_title, line_author, line_content, tend_code)
values(board_seq.currval, '보통의존재', '이석원', '잘 생각해보세요. 내가 듣기 좋은 말만 하거나 당신에 대해 어떤 반대도 하지 않았다면 난 당신을 정말로 좋아하는 것은 아니에요. 친하다고 생각하지 않는거죠. 솔직하다는 말을 많이듣는 편이지만 정확히 말하면 난 나에대해서만 솔직해요.', 3);

insert into board(board_no, boardtype_no, id, board_regdate, hit, sympathy, authority, bg_no)
values(board_seq.nextval, 1, 'kjhsc101218@naver.com', sysdate, 0, 0, 1, 4);
insert into line_board(board_no, line_title, line_author, line_content, tend_code)
values(board_seq.currval, '같은시간에 우린 어쩌면', '변종모', '"나만의" 라고 쓰려다가 "나의"라고 쓴다. 많은사람이 당신을 두고 "나만의"라고 쓰고싶어 한다는것을 알기에 당신은 그런사람이기에..', 3);


/*
 * 책리뷰 글등록
 */
insert into board(board_no, boardtype_no, id, board_regdate, hit, sympathy, authority, bg_no)
values(board_seq.nextval, 2, 'will0324@hanmail.net', sysdate, 0, 0, 1, 0);
insert into review_board(board_no, book_title, book_author, review_title, review_content, star_point, book_img, genre)
values(board_seq.currval, '독후감 잘 쓰는 법', '이병승', '매력적인 제목, 인상적인 시작', '독후감을 심사할 때 중요하게 여기는 부분은 처음 시작 대목이다. 첫 부분이 어색하거나 밋밋하다면 한 수준 아래로 글을 평가한다. 심사해야 할 원고가 많으면 많을수록 첫 부분은 더욱 중요해진다. 
가장 재미없는 독후감 제목은 책 이름을 그대로 쓰는 경우다. 그보다 조금 나은 제목은 ‘~을 읽고’라는 제목이다. 그렇다면 최고 수준의 제목은 무엇일까. 가장 눈길을 끄는 제목은 자신이 생각하는 책에 대한 주제를 주제목으로 하고 부제목으로 ‘~을 읽고’라고 쓴 제목이다.
예를 들어 피노키오를 읽고 ‘인간이 되고픈 피노키오의 간절한 소망을 응원하며’ ‘인간으로 다시 탄생한 착한 목각 인형’ 등과 같이 주제목으로 결정할 수 있다. 그러나 제목은 글을 쓴 후 가장 나중에 붙여도 된다는 것을 명심하자. ',0,0,5);


/*
 * 창작게시판 글등록
 */
insert into board(board_no, boardtype_no, id, board_regdate, hit, sympathy, authority, bg_no)
values(board_seq.nextval, 3, 'orangss@naver.com', sysdate, 0, 0, 1, 0);
insert into create_board(board_no, create_title, create_content, category)
values(board_seq.currval, '창작의 시작', '창작한 내용', 4);
commit