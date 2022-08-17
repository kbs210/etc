package com.kitri.transaction.service;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	public int withdraw(int money, String accountNum) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("money", String.valueOf(money));
		map.put("accountNum", accountNum);
		
		return sqlSession.update("account.withdraw", map);
	}

	public int deposit(int money, String accountNum) {

		Map<String, String> map = new HashMap<String, String>();
		
		map.put("money", String.valueOf(money));
		map.put("accountNum", accountNum);
		
		return sqlSession.update("account.deposit", map);
		
	}
	
	public String transferring() throws Exception{
		
		throw new Exception();
		
	}

	public String transferOk() throws Exception{
		
		return "이체 완료되었습니다";
		
	}

}
