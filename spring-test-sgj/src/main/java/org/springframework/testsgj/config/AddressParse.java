package org.springframework.testsgj.config;

import org.springframework.testsgj.bean.Address;

import java.beans.PropertyEditorSupport;

public class AddressParse extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		final String[] vals = text.split(",");
		Address addr = new Address();
		addr.setTown(vals[0]);
		addr.setCity(vals[1]);
		setValue(addr);
	}
}
