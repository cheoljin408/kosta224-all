package test.step2;

import org.json.JSONArray;

public class TestJsonArray {
	public static void main(String[] args) {
		JSONArray ja = new JSONArray();
		ja.put("김밥");
		ja.put("라면");
		ja.put("콜라");
		System.out.println(ja.toString());
	}
}
