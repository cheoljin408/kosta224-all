package step4;
/*
 	Has a 관계: aggregation 관계를 연습해보는 예제
 */
public class TestHasAEx {
	public static void main(String[] args) {
		School school = new School("코스타");
		System.out.println(school.getName()); // 코스타
		school.setStudent(new Student("아이유", "21"));
		System.out.println(school.getStudent().getName()); // 아이유
		System.out.println(school.getStudent().getStuId()); // 21
	}
}
