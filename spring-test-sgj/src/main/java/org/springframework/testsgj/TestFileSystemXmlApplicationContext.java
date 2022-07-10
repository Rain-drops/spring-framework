package org.springframework.testsgj;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.testsgj.bean.TestBean;



public class TestFileSystemXmlApplicationContext {

	@Test
	public void test() {

		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:spring-bean.xml");

		TestBean testBean = (TestBean)applicationContext.getBean("testBean");

		Assert.assertEquals("testStr", testBean.getTestStr());

	}
}
