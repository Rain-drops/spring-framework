package org.springframework.testsgj.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.testsgj.ioc.bean.UserBean;

public class TestSpringBeanInstantiation {
	/**
	 * bean 的实例化有如下几种方法
	 * 1. 静态方法
	 * 2. 工厂方法创建
	 * 3. FactoryBean 接口创建
	 * @param args
	 */
	public static void main(String[] args) {
		BeanFactory context = new ClassPathXmlApplicationContext(
				"spring-bean-instantiation.xml");

		UserBean staticMethodBean = context.getBean("static-method-user", UserBean.class);
		UserBean factoryUser = context.getBean("factory-user", UserBean.class);
		UserBean factoryBean = context.getBean("factory-bean-user", UserBean.class);
		System.out.println();

	}
}
