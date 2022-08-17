package com.java.bank.dao;

import java.util.List;

import com.java.bank.dto.BankDto;

public interface BankDao {
   // 계좌 생성
   public int makeAccount(BankDto bankDto);
   
   // 전체 정보 조회
   public List<BankDto> showData();
   
   // 일반 조회
   public BankDto select(String id);
   
   // 입,출금
   public int update(BankDto bankDto);
}