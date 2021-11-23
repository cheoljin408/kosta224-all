select * from account;

drop table account;

create table account(
	id varchar2(100) primary key,
	name varchar2(100) not null,
	balance number not null
)

insert into account values('1', '아이유', 1000);
commit