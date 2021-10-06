create table web_product(
	id number primary key,
	name varchar2(100) not null,
	maker varchar2(100) not null,
	price number not null
)

create sequence web_product_seq;

insert into web_product(id, name, maker, price) values(web_product_seq.nextval, '카스', '두산', 1500);
insert into web_product(id, name, maker, price) values(web_product_seq.nextval, '테라', '진로', 1700);
insert into web_product(id, name, maker, price) values(web_product_seq.nextval, '참이슬', '진로', 1300);

commit

select * from web_product;