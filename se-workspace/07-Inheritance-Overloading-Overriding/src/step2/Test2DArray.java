package step2;

public class Test2DArray {
	public static void main(String[] args) {
		// 다차원 배열
		// 3년간 매월 강우량 저장 -> 2차원 배열
		int rain[][] = new int[3][12];
		// 첫해 첫월에 강우량 저장
		rain[0][0] = 100;
		// 첫해 2월
		rain[0][1] = 120;
		// 마지막해 12월
		rain[2][11] = 200;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<12; j++) {
				System.out.print(rain[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("*************************");
		
		// 오리중학교 1학년 3개반 2학년 5개반 3학년 6개반
		int school[][] = new int[3][];
		school[0] = new int[3];
		school[1] = new int[5];
		school[2] = new int[6];
		
		// 오리중학교 마지막 학년의 마지막 반에 20명 할당 후 출력
		int i = school.length - 1; // 학년의 마지막 인덱스 2
		int j = school[i].length - 1; // 학년에 배정된 반의 마지막 인덱스 5
		school[i][j] = 20;
		System.out.println(school[i][j]);
	}
}
