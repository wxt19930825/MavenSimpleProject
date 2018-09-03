package com.SpringBootProject.study.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.SpringBootProject.study.model.Person;


public interface PersonRepository extends JpaRepository<Person, Long>  {
	
	List<Person> findByAddress(String address);
	
	Person findByNameAndAddress(String name,String address);
	
	@Query("select p from Person p where p.name= :name and p.address = :address")
	Person withNameAndAddressQuery(@Param("name") String name,@Param("address")String address);
	
	
}
