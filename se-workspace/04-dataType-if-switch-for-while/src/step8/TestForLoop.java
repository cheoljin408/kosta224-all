package step8;

public class TestForLoop {
	public static void main(String[] args) {
		// for loop: 반복문 연습
		System.out.println("**for loop**");
		for(int i=0; i<3; i++) {
			System.out.println("for loop: i->" + i);
		}// for loop
		System.out.println("**while loop**");
		int j = 0;
		while(j<3) {
			System.out.println("while loop: j->" + j++);
		}// while loop
		System.out.println("**do while**");
		// do while loop은 먼저실행한 후 조건 검사를 하고 반복한다.
		int k = 1;
		do {
			System.out.println("do while: k->" + k++);
		}while(k<0);
	}
}
