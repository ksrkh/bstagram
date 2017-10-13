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

Update MEMBER set tier=0 where id=?;





			
			