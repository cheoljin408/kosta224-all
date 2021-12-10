package org.kosta.myproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public MemberDTO findMemberById(String id);
  
	public List<String> getMemberAddressKind();

	public List<MemberDTO> findMemberByAddress(String address);
}
