package com.revature.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

	//NOT BEST PRACTICE:
	@After("execution(* get*())")
	public void auditGet() {
		//This will execute AFTER any method that 
		//starts with 'get' and takes NO input parameters
		System.out.println("[@After] Auditing...");
	}
	
	/*
	 * This will execute only if the method returns successfully
	 * Applies to methods with:
	 * 	- any return type
	 * 	- start with 'get'
	 * 	- take ONE OR MORE input params
	 */
	@AfterReturning(value="execution(* get*(*))", returning = "obj")
	public Object returning(Object obj) {
		System.out.println("[@AfterReturning] Auditing..." + obj);
		//you cannot effect the return value
		obj = null;//this doesn't do anything
		return obj;//this also doesn't do anything
	}
	
	/*
	 * Applies to methods with:
	 * 	- any return type
	 * 	- starts with 'get'
	 * 	- takes 0 to many input params
	 */
	@Before("execution(* get*(..))")
	public void allGet() {
		System.out.println("[@Before] Auditing 0 to many params..");
	}
	
	/*
	 * Applies to methods that:
	 * 	- have any return type
	 * 	- are called 'search'
	 * 	- take 0 to many input params
	 * 	- throw an exception
	 */
	@AfterThrowing(value="execution(* search(..))", throwing = "e")
	public void exception(Throwable e) {
		System.out.println("[@AfterThrowing] Exception thrown! " + e);
	}
	
	/*
	 * Applied to methods that:
	 * 	- have return type String
	 * 	- are called 'findOne'
	 * 	- take 0 to many input parameters
	 * 
	 * Around allows you to control what happens before the
	 * method executes, when the method executes, and after
	 * the method executes. You can effect the return value,
	 * but you must return that value explicitly.
	 */
	
	@Around("execution(String findOne(..))")
	public Object round(ProceedingJoinPoint joinpoint) {
		//programmatically do Before logic
		System.out.println("[@Around] Before...");
		
		//execute the joinpoint
		Object returnValue;
		try {
			returnValue = joinpoint.proceed();//This tells Spring to execute the findOne method
			System.out.println("[@Around] Returned: " + returnValue);
		} catch (Throwable e) {
			returnValue = "Jessica Colson";
		}
		
		//programmatically do After logic
		System.out.println("[@Around] After...");
		return returnValue;
	}
	
	/*
	 * we saw how to use 'execution()', but we also have 'within()'
	 * 
	 * Examples:
	 * @Before("within(com.revature.aop.service.HeroService)")
	 * 	- will apply to ALL methods within the HeroService class.
	 * 
	 * @After("within(com.revature.aop)")
	 * 	- apply to ALL methods within the aop package.
	 * 
	 * 
	 * For any type of advice, we can pass in an object of type JoinPoint
	 * which will essentially allows us to get information about the method 
	 * (aka the join point). 
	 */
	
	@Before("within(com.revature.aop.service.HeroService)")
	public void withinService(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		if(args.length == 1) {
			System.out.println("The method takes one argument. Of Type: " +
					args[0].getClass().getTypeName());
		} else {
			System.out.println("The method takes " + args.length + " arguments.");
		}
	}
	
}
