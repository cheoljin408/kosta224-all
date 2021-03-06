/*
	데이터베이스정규화(Normalization)
	: 데이터 중복을 최소화하고 데이터의 무결성 및 안정성을 보장하기 위해 테이블을 분해하는 과정을 말한다
	
	제 1 정규형(1NF(Normal Form))
	복수의 속성값을 갖는 속성을 분리
	도메인이 원자값이다
	-> 도메인 domain: 속성 or 컬럼이 가질 수 있는 값의 범위(성별일 경우 남과 여)
	   원자값: 더이상 쪼개질 수 없는 값을 말함
	ex) 주문서에 상품번호, 상품내역, 단가 등의 속성(컬럼)에 저장되는 값이 
		원자값으로 저장되어야 하므로 별도의 주문 상세 테이블로 분리되어야 한다
	   
	제 2 정규형(2NF)
	부분 함수 종속을 분리하여 완전 함수 종속 상태로 만든다
	ex) 주문 상세 테이블에서는 주문번호와 상품번호가 복합키이다
		여기에 일반 속성(컬럼)으로 상품내역(상품명, 제조사 등)과 단가, 주문수량이 있다
		주문번호 + 상품번호로 구성된 복합키에 완전 종속되어 있는 속성은 주문수량이다
		상품상세정보, 단가는 상품번호에만 종속된다
		복합키에는 상품내역과 단가는 부분종속 상태이다
		
	제 3 정규형(3NF)
	이행 함수적 종속을 분리(A -> B 이면 B -> C 이고 A -> C 이다)
	일반 속성에 종속적인 속성을 분리
	ex) 주문서 테이블에 담당 부서번호, 부서전화, 관리자명이 있다면 이행적 함수 종속이라고 볼 수 있다
		주문번호(pk)에 종속되는 것이 아니라 일반 속성인 부서번호에 부서전화, 관리자명이 종속되므로
		이를 별도의 부서테이블로 분리하는 것을 3정규형이라고 한다
*/