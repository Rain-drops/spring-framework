package org.springframework.testsgj.ioc;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.testsgj.ioc.bean.TestBean;


public class TestFileSystemXmlApplicationContext {

	@Test
	public void test() {

		// BeanDefinition的资源定位过程
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:spring-bean.xml");

		TestBean testBean = (TestBean)applicationContext.getBean("testBean");
		System.out.println(testBean.getTestStr());

	}
}
