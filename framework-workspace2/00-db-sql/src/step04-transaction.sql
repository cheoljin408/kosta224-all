/*
	Transaction(트랜잭션): 데이터베이스의 상태를 변경시키기 위해 수행하는 작업단위
	
	DCL -> COMMIT, ROLLBACK
	- COMMIT: 변경된 작업 내용을 실제 데이터베이스에 반영(실제 저장)
	- ROLLBACK: 변경된 작업 내용을 취소하고 이전 상태ㅗ 되돌림
	
	ex) 카드 발급시에 포인트 지급을 약속 -> 카드 발급 트랜잭션(카드 발급 + 포인트 지급)
		
		카드발급 트랜잭션
		1. 카드 발급
		2. 약속한 포인트 지급
		1, 2번 두 사항이 모두 정상적으로 실행되었을 떄만 COMMIT 되어야 한다(실제 DB에 저장)
		만약 트랜잭션 내부의 작업에 문제가 발생했을 경우 1. 카드발급은 정상적으로 진행되고
		2. 약속한 포인트 지급은 문제가 발생했다면 ROLLBACK 되어야 한다
		즉 1. 카드발급 작업내용 또한 취소가 되어야 한다
		
	- Application에서 트랜잭션 처리
	  JDBC기본 트랜잭션 설정: Auto Commit - True에서 수동(Manual Commit) 모드로 변경
	  					 Connection의 method: setAutoCommit(false)
	  					 
	  트랜잭션의 기본 설정인 Auto Commit 모드를 수동으로 변경한 후
	  트랜잭션 내 모든 작업이 정상적으로 진행되었을 때 commit()을 실행(실제 db에 작업 내용을 반영)
	  작업 진행 중 문제가 발생했을 때 rollback()을 실행(작업 내용을 취소하고 되돌린다)
	  
	  try {
	  	세부작업1
	  	세부작업2
	  	...
	  	con.commit();
	  } catch(Exception e) {
	  	con.rollback();
	  } finally {
	  	closeAll();
	  }
*/

create table card(
	id varchar2(100) primary key,
	name varchar2(100) not null
)

create table point(
	id varchar2(100) primary key,
	point_type varchar2(100) not null,
	point number not null
)

select * from card;
select * from point;