package step5;

public class TestArray3 {
	public static void main(String[] args) {
		// 배열 선언, 생성, 할당, 동시에
		int price[] = {200, 300, 100, 2000, 1200}; // 배열 length 5인 객체를 생성하고 요소에 값을 할당
		int money = 500;
		// price 배열 요소중 money를 초과하는 배열 요소의 price만 모두 출력한다.
		// for loop 안에서 if문을 이용하면 된다.
		for(int i=0; i<price.length; i++) {
			if(money < price[i]) {
				System.out.println(price[i]);
			}
		}
	}
}
