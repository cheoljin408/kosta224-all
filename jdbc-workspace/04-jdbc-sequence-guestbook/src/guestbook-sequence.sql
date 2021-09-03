create table guestbook(
	guestbook_no number  primary key,
	title varchar2(100) not null,
	content varchar2(100) not null
)

create sequence guestbook_seq;

select * from guestbook;

insert into guestbook(guestbook_no, title, content) values(guestbook_seq.nextval, 'asd', 'zxc');

commit