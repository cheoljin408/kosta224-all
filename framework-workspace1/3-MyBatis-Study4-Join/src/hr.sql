drop table spring_department;
create table spring_department(
	deptno number primary key,
	dname varchar2(100) not null,
	loc varchar2(100) not null
)
create table spring_employment(
	empno number primary key,
	ename varchar2(100) not null,
	sal number not null,
	deptno number not null,
	constraint fk_spring_deptno foreign key(deptno) references spring_department(deptno)
)
-- 부서 테이블에는 40번 부서가 없으므로 error , 참조 무결성 제약조건 위배 
-- insert into spring_employment values(1,'아이유',300,40);
insert into spring_employment values(1,'아이유',300,10);
insert into spring_employment values(2,'조승우',500,10);
insert into spring_employment values(3,'배두나',400,20);

insert into spring_department values(10,'전략기획','판교');
insert into spring_department values(20,'해양수산','부산');
insert into spring_department values(30,'공공사업','판교');
commit
select * from spring_department;
select * from spring_employment;

-- JOIN SQL: 하나 이상의 테이블을 결합하여 조회
-- INNER JOIN: 조인 조건에 부합되는 정보를 조회
-- OUTER JOIN: 조인 조건에 부합되지 않는 정보까지 모두 조회
-- SELF JOIN: 하나의 테이블 자체에서 조인

select e.ename, d.dname, d.loc
from spring_employment e, spring_department d
where e.empno = 1 and e.deptno = d.deptno

-- findEmployeeAndDeptListOuterJoin
-- outer join
select e.empno, e.ename, d.deptno, d.dname
from spring_employment e, spring_department d
where e.deptno(+) = d.deptno
-- left outer join으로 표현
select e.empno, e.ename, d.deptno, d.dname
from spring_department d
left outer join spring_employment e
on e.deptno = d.deptno

-- getEmpGroupByDeptno
select count(*) as emp_count, deptno
from spring_employment
group by deptno

-- inline view를 이용해서 join -> 부서명을 조회
select d.deptno, d.dname, v.emp_count
from (
	select count(*) as emp_count, deptno
	from spring_employment
	group by deptno
) v, spring_department d
where v.deptno = d.deptno
order by v.deptno desc

-- 조회 결과가 null인 값을 다른 값으로 치환하는 함수 nvl(컬럼, 치환값)
select nvl(null, 0) from dual;

-- getEmpGroupByDeptnoOuterJoin
select d.deptno, d.dname, nvl(v.emp_count, 0) as emp_count
from (
	select count(*) as emp_count, deptno
	from spring_employment
	group by deptno
) v, spring_department d
where v.deptno(+) = d.deptno
order by v.deptno desc