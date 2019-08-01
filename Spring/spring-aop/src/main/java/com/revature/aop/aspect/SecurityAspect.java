package com.revature.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

	//Pointcut definition
	@Pointcut("execution(public void enter())")
	public void enterPC() {} //hook method
	
	//Advice definition
	@Before(value = "enterPC()")
	public void badgeCheck() {
		System.out.println("Scaning badge and authenticating...");
	}
	
}
