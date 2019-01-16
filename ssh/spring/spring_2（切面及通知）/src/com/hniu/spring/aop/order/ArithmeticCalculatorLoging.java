package com.hniu.spring.aop.order;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class ArithmeticCalculatorLoging {
	
	/**
	 * 声明一个切入点表达式,该方法不添加任何代码
	 * 其他通知可以直接通过引用类名加方法名即可添加切入点
	 */
	@Pointcut("execution(* com.hniu.spring.aop.order.ArithmeticCalculator.*(..))")
	public void pointCut() {
	}

	// 在执行目标方法之前执行
	@Before("pointCut()")
	public void printLogingBefore(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("the " + method + " method start"
				+ Arrays.asList(args));
	}

	// 不管被执行的方法有没有出错误，都会执行，有点和异常的finally相似
	@After("pointCut()")
	public void pringLogingAfter(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("the " + method + " method end"
				+ Arrays.asList(args));
	}

	// 返回通知，目标方法执行放回结果之后执行
	@AfterReturning(pointcut = "pointCut()", returning = "r")
	public void pringtResult(Object r) {
		System.out.println("this is result " + r);
	}

	// 异常通知，目标方法执行出错之后的时候执行
	@AfterThrowing(pointcut = "pointCut()", throwing = "e")
	public void printErro(Exception e) {
		System.out.println(e);
	}

	// 环绕通知
	// @Around("pointCut()")
	// public Object around(ProceedingJoinPoint joinPoint){
	// private Object proceed;
	// try {
	// //前置通知
	// System.out.println("around 被代理对象方法执行之前");
	// proceed = joinPoint.proceed();
	// System.out.println("around 被代理对象方法放回结果执行之后");
	// return proceed;
	// } catch (Throwable e) {
	// e.printStackTrace();
	// System.out.println("around "+e);
	// }
	// System.out.println("around 被代理对象方法执行之后");
	// return proceed;
	// }
}