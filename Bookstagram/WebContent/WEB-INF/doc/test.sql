select * from member where id='a' and pw='1'

SELECT b.board_no,b.id,c.create_title,b.board_regdate,b.hit
FROM( 
SELECT row_number() over(order by board_no desc) as rnum,board_no,id,to_char(board_regdate,'YYYY.MM.DD') as board_regdate,hit
FROM BOARD) b,CREATE_BOARD c where b.board_no=c.board_no and rnum between ? and ? and b.id=?
order by board_no desc
			
insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(7, 3, 'orangss@naver.com', sysdate, 0, 1, 0);
insert into create_board(board_no, create_title, create_content, category)
values(7, '창작의 시작', '창작한 내용', 4);

delete from create_board where category=4;
delete from board where id='orangss@naver.com' and boardtype_no=3;
delete from REPLY where board_no=7;
delete from sympathy where board_no=7;

select * from CREATE_BOARD;
select * from BOARD;

insert into reply(reply_no, reply_content, board_no, id)
values(replyno_seq.nextval, '7번게시글의 첫번째 덧글입니다',  7, 'kjhsc101218@naver.com');
insert into sympathy(id, board_no)
values('kjhsc101218@naver.com',7);

insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(8, 3, 'dnwjdrnl2@naver.com', sysdate, 0, 1, 0);
insert into create_board(board_no, create_title, create_content, category)
values(8, '창작의 시작2', '창작한 내용2', 4);

insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(9, 3, 'dnwjdrnl2@naver.com', sysdate, 0, 1, 0);
insert into create_board(board_no, create_title, create_content, category)
values(9, '창작의 시작3', '창작한 내용3', 4);

insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(10, 3, 'dnwjdrnl2@naver.com', sysdate, 0, 1, 0);
insert into create_board(board_no, create_title, create_content, category)
values(10, '창작의 시작4', '창작한 내용4', 4);

insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(11, 3, 'dnwjdrnl2@naver.com', sysdate, 0, 1, 0);
insert into create_board(board_no, create_title, create_content, category)
values(11, '창작의 시작5', '창작한 내용5', 4);

insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(12, 3, 'dnwjdrnl2@naver.com', sysdate, 0, 1, 0);
insert into create_board(board_no, create_title, create_content, category)
values(12, '창작의 시작6', '창작한 내용6', 4);

insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(13, 3, 'dnwjdrnl2@naver.com', sysdate, 0, 1, 0);
insert into create_board(board_no, create_title, create_content, category)
values(13, '창작의 시작7', '창작한 내용7', 4);

commit;


SELECT b.rnum,b.board_no,b.id,c.create_title,b.board_regdate,b.hit
FROM( 
SELECT row_number() over(order by board_no desc) as rnum,board_no,id,to_char(board_regdate,'YYYY.MM.DD') as board_regdate,hit
FROM BOARD where id='dnwjdrnl2@naver.com') b,CREATE_BOARD c 
where b.board_no=c.board_no and b.id='dnwjdrnl2@naver.com'
order by board_no desc;


SELECT b.rnum,b.board_no,b.id,l.line_content,b.board_regdate,b.hit 
FROM(SELECT row_number() over(order by board_no desc) as rnum,board_no,id,to_char(board_regdate,'YYYY.MM.DD') as board_regdate,hit 
FROM BOARD where id='kjhsc101218@naver.com') b,LINE_BOARD l 
where b.board_no=l.board_no and rnum between 1 and 3 
order by board_no desc;
			
SELECT row_number() over(order by board_no desc) as rnum,board_no,id,to_char(board_regdate,'YYYY.MM.DD') as board_regdate,hit 
FROM BOARD where id='dnwjdrnl2@naver.com';
		
select * from MEMBER;
select * from MEMBER_TIER;

Update MEMBER set tier=3 where id='a';
Update MEMBER set tier=3 where id='b';

