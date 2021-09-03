package step2;
/*
 자바의 데이터 타입에는 기본형 데이터 타입(primitive data type)과 참조형 데이터 타입(reference data type)이 있다.
1) primitive data type
			1byte	2byte	4byte	8byte
	정수형	byte	short	int		long	정수형의 기본형은 int형
	실수형					float	double	실수형의 기본형은 double형
	문자형			char					문자형은 오직 한 문자만 가능, 문자열은 참조형인 String을 사용
	논리형	boolean							논리형은 true or false만 가능
 */
public class TestPrimitiveDataType {
	public static void main(String[] args) {
		// 1. 정수형
		byte b = 1;
		b = 2;
		System.out.println("byte: " + b);
		
		// java se api를 이용해 byte 타입의 최대값, 최소값을 확인해본다.
		System.out.println("byte형 최대값: " + Byte.MAX_VALUE);
		System.out.println("byte형 최소값: " + Byte.MIN_VALUE);

		// b = 129; // error: byte 최대값을 넘으므로
		
		// 2byte
		short s = 3;
		System.out.println("short: " + s);
		
		// 4byte
		int i = 1;
		System.out.println("int: " + i);
		
		// 8byte, long형 데이터에는 대문자or소문자 l을 붙인다. 안붙이면 int형으로 인식
		long l = 3L;
		System.out.println("long: " + l);
		
		// 2. 실수형
		// 4byte, float형 데이터에는 대문자or소문자 f를 붙인다. 안붙이면 double형으로 인식
		float f = 3.14F;
		System.out.println("float: " + f);
		// 8byte, 실수형의 기본형은 double
		double d = 3.14;
		System.out.println("double: " + d);
		
		// 3. 문자형(한 문자만 가능, 문자열은 참조형 String으로 제어)
		char c = 'a';
		System.out.println("char: " + c);
		
		// 4. 논리형(true or false만 가능)
		boolean bo = true;
		bo = false;
		System.out.println("bolean: " + bo);
		
		// type casting 사례
		byte b1 = 1;
		byte b2 = 6;
		// 아래 코드는 compile error
		// byte b3 = b1 + b2;// 연산결과 7은 정수형의 기본형인 int로 인식
		
		// 방법1
		// int in = b1 + b2;
		// 방법2
		byte b3 = (byte)(b1 + b2); // 두 숫자의 연산 결과를 byte형으로 인식시킨다 -> type casting
		System.out.println("연산결과: " + b3);
	}
}
