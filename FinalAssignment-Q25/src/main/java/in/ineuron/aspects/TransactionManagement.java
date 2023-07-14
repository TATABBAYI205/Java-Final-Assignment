package in.ineuron.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {
	// Syntax:: AS RT packageName.ClassName.methodName(parameter)
	@Pointcut("execution(public * in.ineuron.service.*.saveUser())")
	public void saveOperation() {
	}

	@Pointcut("execution(public * in.ineuron.service.*.deleteUser())")
	public void deleteOperation() {
	}

	@Pointcut(("saveOperation() || deleteOperation()"))
	public void operation() {}

	@Before("operation()") // JoinPoint
	public void beginTransaction() {
		System.out.println("Transaction begin");
	}

	@After("operation()") // JoinPoint
	public void commitTransaction() {
		System.out.println("Transaction commited...");
	}
	
	@Pointcut("execution(public * in.ineuron.service.UserService.saveEmployee())")
	public void p1() {}
	
	
	@Around("p1()")
	public void aroundAdvice(ProceedingJoinPoint jp) {
		System.out.println("Before Transaction");//#1
		
		try {
			Object object = jp.proceed();  //#2
			System.out.println("Data is :: "+object);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("After Transaction");//#4
	} 
	
}
