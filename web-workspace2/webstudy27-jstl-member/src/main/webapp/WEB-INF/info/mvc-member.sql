select * from mvc_member;

drop table mvc_member

create table mvc_member(
	id varchar2(100) primary key,
	password varchar2(100) not null,
	name varchar2(100) not null,
	address varchar2(100) not null,
	birthday date not null,
	regdate date not null
)

insert into mvc_member(id, password, name, address, birthday, regdate)
values('java', 'a', '아이유', '오리', to_date('2001-10-21', 'yyyy-mm-dd'), sysdate)

insert into mvc_member(id, password, name, address, birthday, regdate)
values('java2', 'a', '강하늘', '오리', to_date('1993-10-22', 'yyyy-mm-dd'), sysdate)

insert into mvc_member(id, password, name, address, birthday, regdate)
values('java3', 'a', '이강인', '오리', to_date('2003-5-21', 'yyyy-mm-dd'), sysdate)

commit

select id, name, address, to_char(birthday, 'yyyy.mm.dd'), to_char(regdate, 'yyyy.mm.dd hh24:mm:ss')
from mvc_member
where id='java';

-- login sql: id와 password가 일치할 때만 조회된다
select name, address, to_char(birthday, 'yyyy.mm.dd')
from  mvc_member
where id='java' and password='a';

select * from mvc_member where address='오리';

update mvc_member set birthday=to_date('1994.12.26', 'yyyy-mm-dd') where id='java3';