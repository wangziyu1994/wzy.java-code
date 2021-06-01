package com.springsource.aopstudy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class WzyLogAopAnnotation {

	@Before(value = "execution(* com.springsource.aopstudy.WzyTarget.wzytargetMethod(..)")
	public void beforeMonitor(){
		doException("beforeMonitorException");
		System.out.println("我是WzyAspec的before方法");

	}
	@After(value = "execution(* com.springsource.aopstudy.WzyTarget.wzytargetMethod(..)")
	public void afterMonitor(){
		System.out.println("我是WzyAspec的after方法");
		//doException("afterMonitorException");
		System.out.println("我是WzyAspec的after异常后的方法");
	}
	@Around(value = "execution(* com.springsource.aopstudy.WzyTarget.wzytargetMethod(..)")
	public void aroundMonitor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("我是WzyAspec的aroundMonitor之前的方法");
		proceedingJoinPoint.proceed();
		//doException("aroundMonitorException");
		System.out.println("我是WzyAspec的aroundMonitor之后的方法");
	}

	@AfterReturning(value = "execution(* com.springsource.aopstudy.WzyTarget.wzytargetMethod(..)")
	public void afterReturnMonitor(){
		System.out.println("我是WzyAspec的afterReturnMonitor方法");
	}

	@AfterThrowing(value = "execution(* com.springsource.aopstudy.WzyTarget.wzytargetMethod(..)")
	public void afterThrowMonitor(){
		System.out.println("我是WzyAspec的afterThrowMonitor方法");
	}

	public void doException(String name){
		throw new ArithmeticException(name);
	}
}
