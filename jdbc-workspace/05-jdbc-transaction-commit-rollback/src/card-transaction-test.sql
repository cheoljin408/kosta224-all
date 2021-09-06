create table card(
	id varchar2(100) primary key,
	name varchar2(100) not null
)

create table point(
	id varchar2(100) primary key,
	point_type varchar2(100) not null,
	point number not null
)

select * from card;
select * from point;

delete from card;
delete from point;

commit