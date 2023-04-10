package br.com.attornatus.peopleManagement.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import br.com.attornatus.peopleManagement.core.BaseUnitTest;
import br.com.attornatus.peopleManagement.domain.entity.Address;
import br.com.attornatus.peopleManagement.domain.repository.AddressRepository;
import br.com.attornatus.peopleManagement.exception.BusinessException;
import br.com.attornatus.peopleManagement.service.impl.AddressServiceImpl;
import br.com.attornatus.peopleManagement.utils.TestConstants;
import br.com.attornatus.peopleManagement.utils.TestConstantsAddress;
import br.com.attornatus.peopleManagement.utils.TestDataCreatorAddress;

public class AddressServiceImplUnitTest extends BaseUnitTest{

	private AddressServiceImpl victim;
	
	@Mock
	private AddressRepository addressRepository;

	@BeforeEach
	void setupEach() {
		victim = new AddressServiceImpl(addressRepository);
	}
	@Test
	void whenFindAllReturnAnListOfAdresses() {
		var address = TestDataCreatorAddress.newAddressBuilder().build();
		when(addressRepository.findAll()).thenReturn(List.of(address));
		List<Address> response = victim.findAll();

		var object = response.get(0);

		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals(Address.class, object.getClass());

		assertEquals(TestConstantsAddress.DEFAULT_ADDRESS_ID, object.getId());
		assertEquals(TestConstantsAddress.DEFAULT_ADDRESS_PUBLIC_PLACE, object.getPublicPlace());
		assertEquals(TestConstantsAddress.DEFAULT_ADDRESS_ZIP_CODE, object.getZipCode());
		assertEquals(TestConstantsAddress.DEFAULT_ADDRESS_NUMBER, object.getNumber());
		assertEquals(TestConstantsAddress.DEFAULT_CITY, object.getCity());
		assertEquals(TestConstantsAddress.DEFAULT_ADDRESS_PEOPLE_ID, object.getPeopleId());
	}

	@Test
	void whenTestFindByZipCodeReturnAddress() {
		var address = TestDataCreatorAddress.newAddressBuilder().build();
		when(addressRepository.findAllByZipCode(TestConstantsAddress.DEFAULT_ADDRESS_ZIP_CODE))
				.thenReturn(List.of(address));
		List<Address> response = victim.findAllByZipCode(TestConstantsAddress.DEFAULT_ADDRESS_ZIP_CODE);

		var object = response.get(0);

		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals(Address.class, object.getClass());
		assertEquals(TestConstantsAddress.DEFAULT_ADDRESS_ID, object.getId());
		assertEquals(TestConstantsAddress.DEFAULT_ADDRESS_PUBLIC_PLACE, object.getPublicPlace());
		assertEquals(TestConstantsAddress.DEFAULT_ADDRESS_ZIP_CODE, object.getZipCode());
		assertEquals(TestConstantsAddress.DEFAULT_ADDRESS_NUMBER, object.getNumber());
		assertEquals(TestConstantsAddress.DEFAULT_CITY, object.getCity());
		assertEquals(TestConstantsAddress.DEFAULT_ADDRESS_PEOPLE_ID, object.getPeopleId());
	}

	@Test
	void whenFindAllByPeopleIdReturnAddress() {
		var address = TestDataCreatorAddress.newAddressBuilder().build();
		when(addressRepository.findAllByPeopleId(TestConstants.DEFAULT_PEOPLE_ID)).thenReturn(List.of(address));
		List<Address> response = victim.findAllByPeopleId(TestConstants.DEFAULT_PEOPLE_ID);

		var object = response.get(0);

		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals(Address.class, object.getClass());
		assertEquals(TestConstantsAddress.DEFAULT_ADDRESS_PEOPLE_ID, object.getPeopleId());
		assertEquals(TestConstantsAddress.DEFAULT_ADDRESS_ID, object.getId());
		assertEquals(TestConstantsAddress.DEFAULT_ADDRESS_PUBLIC_PLACE, object.getPublicPlace());
		assertEquals(TestConstantsAddress.DEFAULT_ADDRESS_ZIP_CODE, object.getZipCode());
		assertEquals(TestConstantsAddress.DEFAULT_ADDRESS_NUMBER, object.getNumber());
		assertEquals(TestConstantsAddress.DEFAULT_CITY, object.getCity());
	}

	@Test
	void whenTestInsertThenReturnSuccess() {
		var address = TestDataCreatorAddress.newAddressBuilder().id(null).build();
		when(addressRepository.save(any())).thenReturn(address);
		var insertAddress = victim.insert(address);

		assertNotNull(insertAddress);
		assertEquals(insertAddress.getClass(), address.getClass());
		assertEquals(insertAddress.getId(), address.getId());
		assertEquals(insertAddress.getPublicPlace(), address.getPublicPlace());
		assertEquals(insertAddress.getZipCode(), address.getZipCode());
		assertEquals(insertAddress.getCity(), address.getCity());
		assertEquals(insertAddress.getNumber(), address.getNumber());
		assertEquals(insertAddress.getPeopleId(), address.getPeopleId());
	}

	@Test
	void whenTestInsertWhereIdNotNull() {
		var address = TestDataCreatorAddress.newAddressBuilder().build();
		assertThrows(BusinessException.class, () -> victim.insert(address));
	}
}
