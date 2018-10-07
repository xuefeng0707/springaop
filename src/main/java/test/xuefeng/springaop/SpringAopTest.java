package test.xuefeng.springaop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.xuefeng.springaop.service.MyService;

public class SpringAopTest {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		MyService myService = context.getBean(MyService.class);
		String result = myService.sayHello("world");

		System.out.println("sayHello result : " + result);

		context.close();
	}
}
