package br.com.attornatus.peopleManagement.utils;

import br.com.attornatus.peopleManagement.domain.entity.People;

public final class TestDataCreator {

	private TestDataCreator() {}
	
	public static People.Builder newPeopleBuilder() {
		return People.newBuilder()
				.id(TestConstants.DEFAULT_PEOPLE_ID)
				.name(TestConstants.DEFAULT_PEOPLE_NAME)
				.birthDate(TestConstants.DEFAULT_PEOPLE_BIRTH_DATE)
				.mainAddressId(TestConstants.DEFAULT_PEOPLE_MAIN_ADDRESS_ID);
	}
}
