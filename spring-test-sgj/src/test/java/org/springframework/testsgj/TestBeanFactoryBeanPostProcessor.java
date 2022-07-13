package org.springframework.testsgj;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.testsgj.ioc.bean.Person;


public class TestBeanFactoryBeanPostProcessor {

	@Test
	void test1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-custom-editor.xml");
		final Person bean = context.getBean(Person.class);
		System.out.println(bean);

	}
}
