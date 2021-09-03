package model;

public interface SchoolService {

	/**
	 * 리스트에 학교 구성원 정보를 등록(추가)하는 메소드
	 * 인자값으로 전달된 구성원 객체의 tel과
	 * 리스트에 요소로 저장된 학교 구성원 객체의 tel이 중복되면
	 * 등록시키지 않아야한다
	 * @param member
	 */
	void addMember(Member member);

	void printAll();

	/**
	 * 전화번호로 리스트에 저장된 구성원 객체를 검색해서 반환하는 메소드
	 * 만약 존재하지 않으면 null을 반환한다
	 * @param tel
	 * @return
	 */
	Member findMemberByTel(String tel);

	/**
	 * 매개변수로 전달된 인자값 tel에 해당하는 리스트 요소의 구성원 정보가 존재하면
	 * 삭제하고 삭제 대상의 정보를 반환, 
	 * 존재하지 않으면 tel에 해당하는 구성원 정보가 없어서 삭제 불가 메세지를 반환한다 
	 * @param tel
	 * @return message
	 */
	String deleteMemberByTel(String tel);

	// Version2에서 추가 (jdk 1.8 이상 지원)
	public default int findIndexByTel(String tel) {
		return 0;
	}
}