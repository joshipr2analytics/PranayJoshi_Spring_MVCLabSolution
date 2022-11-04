package com.greatlearning.eventManagement.service;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.greatlearning.eventManagement.entity.Student;

@Repository
public class EventServiceImplementation implements IEventService {

	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	EventServiceImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	//find all registration details from database
	@Transactional
	public List<Student> allRegisteredStudents() {
		
		Transaction tx=session.beginTransaction();
		List<Student> allStudents = session.createQuery("from Student").list();
		tx.commit();
		return allStudents;
	}

	//delete registration details from database
	@Transactional
	public void deleteRegistration(int id) {
		
		Transaction tx = session.beginTransaction();

		// get transaction
		Student student = session.get(Student.class, id);

		// delete record
		session.delete(student);

		tx.commit();
		
	}

	//find registration details from database
	@Transactional
	public List<Student> findRegistration(int id) {

		Transaction tx = session.beginTransaction();

		List<Student> s = session.createQuery("from Student where id="+id).list();

		tx.commit();
		
		return s;
	}

	//save registration details from database
	@Transactional
	public void saveRegistration(Student s) {
		
		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(s);

		tx.commit();
		
	}

}
