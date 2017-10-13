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
insert into member(id, pw,nick,age,regdate,m_photo,temp,tend_code,tend_code2,tend_code3,tier,question_code,pw_ans)
values('a','1','hsc',26,sysdate,null,null,0,0,0,3,3,'황운');
commit;


/*
 * 한줄게시판 글등록
 */
create sequence board_seq;
create sequence book_seq;
insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(board_seq.nextval, 1, 'kjhsc101218@naver.com', sysdate, 0, 1, 0);
insert into book(book_no, book_title, book_intro, book_author, book_publ, book_sdate, book_edate, book_cate, book_img)
values(book_seq.nextval, '언어의온도', '『언어의 온도』의 저자 이기주는 엿듣고 기록하는 일을 즐겨 하는 사람이다. 그는 버스나 지하철에 몸을 실으면 몹쓸 버릇이 발동한다고 고백한다. 이 책은 저자가 일상에서 발견한 의미 있는 말과 글, 단어의 어원과 유래, 그런 언어가 지닌 소중함과 절실함을 농밀하게 담아낸 것이다.','이기주', '말푸름', '2016-02-03', '2016-02-05','1', 'https://search.pstatic.net/common/?src=http%3A%2F%2Fbookthumb.phinf.naver.net%2Fcover%2F109%2F245%2F10924505.jpg%3Ftype%3Dm1%26udate%3D20171007&type=o75_108_re24');
insert into line_board(board_no, line_content, tend_code, book_no)
values(board_seq.currval, '화장실을 깨끗하게 사용해주세요. 이곳을 청소해주시는 분들, 누군가에겐 전부인 사람들입니다.', 8, 1);

insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(board_seq.nextval, 1, 'kjhsc101218@naver.com', sysdate, 0, 1, 1);
insert into book(book_no, book_title, book_intro, book_author, book_publ, book_sdate, book_edate, book_cate,  book_img)
values(book_seq.nextval, '말의품격', '두 남녀의 아련한 첫사랑 이야기인 동시에  1Q84를 헤쳐나가며 겪게 되는 환상적인 이야기를 그렸다. 압도적인 이야기의 강렬함과 흡인력이 돋보인다. 스타일리시한 여자 암살자 아오마메와 작가지망생 덴고. 꽉 막힌 고속도로의 비상계단을 내려오면서 다른 세계로 접어든 아오마메와, 천재적인 문학성을 가진 열일곱 소녀 후카에리를 만나 기묘한 사건에 휘말리게 된 덴고 앞에 1Q84의 세계가 펼쳐진다. 그들은 몇 개의 달이 떠 있는 하늘 아래에서 만나게 될까? ','이기주', '말푸름', '2016-05-02', '2016-07-08','1', 'https://search.pstatic.net/common/?src=http%3A%2F%2Fbookthumb.phinf.naver.net%2Fcover%2F063%2F231%2F06323153.jpg%3Ftype%3Dm3%26udate%3D20130405&type=o75_108_re24');
insert into line_board(board_no, line_content, tend_code, book_no)
values(board_seq.currval, '당신의 입이아닌 귀를 내어주라', 8, 2);

insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(board_seq.nextval, 1, 'kjhsc101218@naver.com', sysdate, 0, 1, 2);
insert into book(book_no, book_title, book_intro, book_author, book_publ, book_sdate, book_edate, book_cate,  book_img)
values(book_seq.nextval, '오직두사람', '히가시노 게이고의 소설 『가면산장 살인사건』. 저자와 독자가 아슬아슬한 두뇌 싸움을 벌이게 되는 이 작품은 외딴 산장에 모인 여덟 명의 남녀와 한밤중에 침입한 은행 강도범의 인질극을 그리고 있다. 잘 짜인 무대에서 벌어지는 연극과도 같은 이 소설은 그 누구도 상상조차 할 수 없었던 엄청난 반전을 담고 있다. 초대된 손님과 2인조 은행 강도 사이에 긴장과 서스펜스가 점차 고조되는 가운데 클라이맥스에 이르러 전개되는 대반전을 만나는 즐거움을 느낄 수 있다.','김영하', '말푸름', '2016-05-02', '2016-07-08','1', 'https://search.pstatic.net/common/?src=http%3A%2F%2Fbookthumb.phinf.naver.net%2Fcover%2F082%2F730%2F08273055.jpg%3Ftype%3Dm1%26udate%3D20170914&type=o75_108_re24');
insert into line_board(board_no, line_content, tend_code, book_no)
values(board_seq.currval, '똑같은 패턴이 반복됬어요. 제가 호감을 느끼는 남자를 만나고, 그 남자가 절 이상해하고, 저는 그 남자에게 실망하고, 그러다 헤어지고...', 4, 3);

insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(board_seq.nextval, 1, 'kjhsc101218@naver.com', sysdate, 0, 1, 3);
insert into book(book_no, book_title, book_intro, book_author, book_publ, book_sdate, book_edate, book_cate,  book_img)
values(book_seq.nextval, '보통의존재', '히가시노 게이고 문학의 정수로 일컬어지는 추리 소설 『용의자 X의 헌신』. 일본 문학 전문 번역가 양억관이 자신의 번역을 대폭 손질해 원작이 지닌 문학적 향기와 감동을 오롯이 되살려냈다. 일본 추리소설에서 흔히 보여 지는 잔혹함이나 엽기 호러가 아닌 사랑과 헌신이라는 고전적이며 낭만적인 테마를 미로처럼 섬세하게 엮어낸 슬프고 아름다운 이야기로, 제134회 나오키상을 수상했다. ','이석원', '말푸름', '2014-05-02', '2016-07-08','2', 'https://search.pstatic.net/common/?src=http%3A%2F%2Fbookthumb.phinf.naver.net%2Fcover%2F124%2F818%2F12481857.jpg%3Ftype%3Dm1%26udate%3D20170914&type=o75_108_re24');
insert into line_board(board_no, line_content, tend_code, book_no)
values(board_seq.currval, '잘 생각해보세요. 내가 듣기 좋은 말만 하거나 당신에 대해 어떤 반대도 하지 않았다면 난 당신을 정말로 좋아하는 것은 아니에요. 친하다고 생각하지 않는거죠. 솔직하다는 말을 많이듣는 편이지만 정확히 말하면 난 나에대해서만 솔직해요.', 3, 4);

insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(board_seq.nextval, 1, 'kjhsc101218@naver.com', sysdate, 0, 1, 4);
insert into book(book_no, book_title, book_intro, book_author, book_publ, book_sdate, book_edate, book_cate, book_img)
values(book_seq.nextval, '같은시간에 우린 어쩌면', '『말의 품격』은 《언어의 온도》로 많은 독자의 공감을 얻은 이기주 작가의 에세이집이다. 경청, 공감, 반응, 뒷말, 인향, 소음 등의 24개의 키워드를 통해 말과 사람과 품격에 대한 생각들을 풀어낸다. 저자의 인문학적 소양을 바탕과 감성이 더해져 볼거리와 생각거리를 동시에 전한다. 한 장 한 장 넘길 때마다 자신의 말과 세계관에 대해 끝없는 질문을 던지게 될 것이다.', '변종모', '말푸름', '2010-05-02', '2011-07-02','3', 'https://search.pstatic.net/common/?src=http%3A%2F%2Fbookthumb.phinf.naver.net%2Fcover%2F120%2F222%2F12022296.jpg%3Ftype%3Dm1%26udate%3D20170922&type=o75_108_re24');
insert into line_board(board_no, line_content, tend_code, book_no)
values(board_seq.currval, '"나만의" 라고 쓰려다가 "나의"라고 쓴다. 많은사람이 당신을 두고 "나만의"라고 쓰고싶어 한다는것을 알기에 당신은 그런사람이기에..', 3, 5);

