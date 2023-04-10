package br.com.attornatus.peopleManagement.service;

import java.util.List;

import br.com.attornatus.peopleManagement.domain.entity.People;

public interface PeopleService {

	List<People> findAll();
	
	People findById(Long id);
	
	People insert(People people);
	
	People update(Long id, People people);

	People delete(Long id);
	
}
