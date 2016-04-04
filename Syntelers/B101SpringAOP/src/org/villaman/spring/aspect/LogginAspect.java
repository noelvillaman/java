package org.villaman.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogginAspect {

	@Before("execution(public * get*())")
	public void LogginAdvice() {
		System.out.println("Advice run. Get Method called.");
	}

	@Before("allGetters() && allInCircle()")
	public void secondAdvice() {
		System.out.println("Second advice. Get Method called.");
	}

	//@Around("allGetters()")
	@Around("@annotation(org.villaman.spring.aspect.Loggable)")
	public Object myAroundMethod(ProceedingJoinPoint proceedingJointPoint) {
		Object valueReturn = null;
		try {
			System.out.println("this is before");
			 valueReturn = proceedingJointPoint.proceed();
		} catch (Throwable e) {
			System.out.println("This is after");
			e.printStackTrace();
		}
		
		System.out.println("This is after finally advice");
		return valueReturn;
	}

	@Pointcut("execution(public * get*())")
	public void allGetters() {
	}

	@Pointcut("within(org.villaman.spring.model.Circle)")
	public void allInCircle() {
	}
}
