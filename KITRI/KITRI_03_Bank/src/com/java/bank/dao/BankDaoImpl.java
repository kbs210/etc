package com.java.bank.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.java.bank.dto.BankDto;

public class BankDaoImpl implements BankDao{
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	   public BankDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		      super();
		      this.sqlSessionTemplate = sqlSessionTemplate;
		   }


	public BankDaoImpl() {
	}

	@Override
	public int makeAccount(BankDto bankDto) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("dao.BankMapper.bank_insert", bankDto);
	}

	@Override
	public List<BankDto> showData() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("bank_selectList");
	}

	@Override
	public BankDto select(String id) {
		return sqlSessionTemplate.selectOne("dao.BankMapper.bank_select", id);
	}

	@Override
	public int update(BankDto bankDto) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("bank_update", bankDto);
	}
	
}