insert into member(id, pw,nick,age,regdate,m_photo,temp,tend_code,tend_code2,tend_code3,tier,question_code,pw_ans)
values('a','1','dnwjd',26,sysdate,null,null,0,0,0,3,3,'황운');
insert into member(id, pw,nick,age,regdate,m_photo,temp,tend_code,tend_code2,tend_code3,tier,question_code,pw_ans)
values('b','1','dnwjd',26,sysdate,null,null,0,0,0,3,3,'황운');
select * from Member;

Update Member
set pw=2, nick='c'
where id='a';

select m.id, t.tend_name
from member m, tend t
where m.tend_code = t.tend_code;


select m.id, t.tend_name
from member m, tend t
where m.tend_code2 = t.tend_code;

select *
from tend;

select A.id,A.tend_name,B.tend_name2
from (select m.id as id, t.tend_name as tend_name
from member m, tend t
where m.tend_code2 = t.tend_code) A,
(select m.id as id, t.tend_name as tend_name2
from member m, tend t
where m.tend_code2 = t.tend_code) B
where A.id=B.id;

select a.id,t.tend_name
from
(select id,tend_code,tend_code2,tend_code3
from MEMBER) a, tend t
where a.tend_code=t.tend_code or

			
SELECT b.board_no,b.id,c.create_title,b.board_regdate,b.hit 
FROM( SELECT row_number() over(order by board_no desc) as rnum,board_no,id,
to_char(board_regdate,'YYYY.MM.DD') as board_regdate,hit
FROM BOARD WHERE id=?) b,CREATE_BOARD c where b.board_no=c.board_no and rnum between ? and ?
order by board_no desc


select *
from MEMBER_TIER;

SELECT C.id, C.pw, C.age, C.regdate, C.tier, C.tend_name, C.tend_name2, D.tend_name AS tend_name3
FROM
(SELECT A.id, A.pw, A.age, A.regdate, A.tier, A.tend_name, B.tend_name AS tend_name2
FROM
(SELECT m.id, m.pw, m.age, m.regdate, m.tier, t.tend_name
FROM member m, tend t
WHERE m.tend_code = t.tend_code) A,
(SELECT m.id, t.tend_name
FROM member m, tend t
WHERE m.tend_code2 = t.tend_code) B
WHERE A.id = B.id) C,
(SELECT m.id, t.tend_name
FROM member m, tend t
WHERE m.tend_code3 = t.tend_code) D
WHERE C.id = D.id

insert into re_reply(re_reply_no, re_reply_content, reply_no, id)
values(rereplyno_seq.nextval, '리덧글 내용1', 5, 'b');

insert into re_reply(re_reply_no, re_reply_content, reply_no, id)
values(rereplyno_seq.nextval, '리덧글 내용2', 5, 'b');

insert into re_reply(re_reply_no, re_reply_content, reply_no, id)
values(rereplyno_seq.nextval, '리덧글 내용3', 5, 'b');

insert into re_reply(re_reply_no, re_reply_content, reply_no, id)
values(rereplyno_seq.nextval, '리덧글 내용4', 5, 'b');

insert into re_reply(re_reply_no, re_reply_content, reply_no, id)
values(rereplyno_seq.nextval, '리덧글 내용1', 6, 'b');

insert into re_reply(re_reply_no, re_reply_content, reply_no, id)
values(rereplyno_seq.nextval, '리덧글 내용2', 6, 'b');

delete from RE_REPLY
where reply_no=6;

delete from REPLY
where reply_no=6;


select *
from REPLY;

select *
from RE_REPLY;


insert into reply(reply_no, reply_content, board_no, id)
values(replyno_seq.nextval, '1번게시글의 첫번째 덧글입니다.',  1, 'dnwjdrnl2@naver.com');

select reply_no,reply_content,board_no,id from REPLY where board_no=1;

insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(board_seq.nextval, 1, 'kjhsc101218@naver.com', sysdate, 0, 1, 0);

