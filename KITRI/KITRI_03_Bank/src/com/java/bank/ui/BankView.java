package com.java.bank.ui;

import java.util.List;
import java.util.Scanner;

import com.java.bank.aop.LogAspect;
import com.java.bank.dao.BankDao;
import com.java.bank.dto.BankDto;

public class BankView implements BankUi {

	private BankDao bankDao;
	private BankDto bankDto;

	public BankView() {
	}

	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}

	public void setBankDto(BankDto bankDto) {
		this.bankDto = bankDto;
	}

	public BankView(BankDao bankDao, BankDto bankDto) {
		super();
		this.bankDao = bankDao;
		this.bankDto = bankDto;
	}

	@Override
	public void execute() {
		// 화면을 만드는 method
		printMenu();
		Scanner sc = new Scanner(System.in);
		System.out.println("선택하세요");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			makeAccount();
			break;
		case 2:
			deposit();
			break;
		case 3:
			withdraw();
			break;
		case 4:
			inquiry();
			break;
		case 5:
			showData();
			break;
		case 6:
			break;
		default:
			System.out.println("숫자를 잘못 입력하였습니다");
			break;
		}

		sc.close();
	}

	private void makeAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌번호 : ");
		String id = sc.next();
		//생성되어 있는 객체에 null대입
		BankDto dto = bankDao.select(id);
		if (dto != null) {
			System.out.println("이미 존재하는 계좌번호입니다");
		} else {
			bankDto.setId(id);
			System.out.println("이름 : ");
			bankDto.setName(sc.next());

			System.out.println("입금액 : ");
			bankDto.setBalance(sc.nextLong());

			int check = bankDao.makeAccount(bankDto);
			System.out.println("계좌가 생성되었습니다");
		}
		sc.close();

	}

	private void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌번호 : ");
		String id = sc.next();
		bankDto = bankDao.select(id);
		if(bankDto != null) {
			System.out.println("입금액 : ");
			long money = sc.nextLong();
			bankDto.setBalance(bankDto.getBalance() + money);
			int check = bankDao.update(bankDto);
			
			if (check > 0) {
				System.out.println("입금완료");
			} else {
				System.out.println("입금실패");
			}
		} else {
			System.out.println("계좌번호를 확인 후 다시 시도해주세요");
		}
		
	}

	private void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌번호 : ");
		String id = sc.next();
		bankDto = bankDao.select(id);
		if(bankDto != null) {
			System.out.println("출금액 : ");
			long money = sc.nextLong();
			bankDto.setBalance(bankDto.getBalance() - money);
			int check = bankDao.update(bankDto);
			
			if (check > 0) {
				System.out.println("출금완료");
			} else {
				System.out.println("출금실패");
			}
		} else {
			System.out.println("계좌번호를 확인 후 다시 시도해주세요");
		}
	}

	private void inquiry() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌번호 : ");
		String id = sc.next();
		bankDto = bankDao.select(id);
		if(bankDto != null) {
			System.out.println("잔액 : " + bankDto.getBalance());

		} else {
			System.out.println("계좌번호를 확인 후 다시 시도해주세요");
		}
	}

	private void showData() {
			List<BankDto> bankList = bankDao.showData();
			
			for(int i=0; i<bankList.size(); i++) {
				System.out.println("계좌번호 : " + bankList.get(i).getId() +"\t" + "이름 : " +bankList.get(i).getName() + "\t" + "잔액 : " + bankList.get(i).getBalance());
			}
			
			for(int i=0; i<bankList.size(); i++) {
			BankDto dto = bankList.get(i);
			System.out.println(dto.toString());
			}
			
	}

	public void printMenu() {
		System.out.println("menu==========");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 잔액조회");
		System.out.println("5. 전체출력");
		System.out.println("6. 종료");
	}

}
