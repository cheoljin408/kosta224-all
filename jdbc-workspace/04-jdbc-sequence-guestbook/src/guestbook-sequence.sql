create table guestbook(
	guestbook_no number  primary key,
	title varchar2(100) not null,
	content varchar2(100) not null
)

create sequence guestbook_seq;

select * from guestbook;

insert into guestbook(guestbook_no, title, content) values(guestbook_seq.nextval, 'asd', 'zxc');

commit

-- like 연산자를 이용해 title에 즐 문자열이 포함된 방명록 정보를 조회
select * from guestbook where title like '%즐%';

-- 위 like 적용 sql을 PreparedStatement에 적용하는 방법은 아래와 같다
/*
 * '%즐%' -> '%' || ? || '%'
 * String sql = "select * from guestbook where title like '%즐%'";
 */