package com.SpringBootProject.study.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootProject.study.dao.PersonRepository;
import com.SpringBootProject.study.model.Person;

@RestController
public class SpringJpaDataTestController {

	@Autowired
	PersonRepository personRepository;

	@RequestMapping(value="/save")
	public Object save( @Valid Person person, BindingResult result) {

		if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                return error.getDefaultMessage();
            }
        }
		
		Person p = personRepository.save(person);
		return p;
	}

	@RequestMapping("findAllPersonByAddress")
	public Object findAllPersonByAddress(String address) {
		
		List<Person> people = personRepository.findByAddress(address);
		return people;
	}

	@RequestMapping("findAllPersonByNamaAndAddress")
	public Object findAllPersonByNamaAndAddress( String name,String address) {

		Person person = personRepository.findByNameAndAddress(name, address);
		return person;

	}

	@RequestMapping("allPersonByAgeAsc")
	public List<Person> allPersonByAsc() {
		
		List<Person> persons = personRepository.findAll(new Sort(Direction.ASC, "age"));
		return persons;
	}

}
