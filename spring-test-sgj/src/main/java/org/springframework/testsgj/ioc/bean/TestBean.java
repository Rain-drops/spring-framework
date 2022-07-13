package org.springframework.testsgj.ioc.bean;

public class TestBean {
	public TestBean(){
		System.out.println(this.getClass().getName().concat(" init !"));
	}

	public String getTestStr() {
		return "testStr";
	}
}
