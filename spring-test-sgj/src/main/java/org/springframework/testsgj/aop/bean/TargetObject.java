package org.springframework.testsgj.aop.bean;

public class TargetObject implements MyInterface{

	@Override
	public void play() {
		System.out.println("~~~~~~~~~");
	}
}
