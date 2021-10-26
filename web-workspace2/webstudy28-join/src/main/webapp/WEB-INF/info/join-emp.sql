/*
	부서테이블과 사원테이블을 분리
	부서테이블: 부모테이블, 참조 대상이 되는 테이블
	사원테이블: 자식 테이블, 참조하는 테이블
	
	부서테이블 ------0|< 사원테이블
	
	사원테이블에서 부서테이블을 참조할 수 있도록 Foreign key 설정해서
	사원정보가 저장될 때 부서테이블에 존재하는 부서번호로만 등록할 수 있도록 한다 (참조 무결성)
*/

create table mvc_department(
	deptno number primary key,
	dname varchar2(100) not null,
	loc varchar2(100) not null,
	tel varchar2(100) not null
);

insert into MVC_DEPARTMENT(deptno, dname, loc, tel) values(10, '전략기획', '오리', '031');
insert into MVC_DEPARTMENT(deptno, dname, loc, tel) values(20, '공공사업', '종로', '02');
insert into MVC_DEPARTMENT(deptno, dname, loc, tel) values(30, '연구개발', '판교', '033');

select * from MVC_DEPARTMENT;

create table mvc_employee(
	empno number primary key,
	ename varchar2(100) not null,
	sal number not null,
	deptno number not null,
	constraint fk_mvc_deptno foreign key(deptno) references mvc_department(deptno)
)
/*
	constraint(제약조건키워드)
	fk_mvc_deptno(제약조건명:유일해야함)
	foreign key(현 테이블 컬럼)
	references 참조대상 테이블 or 부모 테이블(참조할 컬럼)
 */

-- error: parent key not found 참조 무결성 제약조건 위배(부서테이블에 존재하지 않는 부서번호로 insert)
insert into mvc_employee(empno, ename, sal, deptno) values(1, '아이유', 400, 50);
-- 부서 테이블에 존재하는 부서번호로 등록했으므로 정상 수행
insert into mvc_employee(empno, ename, sal, deptno) values(1, '아이유', 400, 10);
insert into mvc_employee(empno, ename, sal, deptno) values(2, '박보검', 300, 10);
insert into mvc_employee(empno, ename, sal, deptno) values(3, '강하늘', 600, 20);


-- 전체 사원수 3명
select count(*) from mvc_employee;

commit

select e.empno, e.ename, e.sal, d.dname, d.loc
from mvc_employee e, mvc_department d
where e.deptno = d.deptno
order by e.empno desc;