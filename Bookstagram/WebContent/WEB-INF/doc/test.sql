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




select s.id
from SYMPATHY;

select count(*)
from SYMPATHY
where board_no=4;

select board_no,count(*)
from SYMPATHY
group by board_no;

insert into sympathy(id, board_no)
values('a',13);
insert into sympathy(id, board_no)
values('b',13);
insert into sympathy(id, board_no)
values('c',13);

SELECT b.board_no as bno,m.nick as nick,b.board_regdate as regdate,b.hit as hit, cb.create_title as ctitle
FROM (SELECT row_number() over(order by board_no desc) as rnum,board_no,create_title
FROM CREATE_BOARD) cb,board b,member m
WHERE b.board_no=cb.board_no and b.id=m.id and rnum between 1 and 5  order by b.board_no desc


select a.bno,a.nick,a.regdate,a.hit,a.ctitle,s.count
from(
SELECT b.board_no as bno,m.nick as nick,b.board_regdate as regdate,b.hit as hit, cb.create_title as ctitle
FROM (SELECT row_number() over(order by board_no desc) as rnum,board_no,create_title
FROM CREATE_BOARD) cb,board b,member m
WHERE b.board_no=cb.board_no and b.id=m.id and rnum between 1 and 5  order by b.board_no desc)a,
(select board_no,count(*) as count from SYMPATHY group by board_no) s
where a.bno=s.board_no;
