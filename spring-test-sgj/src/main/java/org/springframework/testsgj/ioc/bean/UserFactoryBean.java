package org.springframework.testsgj.ioc.bean;

import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean<UserBean> {
	@Override
	public boolean isSingleton() {
//		return FactoryBean.super.isSingleton();
		return true;
	}

	@Override
	public UserBean getObject() throws Exception {
		return UserBean.createInstance();
	}

	@Override
	public Class<?> getObjectType() {
		return UserBean.class;
	}
}
