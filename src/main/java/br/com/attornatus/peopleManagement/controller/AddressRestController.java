package br.com.attornatus.peopleManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.peopleManagement.domain.entity.Address;
import br.com.attornatus.peopleManagement.service.AddressService;

@RestController
public class AddressRestController {

	@Autowired
	private AddressService businessLayer;
	
	@GetMapping("adressess")
	public ResponseEntity<List<Address>> findAllAddress(){
		List<Address> adressess = businessLayer.findAll();
		return ResponseEntity.ok(adressess);
	}
	
	@GetMapping("adressess/zipCode/{zipCode}")
	public ResponseEntity<List<Address>> findAllAdressByZipCode(@PathVariable String zipCode){
		List<Address> adressess = businessLayer.findAllByZipCode(zipCode);
		return ResponseEntity.ok(adressess);
	}
	
	@GetMapping("adressess/AllAdressessByPeopleId/{peopleId}")
	public ResponseEntity<List<Address>> findAllpeopleAdresses(@PathVariable Long peopleId){
		List<Address> adressess = businessLayer.findAllByPeopleId(peopleId);
		return ResponseEntity.ok(adressess);
	}
	
	@PostMapping("adressess")
	public ResponseEntity<Address> insertAddress(@RequestBody Address address){
		businessLayer.insert(address);
		return ResponseEntity.ok(address);
	} 
}
