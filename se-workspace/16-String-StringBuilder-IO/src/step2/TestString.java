package step2;

public class TestString {
	public static void main(String[] args) {
		String name = "아이유";
		System.out.println(name.concat("님"));
		System.out.println(name.contains("이"));
		System.out.println(name.contains("어"));
		System.out.println(name.indexOf("유"));
		System.out.println(name.indexOf("ㅋ"));
		System.out.println(name.startsWith("아이"));
		System.out.println(name.endsWith("유"));
		
		String info = "잘하고있다";
		System.out.println(info.substring(2)); // 2 beginIndex
		System.out.println(info.substring(2, 4)); // 고있 beginIndex부터 endIndex 앞 까지
		
		String id = "javaking";
		System.out.println(id.length());
		System.out.println(id.trim().length());
		
		String nick = "코코오빠";
		System.out.println(nick.replace("오", "아"));
		
		String fileName = "org.web.t.java";
		System.out.println(fileName.lastIndexOf("."));
		
		int i = fileName.lastIndexOf(".");
		System.out.println(fileName.substring(i + 1));
		
		System.out.println(fileName.replace(".java", ""));
	}
}
