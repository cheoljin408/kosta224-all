/* 

오라클 시퀀스(sequence)
: 순차적으로 증가, 유일한 값을 생성하기 위한 객체 
주로 primary key ( unique + not null ) 를 생성하기 위해 사용
테이블과는 독립적 구조 

CREATE SEQUENCE 시퀀스명 
[START WITH 시작번호]
[INCREMENT BY 증가값]
[MAXVALUE 최대값] 
[MINVALUE 최소값]
[ CYCLE or NOCYCLE ] 
[ NOCACHE ] 

Oracle dual table 
: 오라클에서 제공하는 기본 테이블 
컬럼 하나만 존재 , 주로 시퀀스 또는 날짜함수, 산술연산에 사용
sys Admin 계정에서 관리하고 수정 및 삭제 등 조작은 불가 

*/
-- 시퀀스 생성: 시퀀스명 test_seq
create sequence test_seq;

-- 오라클에서 제공하는 dual 테이블을 조회
select * from dual;
-- 연산시 사용
select 2*5 from dual;
-- 현재 시간 sysdate
select sysdate from dual;
-- dual table을 이용해 시퀀스 값을 확인
-- 시퀀스명.nextval -> 시퀀스 다음 값을 생성
select test_seq.nextval from dual;
-- 시퀀스 삭제
drop sequence test_seq;

-- drop한 test_seq 시퀀스 명으로 다시 시퀀스를 생성해본다 (옵션을 start with 7 적용해서 생성)
create sequence test_seq start with 7;

-- car table을 생성해서 sequence를 이용해본다
create table car(
	car_no number primary key,
	model varchar2(100) not null
)

-- car_seq sequence를 생성한다
create sequence car_seq;

-- insert 시에 sequence를 이용해서 car_no를 등록한다
insert into car(car_no, model) values(car_seq.nextval, '테슬라');
insert into car(car_no, model) values(car_seq.nextval, '아이오닉');
select * from car;

-- guestbook table에 sequence를 이용
create table guestbook(
	guestbook_no number  primary key,
	title varchar2(100) not null,
	content varchar2(100) not null
)

create sequence guestbook_seq;