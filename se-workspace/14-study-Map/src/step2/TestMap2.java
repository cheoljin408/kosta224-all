package step2;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public class TestMap2 {
	public static void main(String[] args) {
		/*
		 	Map 계열: key와 value 쌍으로 저장, key로 데이터를 제어
		 	LinkedHashMap: 입력 순서를 기억
		 	TreeMap: 정렬 기능 내장
		 */
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("7", "된장찌개");
		map.put("4", "라면");
		map.put("9", "콩국수");
		System.out.println(map);
		
		// key로 검색
		System.out.println(map.get("4"));
		System.out.println(map.get("8")); // 없으면 null
		System.out.println(map.remove("7")); // 삭제, 삭제한 정보를 반환
		System.out.println(map.size());
		
		System.out.println("**map의 values만 모두 출력**");
		Collection<String> col = map.values();
		Iterator<String> it = col.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
