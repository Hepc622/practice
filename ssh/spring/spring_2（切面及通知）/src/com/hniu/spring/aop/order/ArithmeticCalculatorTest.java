package com.hniu.spring.aop.order;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ArithmeticCalculatorTest {
	@Around("ArithmeticCalculatorLoging.pointCut()")
	public void testNumber(ProceedingJoinPoint joinPoint){
		int count=0;
		Object[] args = joinPoint.getArgs();
		try {
			for (Object object : args) {
				if ((Integer)object>0) {
					count++;
				}
			}
			if (count==args.length) {
				System.out.println(Arrays.asList(args)+"有"+args.length+"位都大于>0");
				joinPoint.proceed();				
			}else{
				System.out.println(Arrays.asList(args)+"有"+(args.length-count)+"位都小于<0,不合法！");
			}
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}
}
