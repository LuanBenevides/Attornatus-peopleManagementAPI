package br.com.attornatus.peopleManagement.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.peopleManagement.domain.entity.People;
import br.com.attornatus.peopleManagement.service.PeopleService;

@RestController
public class PeopleRestController {
	
	@Autowired
	private PeopleService businessLayer;
	
	@GetMapping("peoples")
	public ResponseEntity<List<People> > findAllPeoples() {
		List<People> peoples = businessLayer.findAll();
		return ResponseEntity.ok(peoples);
	}

	@GetMapping("peoples/{id}")
	public ResponseEntity<People> getPeopleById(@PathVariable Long id) throws ParseException{
		return ResponseEntity.ok(businessLayer.findById(id));
	}
	
	@PostMapping("peoples")
	public ResponseEntity<People> insertPeople(@RequestBody People people) {
		businessLayer.insert(people);
		return ResponseEntity.ok(people);
	}
	
	@PutMapping("peoples/{id}")
	public ResponseEntity<People> updatePeople(@PathVariable Long id ,@RequestBody People People){
		businessLayer.update(id, People);
		return ResponseEntity.ok(People);
	}

	@DeleteMapping("peoples/{id}")
	public ResponseEntity<People> detelePeople(@PathVariable Long id) {
		businessLayer.delete(id);
		return ResponseEntity.ok().build();
	}
}
