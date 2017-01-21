package com.example.storeManagement;

import com.example.storeManagement.domain.Person;
import com.example.storeManagement.domain.Student;
import com.example.storeManagement.services.Student.StudentManagement;
import com.example.storeManagement.services.person.PersonNotFoundException;
import com.example.storeManagement.services.person.PersonService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class PersonController {

	@Autowired
	private PersonService personService;

	private StudentManagement studentManagementService;
	private Student student;

	@RequestMapping(value={"/"},method = RequestMethod.GET)
	public String listPerson(ModelMap model) throws PersonNotFoundException {
	 List<Person> personList=personService.listPersons();
		model.addAttribute("personList",personList);
		return "allPerson";
	}
	@RequestMapping(value={"/newPerson"},method = RequestMethod.GET)
	public String NewPerson(ModelMap model) {
		Person person= new Person();
		model.addAttribute("person",person);
		return "person";
	}

	@RequestMapping(value = {"/newPerson"},method = RequestMethod.POST)
	public String savePerson(@Validated Person person, BindingResult result, ModelMap modelMap){
		if(result.hasErrors()){
			return "allPerson";
		}
		personService.addPerson(person);
		modelMap.addAttribute("sucess","Person" + person.getName() + "Registered Sucessfully");
		return "sucess";
	}

		@RequestMapping(value ={"/edit-{id}-person"} ,method = RequestMethod.GET)
		public String EditPerson(@PathVariable int id ,ModelMap modelMap ) {
		Person person= new Person();
		person=personService.getPersonById(id);
		modelMap.addAttribute("person",person);
			modelMap.addAttribute("edit",true);
		return "person";
	}
	@RequestMapping(value = {"/edit-{id}-person"},method = RequestMethod.POST)
	public String UpdatePerson(@Validated Person person,BindingResult result,ModelMap modelMap,@PathVariable int id){
		personService.updatePerson(person);
		modelMap.addAttribute("sucess" + person.getName() + "  " + person.getCountry() + "is sucessfully updated");
		return "sucess";
	}
}
