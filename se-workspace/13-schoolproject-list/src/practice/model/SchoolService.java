package practice.model;

import java.util.ArrayList;

public class SchoolService {
	private ArrayList<Member> list = new ArrayList<Member>();

	public void addMember(Member member) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTel().equals(member.getTel())) {
				System.out.println(member.getTel() + " tel 이 중복되어 추가될 수 없습니다");
				return;
			}
		}
		list.add(member);
		
	}

	public void printAll() {
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public String findMemberByTel(String tel) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTel().equals(tel)) {
				return list.get(i).toString();
			}
		}
		return tel + "은 없는 전화번호입니다.";
	}

	public String deleteMemberByTel(String tel) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTel().equals(tel)) {
				String str = list.get(i).toString();
				list.remove(i);
				return str;
			}
		}
		return tel + "은 없는 전화번호입니다.";
	}

}
