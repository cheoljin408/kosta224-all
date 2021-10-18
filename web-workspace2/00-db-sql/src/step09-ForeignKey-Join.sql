/*
	Foreign Key 제약조건과 Join SQL
	
	- ERD(Entity Relationship Diagram): 관계형 데이터베이스 설계를 위한 다이어그램
	
	- 정규화(Normalization): 데이터베이스 설계시 중복을 최소화하고 무결성을 보장하기 위해 데이터를 구조화하는 작업
						   (1, 2, 3 정규화) -> 이후 공부 예정
						   
	- Foreign key 제약조건: 참조 무결성 보장을 위한 제약조건, 다른 테이블의 정보를 참조할 때 지정해야하는 제약조건
						  ex) 부모 테이블: 부서
						  	  자식 테이블: 사원의 컬럼 부서번호에 FK 제약조건을 지정, 부모인 부서테이블의 PK를 참조
						  	  
						  	  사원 정보가 사원 테이블에 저장되기 위해서는 반드시 부서 테이블에 저장되어 있는 부서번호로만
						  	  사원의 부서 번호 정보로 저장될 수 있다
						  	  부서 테이블에 존재하지 않는 부서 번호로 사원 테이블에 사원 정보의 부서번호로 저장될 수 없다
						  	  
	- Join SQL: 여러 테이블 간의 정보를 결합하기 위한 SQL(기본적인 Join SQL연습하고 상세한 것은 이후 공부 예정)
						   
	사원번호, 사원명, 직종, 월급, 부서명, 부서근무지, 부서대표전화번호...
	
	실제 데이터
	1	아이유   개발직   500   연구개발부   판교   031...
	2	박보검   개발직   700   공공사업부   종로   02...		
	
	위와 같은 형태로 테이블을 설계해서 운영하면 부서정보들이 중복, 반복적으로 저장
	부서정보가 업데이트 되어야 한다면 사원수만큼의 다수의 데이터가 변경되어야 한다
	정규화를 거치면 아래와 같이 테이블을 분히라여 관계성(1 대 다)를 가지면 된다
	
	부서 테이블 |-----0|< 사원테이블
	
	부서는 사원을 0 or 1 or 다수를 가질 수 있다
	사원은 반드시 하나의 부서에 속해 있다
	
	이렇게 테이블을 분히라여 관리할 때는 참조 무결성 보장을 위해 제약조건 Foreign key를 지정해야 한다
*/

-- 테이블 생성 순서는 부모 테이블(참조대상 테이블)부터 사직 테이블(참조하는 테이블) 순으로 생성한다
create table department(
	deptno number primary key,
	dname varchar2(100) not null,
	loc varchar2(100) not null,
	tel varchar2(100) not null
)

create table k_employee(
	empno number primary key,
	ename varchar2(100) not null,
	sal number not null,
	deptno number not null,
	constraint fk_deptno foreign key(deptno) references department(deptno)
)

-- foreign key: constraint 제약조건명 foreign key(컬럼명) references 참조테이블명(컬럼명)
-- 참조대상이 되는 테이블(부서 department)을 부모 테이블이라고 하고 참조하는 테이블(사원 k_employee)을 자식테이블이라고 한다

-- 만약 부모테이블인 부서테이블에 10번 부서번호가 없다면 아래 insert 구문은 error가 난다 - parent key not found
-- foreign key 제약조건 위해 (참조 무결성 제약조건 위배)
insert into k_employee(empno, ename, sal, deptno) values(1, '아이유', 500, 10);

insert into department(deptno, dname, loc, tel) values(10, '전략기획', '오리', '031');
insert into department(deptno, dname, loc, tel) values(20, '공공사업', '종로', '02');
insert into department(deptno, dname, loc, tel) values(30, '연구개발', '판교', '032');
-- 부모 테이블에 10번 부서를 등록한 후 아래 사원정보를 등록하면 된다
insert into k_employee(empno, ename, sal, deptno) values(1, '아이유', 500, 10);
insert into k_employee(empno, ename, sal, deptno) values(2, '박보검', 700, 10);
insert into k_employee(empno, ename, sal, deptno) values(3, '강하늘', 800, 20);
-- 참조 무결성 위배(foreign key 제약조건 위배) -- error
insert into k_employee(empno, ename, sal, deptno) values(4, '김태리', 800, 40);

commit

/*
	Join Sql
	- 사원번호1 아이유 사원의 sal과 부서번호deptno, 부서명dname, 지역loc을 조회하고자 한다
	  사원 테이블과 부터 테이블의 정보를 함께 조회해야 함 -> Join SQL을 이용하면 된다
	  
	형식1
	select 컬럼명, 컬럼명
	from 테이블명 별칭, 테이블명 별칭
	where 별칭.컬럼명 = 별칭.컬럼명 --조인조건
	
	형식2
	select 컬럼명, 컬럼명
	from 테이블명 별칭
	inner join 테이블명 별칭 on 별칭.컬럼명 = 별칭.컬럼명
*/

select e.ename, e.sal, d.deptno, d.dname, d.loc
from k_employee e, department d
where e.deptno = d.deptno and e.empno = 1;
-- 아래와 같이 표현할 수도 있다
select e.ename, e.sal, d.deptno, d.dname, d.loc
from k_employee e
inner join department d on e.deptno = d.deptno
where e.empno = 1;

select e.empno, e.ename, e.sal, d.deptno, d.dname, d.loc, d.tel
from k_employee e, department d
where e.deptno = d.deptno and e.empno = 1;