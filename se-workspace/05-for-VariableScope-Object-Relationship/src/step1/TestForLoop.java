package step1;

public class TestForLoop {
	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			System.out.println(i);
		}
		System.out.println("****");
		// 위의 for 구문의 실행을 아래 while 문으로 동일하게 적용할 수 있음
		
		int j = 0;
		while(j<10) {
			System.out.println(j++);
		}
		System.out.println("****");
		
		int k = 0;
		do {// do while은 먼저 실행 후 조건 검사
			System.out.println(k++);
		} while(k>1);
	}
}
