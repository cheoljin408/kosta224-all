package step3;

public class TestStringBuilder {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("±è°¡³×");
		System.out.println(sb);
		System.out.println(sb.append("ÂüÄ¡±è¹ä"));
		System.out.println(sb.indexOf("°¡"));
		System.out.println(sb.substring(2, 5));
		System.out.println(sb.insert(2, "³ª"));
		System.out.println(sb.delete(2, 5));
		
		StringBuilder message = new StringBuilder("»µÀÌÀå°¡°¡´Ï");
		System.out.println(message.reverse());
	}
}
