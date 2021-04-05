package com.java.bank.aop;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {
		
		public static Logger logger
		= Logger.getLogger(LogAspect.class.getName());
		
		public static final String logMsg="LogMsg>>>>>";
		
		public Object advice(ProceedingJoinPoint pjp) {
			Object obj=null;
			
			try {
				logger.info(logMsg+pjp.getTarget().getClass().getName() + "\t\t" + pjp.getSignature().getName());
				//dao의 결과값이 리턴된 내용이 joinPoint에서도 가지고 있다
				//Object로 결과값이 들어오기에
				obj = pjp.proceed();
			} catch (Throwable e) {

			}
			
			return obj;
		};
}
