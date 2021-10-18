-- sql 한 줄 주석
/*
	sql 여러 줄 주석
	sql은 대소문자 구별하지 않는다
	
	SQL(Structured Query Language): 데이터베이스를 제어하는 언어
									데이터베이스를 정의, 조작, 제어하는 언어
									
	DDL, DML, DCL(SQL은 다음과 같은 범주로 구분될 수 있다)
	1. DDL(Data Definition Language: 데이터 정의어) - CREATE 생성, DROP 삭제, ALTER 수정
	2. DML(Data Manipulation Language: 데이터 조작어) - INSERT 삽입, SELECT 조회, UPDATE 수정, DELETE 삭제(CRUD - Create, Read, Update, Delete)
	3. DCL(Data Control Language: 데이터 제어어) - COMMIT 실제 DB에 반영, ROLLBACK 작업을 취소하고 원상태로 되돌린다
											   GRANT 권한부여, REVOKE 권한취소
											   
	TABLE - 데이터를 저장하는 공간
	COLUMN - 속성 attribute
	CONSTRAINT - 제약조건 ex) PRIMARY KEY(PK, 기본키) -> 중복을 허용하지 않고 NOT NULL 이어야 한다(UNIQUE + NOT NULL)
	DATA TYPE - 문자열 VARCHAR2(100), 숫자형 NUMBER ...
*/

-- SQL 실행 단축키: 영역 지정 후 ALT + X

-- DDL: 테이블 생성
CREATE TABLE member(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	address VARCHAR2(100)
)

-- DML: 데이터 조회 Read(정보를 읽는다)
SELECT * FROM MEMBER;

-- DML: 데이터 삽입 Create(정보를 생성한다)

INSERT INTO MEMBER(ID, PASSWORD, NAME, ADDRESS) VALUES ('java', 'a', '아이유', '오리');

INSERT INTO MEMBER(ID, PASSWORD, NAME, ADDRESS) VALUES ('spring', 's', '김철진', '여주');

-- 특정 컬럼(id, name) 만 조회
SELECT ID, NAME FROM MEMBER;

-- ERROR: id의 제약조건 primary key -> unique + not null, id가 중복되므로 error
INSERT INTO MEMBER(ID, PASSWORD, NAME, ADDRESS) VALUES ('java', 'b', '어이유', '죽전');
-- ERROR: id의 제약조건 primary key -> unique + not null, id가 null이므로 error
INSERT INTO MEMBER(PASSWORD, NAME, ADDRESS) VALUES ('b', '어이유', '죽전');
-- ERROR: password 컬럼의 제약조건이 not null 이므로 반드시 insert시에 데이터를 삽입해야 한다
INSERT INTO MEMBER(ID, NAME, ADDRESS) VALUES ('java', '어이유', '죽전');
-- SUCCESS: address 컬럼은 별도의 제약조건이 없으므로 null이 허용
INSERT INTO MEMBER(ID, PASSWORD, NAME) VALUES('jdbc', 'star', '박보검');

-- WHERE 조건절을 이용해 정보 조회
-- id가 java인 회원의 name과 address를 조회
SELECT NAME, ADDRESS FROM MEMBER WHERE ID='java';
SELECT NAME, ADDRESS FROM MEMBER WHERE ID='java2';
-- name이 아이유이고 address가 오리인 회원의 id를 조회
SELECT ID FROM MEMBER WHERE NAME='아이유' AND ADDRESS='오리';

-- id가 jdbc인 회원 정보를 조회
SELECT * FROM MEMBER WHERE ID='jdbc';
-- id가 jdbc인 회원 주소를 제주로 업데이트
UPDATE MEMBER SET ADDRESS='제주' WHERE ID='jdbc';

-- id가 jdbc인 회원 정보를 삭제
DELETE FROM MEMBER WHERE ID='jdbc';

-- 실제 DB에 작업 결과물을 반영
COMMIT

-- DML(CRUD: Create - insert, Read - select, Update - update, Delete - delete) 연습

-- 회원 아이디 angel, 패스워드 kind, 이름 이상순, 주소 애월읍 정보를 insert
INSERT INTO MEMBER VALUES('angel', 'kind', '이상순', '애월읍');
-- 회원 name이 이상순이고 address가 애월읍인 회원의 id와 password를 select
SELECT ID, PASSWORD FROM MEMBER WHERE NAME='이상순' AND ADDRESS='애월읍';

-- 회원의 address가 애월읍인 회원의 address를 오리로 update를 한다
UPDATE MEMBER SET ADDRESS='오리' WHERE ADDRESS='애월읍';
-- 외원의 address가 오리인 회원의 id와 name을 조회한다 select
SELECT ID, NAME FROM MEMBER WHERE ADDRESS='오리';

-- 회원의 id가 angel이고 password가 kind인 회원 정보를 삭제 delete
DELETE FROM MEMBER WHERE ID='angel' AND PASSWORD='kind';
-- 회원 id가 angel인 회원의 name을 조회(삭제 했으므로 조회 결과는 없다)
SELECT NAME FROM MEMBER WHERE ID='angel';