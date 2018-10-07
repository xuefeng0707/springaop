package test.xuefeng.springaop.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Pointcut("@target(test.xuefeng.springaop.annotation.LogTime)")
	public void logTime() {

	}

	@Pointcut("this(test.xuefeng.springaop.service.MyService)")
	public void testThis() {

	}

	@Pointcut("target(test.xuefeng.springaop.service.MyService)")
	public void testTarget() {

	}

	@Around("logTime()")
	public Object aroundLogTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Method method = getMethod(joinPoint);
		Object result = joinPoint.proceed(joinPoint.getArgs());
		System.out.println(method.getName() + " time " + (System.currentTimeMillis() - start) + "ms");
		return result;
	}

	@Around("testThis()")
	public Object aroundTestThis(ProceedingJoinPoint joinPoint) throws Throwable {
		Method method = getMethod(joinPoint);
		System.out.println(method.getName() + " testThis this " + joinPoint.getThis().hashCode() + " target "
				+ joinPoint.getTarget().hashCode());
		Object result = joinPoint.proceed(joinPoint.getArgs());
		return result;
	}

	@Around("testTarget()")
	public Object aroundTestTarget(ProceedingJoinPoint joinPoint) throws Throwable {
		Method method = getMethod(joinPoint);
		System.out.println(method.getName() + " testTarget this " + joinPoint.getThis().hashCode() + " target "
				+ joinPoint.getTarget().hashCode());
		Object result = joinPoint.proceed(joinPoint.getArgs());
		return result;
	}

	private Method getMethod(ProceedingJoinPoint joinPoint) {
		return ((MethodSignature) joinPoint.getSignature()).getMethod();
	}
}
