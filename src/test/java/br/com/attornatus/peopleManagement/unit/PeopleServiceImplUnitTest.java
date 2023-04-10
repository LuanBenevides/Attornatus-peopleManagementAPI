package br.com.attornatus.peopleManagement.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import br.com.attornatus.peopleManagement.core.BaseUnitTest;
import br.com.attornatus.peopleManagement.domain.entity.People;
import br.com.attornatus.peopleManagement.domain.repository.PeopleRepository;
import br.com.attornatus.peopleManagement.exception.BusinessException;
import br.com.attornatus.peopleManagement.exception.PeopleNotFoundException;
import br.com.attornatus.peopleManagement.service.impl.PeopleServiceImpl;
import br.com.attornatus.peopleManagement.utils.TestConstants;
import br.com.attornatus.peopleManagement.utils.TestDataCreator;

class PeopleServiceImplUnitTest extends BaseUnitTest{

	private PeopleServiceImpl victim;
	
	@Mock
	private PeopleRepository peopleRepository;
	
	@BeforeEach
	void setupEach() {
		victim = new PeopleServiceImpl(peopleRepository);
	}
	
	@Test
	void whenTestFindByIdReturnSuccess() {
		var people = TestDataCreator.newPeopleBuilder().build();
		when(peopleRepository.findById(TestConstants.DEFAULT_PEOPLE_ID))
		.thenReturn(Optional.of(people));
		
		var victimPeople = victim.findById(TestConstants.DEFAULT_PEOPLE_ID);
		
		assertEquals(victimPeople.getId(), people.getId());
		assertEquals(victimPeople.getName(), people.getName());
		assertEquals(victimPeople.getBirthDate(), people.getBirthDate());
		assertEquals(victimPeople.getMainAddressId(), people.getMainAddressId());
	}
	
	@Test
	void whenTestFindByIdReturnNotFound() {
		when(peopleRepository.findById(TestConstants.DEFAULT_PEOPLE_ID)).thenReturn(Optional.empty());
		assertThrows(PeopleNotFoundException.class,() -> victim.findById(TestConstants.DEFAULT_PEOPLE_ID));
	}
	
	@Test
	void whenTestFindAllReturnAnListOfPeople() {
		var people = TestDataCreator.newPeopleBuilder().build();
		when(peopleRepository.findAll()).thenReturn(List.of(people));
		List<People> response = victim.findAll();
		
		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals(People.class, response.get(0).getClass());
		
		assertEquals(TestConstants.DEFAULT_PEOPLE_ID, response.get(0).getId());
		assertEquals(TestConstants.DEFAULT_PEOPLE_NAME, response.get(0).getName());
		assertEquals(TestConstants.DEFAULT_PEOPLE_BIRTH_DATE, response.get(0).getBirthDate());
		assertEquals(TestConstants.DEFAULT_PEOPLE_MAIN_ADDRESS_ID, response.get(0).getMainAddressId());
	}
	
	@Test
	void whenTestInsertThenReturnSuccess() {
		var people = TestDataCreator.newPeopleBuilder().id(null).build();
		when(peopleRepository.save(any())).thenReturn(people);
		var insertPeople = victim.insert(people);

		assertNotNull(insertPeople);
		assertEquals(insertPeople.getClass(), people.getClass());
		assertEquals(insertPeople.getId(), people.getId());
		assertEquals(insertPeople.getName(), people.getName());
		assertEquals(insertPeople.getBirthDate(), people.getBirthDate());
		assertEquals(insertPeople.getMainAddressId(), people.getMainAddressId());
		
	}

	@Test
	void whenTestInsertWhereIdNotNull() {
		var people = TestDataCreator.newPeopleBuilder().build();
		assertThrows(BusinessException.class, () -> victim.insert(people));
	}

	@Test
	void whenTestUpdateThenReturnSuccess() {
		var people = TestDataCreator.newPeopleBuilder().build();
		var peopleUpdated = TestDataCreator.newPeopleBuilder().mainAddressId(2L).build();
		when(peopleRepository.findById(people.getId())).thenReturn(Optional.of(people));
		when(peopleRepository.save(any())).thenReturn(peopleUpdated);

		var finalPeople = victim.update(people.getId(), peopleUpdated);

		assertNotNull(finalPeople);
		assertEquals(finalPeople.getClass(), peopleUpdated.getClass());
		assertEquals(finalPeople.getId(), peopleUpdated.getId());
		assertEquals(finalPeople.getName(), peopleUpdated.getName());
		assertEquals(finalPeople.getBirthDate(), peopleUpdated.getBirthDate());
		assertEquals(finalPeople.getMainAddressId(), peopleUpdated.getMainAddressId());
	}

	@Test
	void whenTestUpdateThenReturnDifferentIdError() {
		var people = TestDataCreator.newPeopleBuilder().build();
		var peopleUpdated = TestDataCreator.newPeopleBuilder().id(4L).mainAddressId(2L).build();
		when(peopleRepository.findById(people.getId())).thenReturn(Optional.of(people));

		assertThrows(BusinessException.class, () -> victim.update(people.getId(), peopleUpdated));
	}

	@Test
	void whenDeletePeopleReturnOk() {
		var peopleDeleted = TestDataCreator.newPeopleBuilder().build();
		when(peopleRepository.findById(peopleDeleted.getId())).thenReturn(Optional.of(peopleDeleted));

		var victimReturn = victim.delete(peopleDeleted.getId());

		assertNotNull(victimReturn);
		assertEquals(peopleDeleted.getClass(), victimReturn.getClass());
	}

	@Test
	void whenDeletePeopleReturnException() {
		assertThrows(PeopleNotFoundException.class, () -> victim.delete(5L));
	}
}
