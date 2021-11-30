/*
	DATE 타입: 데이터베이스 시간(년, 월, 일, 시, 분, 초)를 관리하는 타입
	주요 함수
	1. to_char(): 데이터베이스에 저장된 DATE형의 정보를 문자열로 반환받을 때 사용하는 함수
	2. to_date(): 문자타입의 시간 정보를 데이터베이스의 DATE 형으로 변환해 저장할 때 사용하는 함수
	
	SYSDATE 예약어: 현재 시간을 표현하는 키워드
	
	참고) Oracle DUAL 테이블: 오라클에서 제공하는 기본 테이블, 함수 및 키워드를 실행할 때 사용
*/

select sysdate from dual;

-- to-char()를 이용해 원하는 시간 포맷을 설정해 문자열로 반환받아 본다
select to_char(sysdate, 'yyyy-mm-dd') from dual;
select to_char(sysdate, 'yyyy. mm. dd') from dual;
select to_char(sysdate, 'yyyy') from dual;
select to_char(sysdate, 'mm') from dual;
select to_char(sysdate, 'dd') from dual;

select to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss') from dual;
select to_char(sysdate, 'yyyy-mm-dd hh:mi:ss') from dual;

-- day는 요일
select to_char(sysdate, 'day') from dual;

-- 테이블 생성해서 테스트
create table date_test(
	id varchar2(100) primary key,
	mydate date not null
)
insert into date_test(id, mydate) values('java', sysdate);

select * from date_test;

-- mydate를 년 월 일 로만 조회
select id, to_char(mydate, 'yyyy.mm.dd') from date_test;

-- 어플리케이션에서 문자열 정보로 년, 월, 일, 로 정보를 받아와 db에 정보를 insert
-- to_date(시간정보, 시간포맷)
insert into date_test(id, mydate) values('jsp', to_date('2019.2.2', 'yyyy.mm.dd'));
insert into date_test(id, mydate) values('DBCP', to_date('2021.8.2', 'yyyy.mm.dd'));

-- date 연산
-- 하루 전
select id, mydate, mydate-1 from date_test;
-- 몇일이 경과했는 지 조회(현재시간과 저장 시간의 일수를 확인)
select id, mydate, sysdate-mydate from date_test;
-- 소수점 이하는 제외 trunc()을 이용
select id, mydate, trunc(sysdate-mydate) from date_test;
-- 몇개월 경과 months_between(현재시간, 등록시간)
select id, mydate, trunc(months_between(sysdate, mydate)) from date_test;
-- 몇년 경과
select id, mydate, trunc(months_between(sysdate, mydate)/12) from date_test;