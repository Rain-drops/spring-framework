package org.springframework.testsgj.ioc.bean;

public class SystemUserBean {
	private UserBean userBean;

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
}