insert into book(book_no, book_title, book_intro, book_author, book_publ, book_sdate, book_edate, book_cate, book_img)
values(book_seq.nextval, '언어의온도', '『언어의 온도』의 저자 이기주는 엿듣고 기록하는 일을 즐겨 하는 사람이다. 그는 버스나 지하철에 몸을 실으면 몹쓸 버릇이 발동한다고 고백한다. 이 책은 저자가 일상에서 발견한 의미 있는 말과 글, 단어의 어원과 유래, 그런 언어가 지닌 소중함과 절실함을 농밀하게 담아낸 것이다.','이기주', '말푸름', '2016-02-03', '2016-02-05','1', 'https://search.pstatic.net/common/?src=http%3A%2F%2Fbookthumb.phinf.naver.net%2Fcover%2F109%2F245%2F10924505.jpg%3Ftype%3Dm1%26udate%3D20171007&type=o75_108_re24');

insert into line_board(board_no, line_content, tend_code, book_no)
values(board_seq.currval, '화장실을 깨끗하게 사용해주세요. 이곳을 청소해주시는 분들, 누군가에겐 전부인 사람들입니다.', 8, 1);

insert into board(board_no, boardtype_no, id, board_regdate, hit, authority, bg_no)
values(board_seq.nextval, 1, 'a', sysdate, 0, 1, 0);
insert into line_board(board_no, line_content, tend_code, book_no)
values(board_seq.currval,  ' 이 책은 저자가 일상에서 발견한 의미 있는 말과', 8, 1);

insert into line_board(board_no, line_content, tend_code, book_no)
values(board_seq.currval, '누군가에겐 전부인 사람들입니다.', 8, 1);

insert into sympathy(id, board_no) values('a',28);
insert into sympathy(id, board_no) values('b',28);
insert into sympathy(id, board_no) values('c',27);


select * from LINE_BOARD;


select *
from BOARD
where boardtype_no=1;

delete from sympathy
where board_no=13;

select *
from SYMPATHY;

select count(*)
from SYMPATHY
where board_no=4;

select board_no,count(*)
from SYMPATHY
group by board_no;

SELECT br.board_no, br.boardtype_no, m.id, m.nick,
br.board_regdate, br.hit, br.authority, br.bg_no, lb.line_content, lb.tend_code, lb.book_no FROM
(SELECT row_number() over(order by board_no desc) as rnum,board_no,line_content,tend_code,book_no 
FROM line_board) lb, board br, member m 
WHERE br.board_no=lb.board_no and br.id=m.id and rnum between 1 and 5  order by br.board_no desc
		


select B.board_no,count
from(select row_number() over(order by board_no desc) as rnum,board_no,count(*) as count
from SYMPATHY
group by board_no) B
where B.rnum between 1 and 5;





SELECT b.board_no as bno,m.nick as nick,b.board_regdate as regdate,b.hit as hit, cb.create_title as ctitle
FROM (SELECT row_number() over(order by board_no desc) as rnum,board_no,create_title
FROM CREATE_BOARD) cb,board b,member m
WHERE b.board_no=cb.board_no and b.id=m.id and rnum between 1 and 5  order by b.board_no desc



select *
from SYMPATHY
where board_no=13 and id='c';

insert into sympathy(id, board_no)
values('a',13);

delete from SYMPATHY
where id='a' and board_no=13;

insert into sympathy(id, board_no)
values('a',13);
insert into sympathy(id, board_no)
values('b',13);
insert into sympathy(id, board_no)
values('c',13);



select a.bno,a.nick,a.regdate,a.hit,a.ctitle,s.count
from(
SELECT b.board_no as bno,m.nick as nick,b.board_regdate as regdate,b.hit as hit, cb.create_title as ctitle
FROM (SELECT row_number() over(order by board_no desc) as rnum,board_no,create_title
FROM CREATE_BOARD) cb,board b,member m
WHERE b.board_no=cb.board_no and b.id=m.id and rnum between 1 and 5  order by b.board_no desc)a,
(select board_no,count(*) as count from SYMPATHY group by board_no) s
where a.bno=s.board_no;

