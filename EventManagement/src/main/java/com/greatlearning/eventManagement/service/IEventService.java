package com.greatlearning.eventManagement.service;

import java.util.List;

import com.greatlearning.eventManagement.entity.Student;

public interface IEventService {

	//find all registration details from database
	public List<Student> allRegisteredStudents();
	
	//delete registration details from database
	public void deleteRegistration(int id);
	
	//find registration details from database
	public List<Student> findRegistration(int id);
	
	//save registration details from database
	public void saveRegistration(Student s);
	
}
