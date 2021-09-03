package step7;

import step4.Animal;
import step4.Person;

public class CompanyService {
	public void playAll(Animal[] a) {
		for(int i=0; i<a.length; i++) {
			// 배열 요소가 Person 객체인지 확인
			if(a[i] instanceof Person) {
				// Person의 독자적 멤버(메소드)를 실행하기 위해 Object down casting을 한다
				((Person) a[i]).ticketing();
			}
			a[i].play();
		}
	}
}
