package com.example.storeManagement.services.person;

import java.util.List;

import com.example.storeManagement.domain.Person;

public interface PersonService {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons() throws PersonNotFoundException;
	public Person getPersonById(int id);
	public void removePerson(int id);
	
}
