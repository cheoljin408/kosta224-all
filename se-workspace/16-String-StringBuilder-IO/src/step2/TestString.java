package step2;

public class TestString {
	public static void main(String[] args) {
		String name = "������";
		System.out.println(name.concat("��"));
		System.out.println(name.contains("��"));
		System.out.println(name.contains("��"));
		System.out.println(name.indexOf("��"));
		System.out.println(name.indexOf("��"));
		System.out.println(name.startsWith("����"));
		System.out.println(name.endsWith("��"));
		
		String info = "���ϰ��ִ�";
		System.out.println(info.substring(2)); // 2 beginIndex
		System.out.println(info.substring(2, 4)); // ���� beginIndex���� endIndex �� ����
		
		String id = "javaking";
		System.out.println(id.length());
		System.out.println(id.trim().length());
		
		String nick = "���ڿ���";
		System.out.println(nick.replace("��", "��"));
		
		String fileName = "org.web.t.java";
		System.out.println(fileName.lastIndexOf("."));
		
		int i = fileName.lastIndexOf(".");
		System.out.println(fileName.substring(i + 1));
		
		System.out.println(fileName.replace(".java", ""));
	}
}
