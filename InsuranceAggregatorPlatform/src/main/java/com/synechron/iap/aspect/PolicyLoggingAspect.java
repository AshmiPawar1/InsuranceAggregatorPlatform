package com.synechron.iap.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class PolicyLoggingAspect {

	private Logger logger = Logger.getLogger(PolicyLoggingAspect.class.getName());

	
	
	@Pointcut(value = "execution(* com.synechron.iap.controller.PolicyController.*(..))||"
			+"execution(* com.synechron.iap.service.PolicyService.*(..))")
	public void logMethod() {
		
	}
	
//	@Pointcut(value = "execution(* com.synechron.iap.service.PolicyService.*(..))")
//	public void service() {
//		
//	}
	
	@Before("logMethod()")
	public void logBefore(JoinPoint joinPoint){
		logger.info("======LogService logBefore()=====");
		logger.info("Before method:" + joinPoint.getSignature());

		
	}
	
	@After("logMethod()")
	public void logAfter(JoinPoint joinPoint){
		logger.info("======LogService logAfter()=====");
		logger.info("After method:" + joinPoint.getSignature());

		
	}
	
	@AfterThrowing("logMethod()")
	public void logThrowing(JoinPoint joinPoint){
		logger.info("LogService logThrowing ()");
		logger.info("After throwing method:" + joinPoint.getSignature());
	}
	
	
}

