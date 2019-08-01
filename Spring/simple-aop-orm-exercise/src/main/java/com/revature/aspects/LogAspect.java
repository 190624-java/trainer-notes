package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	private static Logger logger;
	
	@Pointcut("within(com.revature.repository)")
	public void dbOps() {}
	
	@AfterReturning(value="dbOps()", returning = "returnValue")
	public void afterDbOp(Object returnValue, JoinPoint jp) {
		logger  = Logger.getLogger(jp.getClass());
		String methodName = jp.getSignature().getName();
		if(methodName.contains("save")) {
			logger.info("A " + jp.getClass().getTypeName() + " record was saved to the database.");
		} else if (methodName.contains("get")) { 
			logger.info("The following records were retrieved: ");
			logger.info(returnValue.toString());
		} else if (methodName.contains("delete")) {
			logger.info("A " + jp.getClass().getTypeName() + " record was deleted from the database.");
		}
	}
	
	@AfterThrowing(value="dbOps()", throwing = "e")
	public void afterDbOp(Throwable e, JoinPoint jp) {
		logger  = Logger.getLogger(jp.getClass());
		String methodName = jp.getSignature().getName();
		if(methodName.contains("save")) {
			logger.error("The following exception occurred while trying to save a " + jp.getClass().getTypeName() + " record:");
			logger.error(e.getClass().getTypeName() + ": " + e.getMessage());
		} else if (methodName.contains("get")) { 
			logger.error("The following exception occurred while trying to get a " + jp.getClass().getTypeName() + " record(s):");
			logger.error(e.getClass().getTypeName() + ": " + e.getMessage());
		} else if (methodName.contains("delete")) {
			logger.error("The following exception occurred while trying to delete a " + jp.getClass().getTypeName() + " record:");
			logger.error(e.getClass().getTypeName() + ": " + e.getMessage());
		}
	}
	
}
