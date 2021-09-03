package step3;

public class TestForLoop3 {
	public static void main(String[] args) {
		/*
		 	구구단 2단부터 9단까지 출력
		 	중첩 for(Nested Loop)을 이용한다.
		 */
		for(int i=2; i<10; i++) {
			for(int j=1; j<10; j++) {
				System.out.print(i+"*"+j+"="+i*j+" \t");
			}
			System.out.println();
		}
	}
}
