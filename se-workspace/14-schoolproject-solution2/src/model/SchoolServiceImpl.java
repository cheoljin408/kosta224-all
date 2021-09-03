package model;

import java.util.ArrayList;

public class SchoolServiceImpl implements SchoolService {
private ArrayList<Member> list = new ArrayList<Member>();
	
	/**
	 * 리스트에 학교 구성원 정보를 등록(추가)하는 메소드
	 * 인자값으로 전달된 구성원 객체의 tel과
	 * 리스트에 요소로 저장된 학교 구성원 객체의 tel이 중복되면
	 * 등록시키지 않아야한다
	 * @param member
	 */
	@Override
	public void addMember(Member member) {
		boolean flag = false;
		
		for(int i=0; i<list.size(); i++) {
			if(member.getTel().equals(list.get(i).getTel())) { // 같은 tel이 있으면
				flag = true;
				break;
			}
		}
		if(flag) { // 중복되면 등록시키지 않고 메세지 출력
			System.out.println(member.getTel() + " tel이 중복되어 추가될 수 없습니다.");
		}
		else { // 중복되지 않으면 등록
			list.add(member);
		}
	}
	
	@Override
	public void printAll() {
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * 전화번호로 리스트에 저장된 구성원 객체를 검색해서 반환하는 메소드
	 * 만약 존재하지 않으면 null을 반환한다
	 * @param tel
	 * @return
	 */
	@Override
	public Member findMemberByTel(String tel) {
		Member member = null;
		
		for(int i=0; i<list.size(); i++) {
			if(tel.equals(list.get(i).getTel())) {
				member = list.get(i);
				break;
			}
		}
		return member;
	}

	/**
	 * 매개변수로 전달된 인자값 tel에 해당하는 리스트 요소의 구성원 정보가 존재하면
	 * 삭제하고 삭제 대상의 정보를 반환, 
	 * 존재하지 않으면 tel에 해당하는 구성원 정보가 없어서 삭제 불가 메세지를 반환한다 
	 * @param tel
	 * @return message
	 */
	@Override
	public String deleteMemberByTel(String tel) {
		String message = null;
		
		for(int i=0; i<list.size(); i++) {
			if(tel.equals(list.get(i).getTel())) {
				message = list.remove(i).toString();
				break;
			}
		}
		if(message != null) {
			return message;
		}
		else {
			return tel + " tel에 해당하는 구성원 정보가 없어서 삭제 불가";
		}
	}

}
