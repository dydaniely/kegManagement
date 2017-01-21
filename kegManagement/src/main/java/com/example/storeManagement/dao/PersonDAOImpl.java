package com.example.storeManagement.dao;

import java.util.List;

import com.sun.tracing.dtrace.ProviderAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.example.storeManagement.domain.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
 	private HibernateTemplate hibernateTemplate;

	@Autowired
	public PersonDAOImpl(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void sethibernateTemplate(HibernateTemplate sf){
		this.hibernateTemplate = sf;
	}

	@Override
	public void addPerson(Person p) {
	//	Session session = this.hibernateTemplate.getCurrentSession();
		hibernateTemplate.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}
	@Override
	public void updatePerson(Person p) {
		//Session session = this.hibernateTemplate.getCurrentSession();
		hibernateTemplate.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		//Session session = this.hibernateTemplate.getCurrentSession();
		List<Person> personsList = (List<Person>) hibernateTemplate.find("from Person");
		for (Person p : personsList) {
			logger.info("Person List::" + p);
		}
		return personsList;
	}

	@Override
	public Person getPersonById(int id) {
		//Session session = this.hibernateTemplate.getCurrentSession();
		Person p = (Person) hibernateTemplate.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removePerson(int id) {
		//Session session = this.hibernateTemplate.getCurrentSession();
		Person p = (Person) hibernateTemplate.load(Person.class, new Integer(id));
		if(null != p){
		hibernateTemplate.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}
}
