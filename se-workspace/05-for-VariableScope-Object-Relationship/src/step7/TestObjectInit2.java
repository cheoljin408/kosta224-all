package step7;
/*
 	코드 실행 결과를 예상해보기
 */
public class TestObjectInit2 {
	public static void main(String[] args) {
		Food f = new Food("칼국수", 7000);
		ObjectInitExam exam = new ObjectInitExam();
		// 칼국수 7000 정보를 가진 객체의 주소값을 
		// pass1 메소드의 인자값으로 전달한다.
		exam.pass1(f);
		System.out.println(f.getName() + " " + f.getPrice());
		exam.pass2(f);
		System.out.println(f.getName() + " " + f.getPrice());
	}
}
