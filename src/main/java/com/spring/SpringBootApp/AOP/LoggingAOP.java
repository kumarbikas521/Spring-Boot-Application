package com.spring.SpringBootApp.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAOP {

	Logger log = LoggerFactory.getLogger(LoggingAOP.class);

	@Pointcut(value="execution(* com.practice.*.*.*(..))")
	private void LoggingPointCut() {

	}

	@Around("LoggingPointCut()")
	public Object loggAroungAllMethod(ProceedingJoinPoint pjp) throws Throwable {
		String className = pjp.getTarget().getClass().getName();
		String methodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		ObjectMapper mapper = new ObjectMapper();

		log.info("Class : " + className + ", Method : " + methodName + ", Arguments : "
				+ mapper.writeValueAsString(args));
		Object returnObject = pjp.proceed();
		log.info("Class : " + className + ", Method : " + methodName + ", Return object : "
				+ mapper.writeValueAsString(returnObject));
		return returnObject;
	}

	@Around("@annotation(com.practice.Annotation.TrackTime)")
	private Object trackTime(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object obj = pjp.proceed();
		Long endTime = System.currentTimeMillis();
		log.info("Total time in millisecond to execute the method " + pjp.getSignature().getName() + " is "
				+ (endTime - startTime));
		return obj;
	}
}
