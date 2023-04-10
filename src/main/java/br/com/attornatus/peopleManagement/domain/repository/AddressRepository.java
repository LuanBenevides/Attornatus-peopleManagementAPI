package br.com.attornatus.peopleManagement.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attornatus.peopleManagement.domain.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	List<Address> findAllByPeopleId(Long peopleId);
	
	List<Address> findAllByZipCode(String zipCode);
}