insert into member(id, pw,nick,age,regdate,m_photo,temp,tend_code,tend_code2,tend_code3,tier,question_code,pw_ans)
values('c','1','hsc',26,sysdate,null,null,0,0,0,3,3,'황운');
insert into member(id, pw,nick,age,regdate,m_photo,temp,tend_code,tend_code2,tend_code3,tier,question_code,pw_ans)
values('d','1','hsc',26,sysdate,null,null,0,0,0,3,3,'황운');
insert into member(id, pw,nick,age,regdate,m_photo,temp,tend_code,tend_code2,tend_code3,tier,question_code,pw_ans)
values('e','1','hsc',26,sysdate,null,null,0,0,0,3,3,'황운');


select *
from board;

select *
from reply;

select *
from member;

Update board set hit=0 where board_no=13;

SELECT b.board_no as bno,m.nick as nick,b.board_regdate as regdate,b.hit as hit, cb.create_title as ctitle
FROM (SELECT row_number() over(order by board_no desc) as rnum,board_no,create_title
FROM CREATE_BOARD) cb,board b,member m25
WHERE b.board_no=cb.board_no and b.id=m.id and rnum between 1 and 5  order by b.board_no desc




select row_number() over(order by D.board_no desc) as rnum, D.board_no
from(SELECT C.board_no , C.boardtype_no, bt.boardtype_name, C.id, C.content, C.board_regdate, C.hit
FROM (SELECT B.board_no, B.id, substr(A.review_content,1,40) AS content, B.board_regdate, B.hit, B.boardtype_no
FROM (SELECT board_no, review_content FROM review_board 
UNION ALL SELECT board_no, create_content FROM create_board
UNION ALL SELECT board_no, line_content FROM line_board) A, 
board B WHERE A.board_no = B.board_no) C, board_type bt
WHERE bt.boardtype_no = C.boardtype_no ORDER BY C.board_no DESC) D
where rnum between 1 and 5;

select D.rnum,D.board_no
from(SELECT row_number() over(order by C.board_no desc) as rnum ,C.board_no , C.boardtype_no, bt.boardtype_name, C.id, C.content, C.board_regdate, C.hit
FROM (SELECT B.board_no, B.id, substr(A.review_content,1,40) AS content, B.board_regdate, B.hit, B.boardtype_no
FROM (SELECT board_no, review_content FROM review_board 
UNION ALL SELECT board_no, create_content FROM create_board
UNION ALL SELECT board_no, line_content FROM line_board) A, 
board B WHERE A.board_no = B.board_no) C, board_type bt
WHERE bt.boardtype_no = C.boardtype_no ORDER BY C.board_no DESC) D
where D.rnum between 1 and 5;

select *
from(select row_number() over(order by m.regdate desc) as rnum, m.id, m.pw, m.age, m.tend_name, m.tend_name2, m.tend_name3, mt.tier_name, m.regdate
FROM (SELECT C.id, C.pw, C.age, C.regdate, C.tier, C.tend_name, C.tend_name2, D.tend_name AS tend_name3 
FROM (SELECT A.id, A.pw, A.age, A.regdate, A.tier, A.tend_name, B.tend_name AS tend_name2
FROM (SELECT m.id, m.pw, m.age, m.regdate, m.tier, t.tend_name FROM member m, tend t WHERE m.tend_code = t.tend_code) A, 
(SELECT m.id, t.tend_name FROM member m, tend t WHERE m.tend_code2 = t.tend_code) B  WHERE A.id = B.id) C, 
(SELECT m.id, t.tend_name FROM member m, tend t WHERE m.tend_code3 = t.tend_code) D WHERE C.id = D.id) m , MEMBER_TIER mt 
WHERE m.tier=mt.tier) D
where D.rnum between 1 and 5;

order by m.regdate desc


