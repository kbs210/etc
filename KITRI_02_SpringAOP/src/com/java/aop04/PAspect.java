package com.java.aop04;

import org.aspectj.lang.ProceedingJoinPoint;

public class PAspect {

	public void sub(ProceedingJoinPoint joinPoint) {
		try {
			//�ٽ��Լ� ��
			System.out.println("������ �Խ�");
			//�ٽ��ڵ�
			joinPoint.proceed();
			//���������� ����Ǿ��� ��
			System.out.println("���ɽĻ縦 ������ �Դ´�");
		} catch (Throwable e) {
			//exception �߻���
			System.out.println("���� �Ѱܳ�");
		} finally {
			//�ٽ��Լ� ���� ��
			System.out.println("���� ��, �������� ������");
		}
	}

	
}
