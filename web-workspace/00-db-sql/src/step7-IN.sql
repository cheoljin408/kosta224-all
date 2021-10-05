/*
 	IN 연산자
 	특정 값이 포함되는 데이터를 조회하고자 할 때 사용하는 연산자
 	
 	select 컬럼, 컬럼
 	from 테이블명
 	where 컬럼 in('또래오래', '대한곱창');
 	
 	NOT IN 연산자
 	특정값이 포함되지 않은 데이터를 조회하고자 할 때
 	
 	또래오래와 대한곱창 제조사가 아닌 음식정보를 조회
 	select 컬럼, 컬럼
 	from 테이블명
 	where 컬럼 not in('또래오래', '대한곱창');
 */

-- maker가 대한곱창, 이춘복참치인 food 정보를 조회한다
select * from food where maker in ('대한곱창', '이춘복참치');
-- 위 sql을 아래와 같이 표현할 수 있다
select * from food where maker = '대한곱창' or maker = '이춘복참치';

-- maker가 대한곱창, 이춘복참치가 아닌 food 정보를 조회한다
select * from food where maker not in ('대한곱창', '이춘복참치');
-- 위 sql을 아래와 같이 표현할 수 있다
select * from food where maker<>'대한곱창' and maker<>'이춘복참치';


create table food(
	id number primary key,
	name varchar2(100) not null,
	maker varchar2(100) not null,
	price number not null
)

create sequence food_seq;

insert into food(id, name, maker, price) values(food_seq.nextval, '후라이드', '또래오래', 15000);
insert into food(id, name, maker, price) values(food_seq.nextval, '소곱창', '대한곱창', 20000);
insert into food(id, name, maker, price) values(food_seq.nextval, '양념치킨', '또래오래', 16000);
insert into food(id, name, maker, price) values(food_seq.nextval, '참치회', '이춘복참치', 35000);
insert into food(id, name, maker, price) values(food_seq.nextval, '파닭', '또래오래', 17000);
insert into food(id, name, maker, price) values(food_seq.nextval, '미니전골', '대한곱창', 18000);

commit

select count(*) from food;

-- 평균가 20167
select round(avg(price)) from food;

-- maker별 평균가, price 내침차순
select maker, round(avg(price)) as 평균가
from food
group by maker
order by 평균가 desc;

-- 전체 음식의 평균가보다 maker별 음식 평균가가 낮은 maker의 음식정보(name, price, maker)를 조회하고자 한다 (price 내림차순)

-- 강사님 sql
-- step1. 전체 음식 평균가
select avg(price) from food;
-- step2. maker별 음식 평균가
select avg(price) from food group by maker;
-- step3. 전체 음식의 평균가보다 maker별 음식 평균가가 낮은 maker를 조회
select maker
from food
group by maker
having avg(price) < (select avg(price) from food);
-- step4
select name, price, maker
from food
where maker in(
	select maker
	from food
	group by maker
	having avg(price) < (select avg(price) from food)
)
order by price desc;

-- 내 sql
/*
-- step1. 전체 음식의 평균가보다 maker별 음식 평균가가 낮은 maker를 조회
select maker
from food
group by maker
having round(avg(price)) < (select round(avg(price)) from food);

-- step2. result
select name, price, maker
from food
where maker in (select maker from food group by maker having round(avg(price)) < (select round(avg(price)) from food))
order by price desc;
*/
-----------------------------------------------------------------------------------

select * from s_employee;

-- job 별 사원수가 3명 이상인 job에 해당하는 사원의 name과 job을 조회

select job, count(*)
from s_employee
group by job;

-- step1. job별 사원수가 3명 이상인 job
select job
from s_employee
group by job
having count(*) >= 3
-- step2. job별 사원수가 3명 이상인 job에 해당하는 사원의 name과 job을 조회
select name, job
from s_employee
where job in (
	select job
	from s_employee
	group by job
	having count(job) >= 3
)

/*
	s_employee 테이블에 저장된 전체 사원 정보의 평균 월급(salary)보다
	직종별(job) 평균월급이 낮은 직종(job)에 해당하는 사원 정보를 조회
*/
-- 전체 사원 평균 월급액
select avg(salary)
from s_employee

select job
from s_employee
group by job
having avg(salary) < (
	select avg(salary)
	from s_employee
)

select *
from s_employee
where job in (
	select job
	from s_employee
	group by job
	having avg(salary) < (
		select avg(salary)
		from s_employee
	)
)
order by salary desc;