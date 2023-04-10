package br.com.attornatus.peopleManagement.utils;

import br.com.attornatus.peopleManagement.domain.entity.Address;
import br.com.attornatus.peopleManagement.domain.entity.People;

public final class TestDataCreatorAddress {

	private TestDataCreatorAddress() {}
	
	public static Address.Builder newAddressBuilder() {
		return Address.newBuilder()
				.id(TestConstantsAddress.DEFAULT_ADDRESS_ID)
				.publicPlace(TestConstantsAddress.DEFAULT_ADDRESS_PUBLIC_PLACE)
				.zipCode(TestConstantsAddress.DEFAULT_ADDRESS_ZIP_CODE)
				.number(TestConstantsAddress.DEFAULT_ADDRESS_NUMBER)
				.city(TestConstantsAddress.DEFAULT_CITY)
				.peopleId(TestConstantsAddress.DEFAULT_ADDRESS_PEOPLE_ID);
	}
}
