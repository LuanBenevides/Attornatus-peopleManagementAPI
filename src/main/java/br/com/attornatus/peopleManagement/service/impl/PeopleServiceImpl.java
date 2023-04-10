package br.com.attornatus.peopleManagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.attornatus.peopleManagement.domain.entity.People;
import br.com.attornatus.peopleManagement.domain.repository.PeopleRepository;
import br.com.attornatus.peopleManagement.exception.BusinessException;
import br.com.attornatus.peopleManagement.exception.PeopleNotFoundException;
import br.com.attornatus.peopleManagement.service.PeopleService;

@Service
public class PeopleServiceImpl implements PeopleService{

	private PeopleRepository repository;
	
	public PeopleServiceImpl(PeopleRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<People> findAll() {
		return repository.findAll();
	}
	
	@Override
	public People findById(Long id) {
		Optional<People> people = repository.findById(id);
		return  people.orElseThrow(() -> new PeopleNotFoundException("Pessoa não encontrada pelo id " + id));
	}

	@Override
	public People insert(People people) {
		if(people.getId() != null) {
			throw new BusinessException("O ID é diferente de NULL na inclusão");
		}
		var peopleInserted = repository.save(people);
		return peopleInserted;
	}

	@Override
	public People update(Long id, People people) {
		People peopleDb = findById(id);
		if(peopleDb.getId().equals(people.getId())) {
			repository.save(people);
			return people;
		} else {
			throw new BusinessException("Os ID's para alteração são divergentes");
		}
	}

	@Override
	public People delete(Long id) {
		People peopleDb = findById(id);
		repository.delete(peopleDb);
		return peopleDb;
	}
}
