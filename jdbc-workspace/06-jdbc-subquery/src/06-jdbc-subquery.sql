create table s_employee(
	empno number primary key,
	name varchar2(100) not null,
	job varchar2(100) not null,
	salary number not null
)

-- 시퀀스
create sequence s_employee_seq;

insert into s_employee(empno, name, job, salary) values(s_employee_seq.nextval, '아이유', '개발', 700);
insert into s_employee(empno, name, job, salary) values(s_employee_seq.nextval, '강하늘', '개발', 900);
insert into s_employee(empno, name, job, salary) values(s_employee_seq.nextval, '유재석', '총무', 600);
insert into s_employee(empno, name, job, salary) values(s_employee_seq.nextval, '박보검', '개발', 900);
insert into s_employee(empno, name, job, salary) values(s_employee_seq.nextval, '이상순', '총무', 600);

commit

select * from S_EMPLOYEE;

select * from S_EMPLOYEE where job = '개발'

select * from (select * from S_EMPLOYEE where job = '개발') where salary = (select max(salary) from (select * from S_EMPLOYEE where job = '개발'));

-- job에 해당하는 사원의 가장 높은 salary를 조회
select max(salary) from s_employee where job = '개발';
-- 위 sql에서 조회된 salary를 받는 사원 정보(job에 해당하는 사원에 한해)
select empno, name, job, salary
from s_employee
where job = '개발' and salary=(select max(salary) from s_employee where job = '개발');