select * from LINE_BOARD;


/*
 * 책리뷰 글등록
 */
insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(board_seq.nextval, 2, 'will0324@hanmail.net', sysdate, 0, 1, 0);
insert into book(book_no, book_title, book_intro, book_author, book_publ, book_sdate, book_edate, book_cate, book_img)
values(book_seq.nextval, '독후감 잘 쓰는 법', '히가시노 게이고의 소설 『가면산장 살인사건』. 저자와 독자가 아슬아슬한 두뇌 싸움을 벌이게 되는 이 작품은 외딴 산장에 모인 여덟 명의 남녀와 한밤중에 침입한 은행 강도범의 인질극을 그리고 있다. 잘 짜인 무대에서 벌어지는 연극과도 같은 이 소설은 그 누구도 상상조차 할 수 없었던 엄청난 반전을 담고 있다. 초대된 손님과 2인조 은행 강도 사이에 긴장과 서스펜스가 점차 고조되는 가운데 클라이맥스에 이르러 전개되는 대반전을 만나는 즐거움을 느낄 수 있다.', '이병승', '말푸름', '2011-04-02', '2015-07-03','4', 'https://search.pstatic.net/common/?src=http%3A%2F%2Fbookthumb.phinf.naver.net%2Fcover%2F082%2F730%2F08273055.jpg%3Ftype%3Dm1%26udate%3D20170914&type=o75_108_re24');
insert into review_board(board_no, review_title, review_content, star_point, genre, book_no)
values(board_seq.currval, '매력적인 제목, 인상적인 시작', '독후감을 심사할 때 중요하게 여기는 부분은 처음 시작 대목이다. 첫 부분이 어색하거나 밋밋하다면 한 수준 아래로 글을 평가한다. 심사해야 할 원고가 많으면 많을수록 첫 부분은 더욱 중요해진다. 
가장 재미없는 독후감 제목은 책 이름을 그대로 쓰는 경우다. 그보다 조금 나은 제목은 ‘~을 읽고’라는 제목이다. 그렇다면 최고 수준의 제목은 무엇일까. 가장 눈길을 끄는 제목은 자신이 생각하는 책에 대한 주제를 주제목으로 하고 부제목으로 ‘~을 읽고’라고 쓴 제목이다.
예를 들어 피노키오를 읽고 ‘인간이 되고픈 피노키오의 간절한 소망을 응원하며’ ‘인간으로 다시 탄생한 착한 목각 인형’ 등과 같이 주제목으로 결정할 수 있다. 그러나 제목은 글을 쓴 후 가장 나중에 붙여도 된다는 것을 명심하자. ',0,5, 6);


/*
 * 창작게시판 글등록
 */
insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(board_seq.nextval, 3, 'orangss@naver.com', sysdate, 0, 1, 0);
insert into create_board(board_no, create_title, create_content, category)
values(board_seq.currval, '창작의 시작', '창작한 내용', 4);
commit;


/*
 * 리플등록
 */
create sequence replyno_seq;
insert into reply(reply_no, reply_content, board_no, id)
values(replyno_seq.nextval, '1번게시글의 첫번째 덧글입니다.',  1, 'dnwjdrnl2@naver.com');

insert into reply(reply_no, reply_content, board_no, id)
values(replyno_seq.nextval, '2번게시글의 첫번째 덧글입니다.',  2, 'dnwjdrnl2@naver.com');

insert into reply(reply_no, reply_content, board_no, id)
values(replyno_seq.nextval, '1번게시글의 두번째 덧글입니다.',  1, 'orangss@naver.com');

insert into reply(reply_no, reply_content, board_no, id)
values(replyno_seq.nextval, '3번게시글의 첫번째 덧글입니다',  3, 'dnwjdrnl2@naver.com');

insert into reply(reply_no, reply_content, board_no, id)
values(replyno_seq.nextval, '1번게시글의 세번째 덧글입니다',  1, 'orangss@naver.com');

insert into reply(reply_no, reply_content, board_no, id)
values(replyno_seq.nextval, '7번게시글의 첫번째 덧글입니다',  7, 'kjhsc101218@naver.com');

insert into reply(reply_no, reply_content, board_no, id)
values(replyno_seq.nextval, '6번게시글의 첫번째 덧글입니다',  6, 'dnwjdrnl2@naver.com');

insert into reply(reply_no, reply_content, board_no, id)
values(replyno_seq.nextval, '3번게시글의 두번째 덧글입니다',  3, 'will0324@hanmail.net');

insert into reply(reply_no, reply_content, board_no, id)
values(replyno_seq.nextval, '4번게시글의 첫번째 덧글입니다',  4, 'ryuhyg@naver.com');

insert into reply(reply_no, reply_content, board_no, id)
values(replyno_seq.nextval, '5번게시글의 첫번째 덧글입니다',  5, 'will0324@hanmail.net');

insert into reply(reply_no, reply_content, board_no, id)
values(replyno_seq.nextval, '6번게시글의 두번째 덧글입니다',  6, 'ryuhyg@naver.com');
commit;



/*
 * 리리플등록
 */
create sequence rereplyno_seq;
insert into re_reply(re_reply_no, re_reply_content, reply_no, id)
values(rereplyno_seq.nextval, '리덧글 내용1', 1, 'orangss@naver.com');
insert into re_reply(re_reply_no, re_reply_content, reply_no, id)
values(rereplyno_seq.nextval, '리덧글 내용2', 2, 'ryuhyg@naver.com');
insert into re_reply(re_reply_no, re_reply_content, reply_no, id)
values(rereplyno_seq.nextval, '리덧글 내용3', 3, 'kjhsc101218@naver.com');
insert into re_reply(re_reply_no, re_reply_content, reply_no, id)
values(rereplyno_seq.nextval, '리덧글 내용4', 4, 'will0324@hanmail.net');
insert into re_reply(re_reply_no, re_reply_content, reply_no, id)
values(rereplyno_seq.nextval, '리덧글 내용5', 5, 'dnwjdrnl2@naver.com');
commit;



/*
 * 공감
 */
insert into sympathy(id, board_no)
values('kjhsc101218@naver.com',1);
insert into sympathy(id, board_no)
values('kjhsc101218@naver.com',2);
insert into sympathy(id, board_no)
values('kjhsc101218@naver.com',3);
insert into sympathy(id, board_no)
values('kjhsc101218@naver.com',7);
insert into sympathy(id, board_no)
values('orangss@naver.com',3);
insert into sympathy(id, board_no)
values('orangss@naver.com',4);
insert into sympathy(id, board_no)
values('orangss@naver.com',5);
insert into sympathy(id, board_no)
values('will0324@hanmail.net',1);
insert into sympathy(id, board_no)
values('will0324@hanmail.net',3);
insert into sympathy(id, board_no)
values('will0324@hanmail.net',5);
insert into sympathy(id, board_no)
values('will0324@hanmail.net',7);
insert into sympathy(id, board_no)
values('ryuhyg@naver.com',1);
insert into sympathy(id, board_no)
values('ryuhyg@naver.com',2);
insert into sympathy(id, board_no)
values('ryuhyg@naver.com',4);
insert into sympathy(id, board_no)
values('dnwjdrnl2@naver.com',6);
commit

/*
 * union
 */
select board_no, review_content from review_board
union ALL
select board_no, create_content from create_board
union ALL
select board_no, line_content from line_board
order by board_no desc


/*
 * 시퀀스삭제
 */
drop sequence tier_seq;
drop sequence tend_seq;
drop sequence boardtype_seq;
drop sequence category_seq;
drop sequence genre_seq;
drop sequence member_seq;
drop sequence question_seq;
drop sequence board_seq;
drop sequence background_seq;
drop sequence replyno_seq;
drop sequence rereplyno_seq;
drop sequence book_seq;