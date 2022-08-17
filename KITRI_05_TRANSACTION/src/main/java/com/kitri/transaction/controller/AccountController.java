package com.kitri.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kitri.transaction.service.AccountService;

@Controller
public class AccountController {
   
   //이체 controller
   //service를 호출
   @Autowired
   AccountService service;
   
   @RequestMapping("/")
   public String transferPage() {
      System.out.println("account");
      return "account";
   }
   
   @RequestMapping("/transfer")
   public String transfer(int money, String accountNum) throws Exception {
      
      service.transfer(money,accountNum);
      
      return "transfer-ok";
   }
   
   
   
}