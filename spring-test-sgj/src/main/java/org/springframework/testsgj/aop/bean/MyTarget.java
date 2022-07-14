package org.springframework.testsgj.aop.bean;

/**
 * 被代理的对象
 * @author ccy
 */
public class MyTarget implements ProxyInterface{
	@Override
	public void sayHello(String str) {
		System.out.println(str);
	}
}
