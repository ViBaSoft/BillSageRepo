package com.vbasoft.billsage.utils.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggerAspect {

//	@Before("execution(*)")
	
	@Before("execution(public * com.vbasoft.*(..))")
	public void logBefore(JoinPoint point) {
		System.out.println("Logging for: " + point.getKind());
	}
}
