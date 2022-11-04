package com.greatlearning.eventManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.eventManagement.entity.Student;
import com.greatlearning.eventManagement.service.EventServiceImplementation;

@Controller
public class EventManagementController {

	@Autowired
	EventServiceImplementation eventService;
	
	//Find all Registrations
	@RequestMapping("/")
	public String allRegistrations(Model theModel)
	{
		List<Student> allStudents = eventService.allRegisteredStudents();

		for (Student student : allStudents) {
			System.out.println(student.toString());
		}
		// add to the spring model
		theModel.addAttribute("Students", allStudents);
		
		return "Registration";
	}
	
	//open new registration page
	@RequestMapping("/addRegistration")
	public String addNewRegistration(Model theModel)
	{
		System.out.println("Add Triggered");
		Student student=new Student();
		theModel.addAttribute("Student", student);
		return "Registration-Form";
	}
	
	//delete saved data and reload all registration details
	@RequestMapping("/deleteDetails")
	public String deleteRegistration(@RequestParam("id") int theId)
	{
		System.out.println("Delete Triggered");
		eventService.deleteRegistration(theId);
		return "redirect:/";
	}
	
	//load saved data and open registration details
	@RequestMapping("/updateDetails")
	public String updateRegistration(@RequestParam("id") int theId, Model theModel)
	{
		System.out.println("Update Triggered");
		List<Student> studentAll = eventService.findRegistration(theId);
		Student student=studentAll.get(0);
		theModel.addAttribute("Student", student);
		return "Registration-Form";
	}
	
	//save registration details
	@PostMapping("/saveDetails")
	public String saveRegistrationDetails(@RequestParam("id") int id, 
			@RequestParam("name") String name,
			@RequestParam("department") String department, 
			@RequestParam("country") String country)
	{
		System.out.println("Save Triggered");
		Student student;
		if(id==0)
			student=new Student(name, department, country);
		else
		{
			List<Student> studentAll = eventService.findRegistration(id);
			student=studentAll.get(0);
			student.setCountry(country);
			student.setDepartment(department);
			student.setName(name);
		}
		eventService.saveRegistration(student);
		return "redirect:/";
	}
	
}
