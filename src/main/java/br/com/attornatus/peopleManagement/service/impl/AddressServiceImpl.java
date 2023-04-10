package br.com.attornatus.peopleManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.attornatus.peopleManagement.domain.entity.Address;
import br.com.attornatus.peopleManagement.domain.repository.AddressRepository;
import br.com.attornatus.peopleManagement.exception.BusinessException;
import br.com.attornatus.peopleManagement.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	private AddressRepository repository;
	
	public AddressServiceImpl(AddressRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Address> findAll() {
		return repository.findAll();
	}
	
	@Override
	public List<Address> findAllByPeopleId(Long peopleId) {
		return repository.findAllByPeopleId(peopleId);
	}

	@Override
	public List<Address> findAllByZipCode(String zipCode) {
		return repository.findAllByZipCode(zipCode);
	}
	
	@Override
	public Address insert(Address address) {
		if(address.getId() != null) {
			throw new BusinessException("O ID é diferente de NULL na inclusão");
		}
		repository.save(address);
		return address;
	}

}
