package com.java.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.member.dto.MemberDto;

@Component
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int memberinsert(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("member_insert", memberDto);
	}

	@Override
	public int memberidCheck(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String loginOk(String id, String password) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		return sqlSessionTemplate.selectOne("member_login", map);
	}

	@Override
	public MemberDto memberUpdate(String id) {
		
		return sqlSessionTemplate.selectOne("member_select",id);
	}

	@Override
	public int memberUpdateOk(MemberDto memberDto) {
		
		return sqlSessionTemplate.update("member_update", memberDto);
	}

	@Override
	public int memberDeleteOk(MemberDto memberDto) {
		
		return sqlSessionTemplate.update("member_delete", memberDto);
	}
	
	
	
	
}
