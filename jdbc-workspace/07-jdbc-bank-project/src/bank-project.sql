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

-- 계좌 개설
insert into account(account_no, name, password, balance) values(account_seq.nextval, '아이유', '1234', 1000);

select * from account where account_no = 1;

-- 계좌번호 유무와 비밀번호 확인
select password from account where account_no = 11;

-- 출금
update account set balance = balance-50 where account_no = 1;

-- 계좌번호가 존재하는지 유무
select count(*) from account where account_no = 1;