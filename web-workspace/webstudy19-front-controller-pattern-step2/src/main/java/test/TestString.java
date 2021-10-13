package test;

public class TestString {
	public static void main(String[] args) {
		String url = "redirect:register-result.jsp";
		System.out.println(url.startsWith("redirect:"));
		if(url.startsWith("redirect:")) {
			System.out.println("redirect:".length());
			System.out.println(url.substring(9));
		}
	}
}
