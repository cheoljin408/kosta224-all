create table bank (
	account number primary key,
	name varchar2(100) not null,
	password varchar2(100) not null,
	balance number not null
)

create sequence account_seq;

insert into bank(account, name, password, balance) values(account_seq.nextval, '김철진', '1234', 999999999999999);

select * from bank;

insert into bank(account, name, password, balance)
values(account_seq.nextval, '김진아', '1234', 1);

drop table bank;

drop sequence account_seq;


create table account(
	account_no number primary key,
	name varchar2(100) not null,
	password varchar2(100) not null,
	balance number not null
)
create sequence account_seq;

select * from account;
commit

-- sql 단위 테스트