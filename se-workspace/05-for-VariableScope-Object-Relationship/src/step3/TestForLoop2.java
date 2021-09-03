package step3;

public class TestForLoop2 {
	public static void main(String[] args) {
		System.out.println("아");
		System.out.println("이");
		System.out.println("******");
		System.out.println();
		System.out.println();
		System.out.print("아");
		System.out.print("이");
		System.out.print("유");
		System.out.println("팬");
		/*
		 	1	2	3	4	5
		 	1	2	3	4	5
		 	1	2	3	4	5
		 */
		int row = 3;
		int col = 5;
		/*
		 	for() {
		 		for() {
		 		
		 		}
		 		System.out.println();
		 	}
		 */
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(j+1 + " \t");
			}
			System.out.println();
		}
	}
}
