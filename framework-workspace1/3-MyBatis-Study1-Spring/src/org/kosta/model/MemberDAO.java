package org.kosta.model;

import java.util.List;
import java.util.Map;

public interface MemberDAO {

	MemberVO findMemberById(String id);

	void register(MemberVO paramVO);

	List<MemberVO> findMemberListByAddress(String address);

	List<MemberVO> findMemberListByNameAndAddress(MemberVO vo);

	void updateMember(MemberVO memberVO);

	void deleteMemberById(String id);

	Map<String, String> findMemberMapById(String id);

}