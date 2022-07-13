package org.springframework.testsgj.ioc.bean;

public class UserBeanFactoryImpl implements UserBeanFactory{
	@Override
	public UserBean factory() {
		return UserBean.createInstance();
	}
}
