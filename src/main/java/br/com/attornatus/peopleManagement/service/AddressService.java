package br.com.attornatus.peopleManagement.service;

import java.util.List;

import br.com.attornatus.peopleManagement.domain.entity.Address;

public interface AddressService {

	List<Address> findAll();
	
	Address insert(Address address);
	
	List<Address> findAllByPeopleId(Long peopleId);
	
	List<Address> findAllByZipCode(String zipCode);
}
