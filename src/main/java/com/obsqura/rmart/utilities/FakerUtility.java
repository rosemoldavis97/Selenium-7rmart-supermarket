package com.obsqura.rmart.utilities;

import com.github.javafaker.Address;
import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;

public class FakerUtility {

	public String getFakeFirstName() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.firstName();

		return text;

	}

	public String getPassword() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.lastName();

		return text;
	}

	public String getFakeCityName() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.cityName();

		return text;

	}
	public String getPhoneNumber() {
		Faker faker = new Faker();
		String phoneNumber=faker.phoneNumber().phoneNumber();
		return phoneNumber;
		
	}
	public String getMaterial() {

		Faker faker = new Faker();
		Commerce commerce=faker.commerce();
		String text=commerce.material();
		return text;
	}


}
