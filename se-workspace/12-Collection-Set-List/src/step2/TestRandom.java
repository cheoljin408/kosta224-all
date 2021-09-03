package step2;

import java.util.Random;

public class TestRandom {
	public static void main(String[] args) {
		// 임의의 수를 발생시키기 위해 Random 객체를 이용한다
		Random r = new Random();
		
		for(int i=0; i<10; i++) {
			System.out.println(r.nextInt(3)); // 범위 bound를 3으로 주면 0부터 2까지 랜덤한 수가 생성된다
		}
	}
}
