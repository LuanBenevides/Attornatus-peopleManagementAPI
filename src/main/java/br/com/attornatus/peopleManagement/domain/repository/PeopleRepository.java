package br.com.attornatus.peopleManagement.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attornatus.peopleManagement.domain.entity.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long>{

	
}
