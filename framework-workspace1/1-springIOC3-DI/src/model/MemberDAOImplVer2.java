package model;

public class MemberDAOImplVer2 implements MemberDAO {
	@Override
	public String findMemberById(String id) {
		if(id.endsWith("java")) {
			return "java 아이유 오리 ver2 검색기능 향상";
		}
		return null;
	}
}
