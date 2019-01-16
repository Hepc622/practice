package com.hniu.spring.aop.hello;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class ArithmeticCalculatorLoging {
	private Object proceed;

//	//在执行目标方法之前执行
//	@Before("execution(* com.hniu.spring.aop.hello.ArithmeticCalculator.*(..))")
//	public void printLogingBefore(JoinPoint joinPoint){
//		String method = joinPoint.getSignature().getName();
//		Object[] args = joinPoint.getArgs();
//		System.out.println("the "+method+" method start"+Arrays.asList(args));
//	}
//	//不管被执行的方法有没有出错误，都会执行，有点和异常的finally相似
//	@After("execution(* com.hniu.spring.aop.hello.ArithmeticCalculator.*(..))")
//	public void pringLogingAfter(JoinPoint joinPoint){
//		String method = joinPoint.getSignature().getName();
//		Object[] args = joinPoint.getArgs();
//		System.out.println("the "+method+" method end"+Arrays.asList(args));
//	}
//	//返回通知，目标方法执行放回结果之后执行
//	@AfterReturning(pointcut="execution(* com.hniu.spring.aop.hello.ArithmeticCalculator.*(..))",returning="r")
//	public void pringtResult(Object r){
//		System.out.println("this is result "+r);
//	}
//	
//	//异常通知，目标方法执行出错之后的时候执行
//	@AfterThrowing(pointcut="execution(* com.hniu.spring.aop.hello.ArithmeticCalculator.*(..))",throwing="e")
//	public void printErro(Exception e){
//		System.out.println(e);
//	}
//	
	//环绕通知
	@Around("execution(* com.hniu.spring.aop.hello.ArithmeticCalculator.*(..))")
	public Object around(ProceedingJoinPoint joinPoint){
		try {
			//前置通知
			System.out.println("around 被代理对象方法执行之前");
			proceed = joinPoint.proceed();
			System.out.println("around 被代理对象方法放回结果执行之后");
			return proceed;
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("around "+e);
		}
		System.out.println("around 被代理对象方法执行之后");
		return proceed;
	}
}