package com.java.aop02;

import org.aspectj.lang.JoinPoint;

public class PASpect {	// ����Ŭ���� : aspect

	public void awake(JoinPoint joinPoint) {	// �����Լ� : advice
		System.out.println("�Ͼ��");
	}

	public void sleep(JoinPoint joinPoint /* �ٽ��ڵ带 ������ : JoinPoint*/) {	// �����Լ� : advice
		System.out.println("�����ܴ�");
	}
}
