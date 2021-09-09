/*
	group by ~ having
	
	group by: 테이블에서 특정 컬럼을 기준으로 그룹화하여 검색할 때 사용
			  데이터를 원하는 그룹을 나눌 수 있다
	having: group by와 함께 사용하는 조건절(그룹에 대한 조건을 지정)
	
	예) 상품 테이블에서 제조사별 상품 수, 평균가
	    사원 테이블에서 부서별 사원수, 평균 월금
*/

select * from product;

-- maker별 상품수 조회
select maker, count(*) as 상품수
from product
group by maker
order by 상품수 desc;

-- maker별 상품수 조회하되 상품수가 1개를 초과하는 maker(그룹)들만 조회(group by ~ having)
select maker, count(*) as 상품수
from product
group by maker
having count(*) > 1
order by 상품수 desc;

-- maker별 상품 평균가(avg())를 조회하되 평균가 내림차순으로 정렬(maker, 평균가 가 조회)
select maker, round(avg(price)) as 평균가
from PRODUCT
group by maker
order by 평균가 desc;

-- maker별 상품 평균가(소수점 이하 반올림)가 1540원을 초과하는 제조사 maker를 조회하되
-- maker별 상품수, 평균가를 조회한다(maker, 상품수, 평균가)
-- 상품수 오름차순으로 조회
select maker, count(*) as 상품수, round(avg(price)) as 평균가
from product
group by maker
having round(avg(price)) > 1540
order by 상품수;

select * from S_EMPLOYEE;

-- job 별 사원수(job, 사원수)를 조회하되 사원수 내림차순 정렬
select job, count(*) as 사원수
from S_EMPLOYEE
group by job
order by 사원수;

-- job 별 평균 월급(avg(salary))을 조회하되 평균월급 내림차순으로 정렬
-- 평균월급이 700을 초과하는 job에 한해서 조회한다
select job, round(avg(salary)) as 평균월급
from s_employee
group by job
having round(avg(salary)) > 700
order by 평균월급 desc;

-- s_employee의 job별 사원수, 최고 salary를 조회(최고 salary 내림차순)
select job, count(*), max(salary) as highestsal
from s_employee
group by job
order by highestsal desc;

-- 전체 사원의 평균월급보다 job 그룹별 평균 월급액이 작은 job 그룹의 job, 평균월급, 사원수를 조회
select avg(salary) from S_EMPLOYEE;
-- 영업 600
select avg(salary) from S_EMPLOYEE where job = '영업';
-- 개발 833.33..
select avg(salary) from S_EMPLOYEE where job = '개발';
-- 총무 720
select avg(salary) from S_EMPLOYEE where job = '총무';

select job, avg(salary) as 평균월급
from S_EMPLOYEE
group by job
having avg(salary) < (select avg(salary) from S_EMPLOYEE)
order by 평균월급 desc;

-- 전체 product의 평균가보다 그룹(maker)별 평균가가 낮은 그룹(maker)의 maker명과 상품 평균가를 조회(내림차순)
select avg(price) from PRODUCT;

select maker, round(avg(price)) as avgprice
from product
group by maker
having avg(price) < (select avg(price) from PRODUCT)
order by avgprice desc;