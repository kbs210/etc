package com.java.aop04;

import org.aspectj.lang.ProceedingJoinPoint;

public class PAspect {

	public void sub(ProceedingJoinPoint joinPoint) {
		try {
			//핵심함수 전
			System.out.println("강의장 입실");
			//핵심코드
			joinPoint.proceed();
			//정상적으로 종료되었을 때
			System.out.println("점심식사를 맛나게 먹는다");
		} catch (Throwable e) {
			//exception 발생시
			System.out.println("떠들어서 쫓겨남");
		} finally {
			//핵심함수 종료 후
			System.out.println("수업 끝, 강의장을 나간다");
		}
	}

	
}
