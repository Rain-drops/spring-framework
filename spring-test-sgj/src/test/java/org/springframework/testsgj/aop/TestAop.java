package org.springframework.testsgj.aop;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.testsgj.aop.bean.MyTarget;
import org.springframework.testsgj.aop.bean.ProxyInterface;
import org.springframework.testsgj.ioc.bean.Person;


public class TestAop {

	@Test
	void test1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-aop.xml");
		ProxyInterface myAOP = (ProxyInterface)context.getBean("myAOP");

		myAOP.sayHello("hi");
	}
}
