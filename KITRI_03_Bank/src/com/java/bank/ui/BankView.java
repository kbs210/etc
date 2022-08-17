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
		// ȭ���� ����� method
		printMenu();
		Scanner sc = new Scanner(System.in);
		System.out.println("�����ϼ���");
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
			System.out.println("���ڸ� �߸� �Է��Ͽ����ϴ�");
			break;
		}

		sc.close();
	}

	private void makeAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���¹�ȣ : ");
		String id = sc.next();
		//�����Ǿ� �ִ� ��ü�� null����
		BankDto dto = bankDao.select(id);
		if (dto != null) {
			System.out.println("�̹� �����ϴ� ���¹�ȣ�Դϴ�");
		} else {
			bankDto.setId(id);
			System.out.println("�̸� : ");
			bankDto.setName(sc.next());

			System.out.println("�Աݾ� : ");
			bankDto.setBalance(sc.nextLong());

			int check = bankDao.makeAccount(bankDto);
			System.out.println("���°� �����Ǿ����ϴ�");
		}
		sc.close();

	}

	private void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���¹�ȣ : ");
		String id = sc.next();
		bankDto = bankDao.select(id);
		if(bankDto != null) {
			System.out.println("�Աݾ� : ");
			long money = sc.nextLong();
			bankDto.setBalance(bankDto.getBalance() + money);
			int check = bankDao.update(bankDto);
			
			if (check > 0) {
				System.out.println("�ԱݿϷ�");
			} else {
				System.out.println("�Աݽ���");
			}
		} else {
			System.out.println("���¹�ȣ�� Ȯ�� �� �ٽ� �õ����ּ���");
		}
		
	}

	private void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���¹�ȣ : ");
		String id = sc.next();
		bankDto = bankDao.select(id);
		if(bankDto != null) {
			System.out.println("��ݾ� : ");
			long money = sc.nextLong();
			bankDto.setBalance(bankDto.getBalance() - money);
			int check = bankDao.update(bankDto);
			
			if (check > 0) {
				System.out.println("��ݿϷ�");
			} else {
				System.out.println("��ݽ���");
			}
		} else {
			System.out.println("���¹�ȣ�� Ȯ�� �� �ٽ� �õ����ּ���");
		}
	}

	private void inquiry() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���¹�ȣ : ");
		String id = sc.next();
		bankDto = bankDao.select(id);
		if(bankDto != null) {
			System.out.println("�ܾ� : " + bankDto.getBalance());

		} else {
			System.out.println("���¹�ȣ�� Ȯ�� �� �ٽ� �õ����ּ���");
		}
	}

	private void showData() {
			List<BankDto> bankList = bankDao.showData();
			
			for(int i=0; i<bankList.size(); i++) {
				System.out.println("���¹�ȣ : " + bankList.get(i).getId() +"\t" + "�̸� : " +bankList.get(i).getName() + "\t" + "�ܾ� : " + bankList.get(i).getBalance());
			}
			
			for(int i=0; i<bankList.size(); i++) {
			BankDto dto = bankList.get(i);
			System.out.println(dto.toString());
			}
			
	}

	public void printMenu() {
		System.out.println("menu==========");
		System.out.println("1. ���°���");
		System.out.println("2. �Ա�");
		System.out.println("3. ���");
		System.out.println("4. �ܾ���ȸ");
		System.out.println("5. ��ü���");
		System.out.println("6. ����");
	}

}
