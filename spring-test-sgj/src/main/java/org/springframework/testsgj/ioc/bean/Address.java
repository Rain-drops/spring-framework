package org.springframework.testsgj.ioc.bean;

public class Address {
	private String city;
	private String town;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	@Override
	public String toString() {
		return "Address{" +
				"city='" + city + '\'' +
				", town='" + town + '\'' +
				'}';
	}
}
