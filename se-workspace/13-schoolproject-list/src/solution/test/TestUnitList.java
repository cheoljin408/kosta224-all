package solution.test;

import java.util.ArrayList;

import solution.model.Member;
import solution.model.Student;

public class TestUnitList {
	public static void main(String[] args) {
		ArrayList<Member> list = new ArrayList<Member>();
		
		list.add(new Student("0101231234", "곽승진", "용인", "17"));
		// Member m = list.remove(0);
		// System.out.println("삭제:" + m.toString());
		System.out.println("삭제 전 리스트:" + list);
		System.out.println("삭제->" + list.remove(0).toString());
		System.out.println("삭제 후 리스트:" + list);
	}
}
