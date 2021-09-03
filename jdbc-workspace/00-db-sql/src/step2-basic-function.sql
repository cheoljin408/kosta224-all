/*
	SQL: 데이터베이스를 정의 조작 제어하는 언어
	1. DDL 데이터 정의어 - CREATE, DROP, ALTER
	2. DML 데이터 조작어 - INSERT, SELECT, UPDATE, DELETE (CRUD)
	3. DCL 데이터 제어어 - COMMIT, ROLLBACK
	
	DATA TYPE: 문자열 - 오라클에서 권장하는 문자열 타입 VARCHAR2(10)
		   	   정수, 실수
		   	   
*/

-- DDL: CREATE 테이블 생성
CREATE TABLE TYPETEST (
	NAME VARCHAR2(9) PRIMARY KEY,
	MONEY NUMBER NOT NULL
)

-- DML: INSERT
-- ERROR: NAME의 최대 사이즈가 9, 아래는 10이므로 ERROR
INSERT INTO TYPETEST(NAME, MONEY) VALUES ('abcdefghij', 100);
INSERT INTO TYPETEST(NAME, MONEY) VALUES ('abcdefghi', 100);
-- 한글은 3BYTE를 차지, 아래는 12BYTE 이므로 ERROR
INSERT INTO TYPETEST(NAME, MONEY) VALUES ('아이유님', 100);
INSERT INTO TYPETEST(NAME, MONEY) VALUES ('아이유', 100);

-- DML: SELECT
SELECT NAME, MONEY FROM TYPETEST;

-- DML: UPDATE
-- NAME이 아이유인 대상의 MONEY를 +200 해본다
UPDATE TYPETEST SET MONEY=MONEY+200 WHERE NAME='아이유';

-- DDL: DROP - 테이블 삭제
DROP TABLE TYPETEST;

-- DDL: ALTER - 테이블 정보를 변경(TABLE명 변경, COLUMN명 변경, 제약조건 및 타입변경 등)
CREATE TABLE ALTERTEST(
	ID VARCHAR2(100) PRIMARY KEY,
	HIT NUMBER DEFAULT 0
)
-- DEFAULT 제약조건: 별도로 INSERT 하지 않으면 0으로 초기값이 저장
-- DML: INSERT

INSERT INTO ALTERTEST(ID) VALUES ('java');
SELECT ID, HIT FROM ALTERTEST;

-- DDL: ALTER를 이용해서 테이블 명을 ALTERTEST2로 변경해본다
ALTER TABLE ALTERTEST RENAME TO ALTERTEST2;
SELECT ID, HIT FROM ALTERTEST2;

-- 테이블 확인
SELECT * FROM USER_OBJECTS WHERE OBJECT_TYPE='TABLE';

-- DDL: ALTER를 이용해서 컬럼명을 HIT에서 COUNT로 변경해본다
ALTER TABLE ALTERTEST2 RENAME COLUMN HIT TO COUNT;
SELECT * FROM ALTERTEST2;

/*
	테이블명: product
	컬럼명: id, name, maker, price
	데이터타입: id, price는 number
			 name, maker는 varchar2(100)
	제약조건: id는 primary key
		   name, maker는 not null
		   price는 default 0
*/
create table product (
	id number primary key,
	name varchar2(100) not null,
	maker varchar2(100) not null,
	price number default 0
)

-- DML: INSERT
insert into product values(1, '불닭볶음면', '삼양', '1500');
insert into product values(2, '진라면', '오뚜기', '1100');
insert into product values(3, '테라', '하이트진로', '1800');
insert into product values(4, '참이슬후레쉬', '하이트진로', '1300');

-- DCL
commit

-- DML: SELECT
select * from product;

-- 데이터베이스 함수 테스트
-- COUNT(*)
select count(*) from product;
select count(*) from member;

-- 상품 죄저가
select min(price) from product;
-- 상품 최고가
select max(price) from product;
-- 상품 평균가
select avg(price) from product;
-- 상품 평균가 반올림
select round(avg(price)) from product;

-- 정렬: 오름차순, 내림차순
-- price 오름차순 정렬
-- order by만 명시하면 기본 오름차순 정렬
select name, price from product order by price;
select name, price from product order by price asc;
-- price 내림차순 정렬
select name, price from product order by price desc;

/*
 	select
 	from
 	where
 	order by
 */
-- maker가 하이트진로인 상품의 id, name, price를 조회하되
-- price 내림차순으로 정렬하세요
select id, name, price from product where maker='하이트진로' order by price desc;

select * from product;

-- price가 1300이상, 2000이하인 상품의 name과 price를 조회(price 오름차순)
select name, price
from product
where price>=1300 and price<=2000
order by price asc;

-- between and로 위의 sql을 표현할 수 있다
select name, price
from product
where price between 1300 and 2000
order by price asc;

-- primary key로 검색해서 상품 존재 유무 확인
select count(*) from product where id=1;
select count(*) from product where id=7;

-- 컬럼 병칭
select min(price) as 최저가 from product;

-- maker 조회
select maker from product;

-- maker 종류를 조회
select distinct maker from product;