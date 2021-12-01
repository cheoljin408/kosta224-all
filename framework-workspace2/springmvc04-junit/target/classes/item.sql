create table spring_item(
	item_no number primary key,
	name varchar2(100) not null,
	maker varchar2(100) not null,
	price number not null
)
create sequence spring_item_seq;
insert into spring_item values(spring_item_seq.nextval,'참이슬','진로',100);
insert into spring_item values(spring_item_seq.nextval,'처음처럼','롯데',200);
commit

select item_no,name,maker,price from spring_item
where item_no=1;

-- reg_date 컬럼 추가
alter table spring_item add reg_date date;

update spring_item set reg_date = sysdate

select item_no, name, maker, price, to_char(reg_date, 'yyyy-mm-dd hh24:mi:ss') as regDate from spring_item

-- reg_date 컬럼의 제약조건 추가
alter table spring_item modify reg_date not null;

select * from spring_item