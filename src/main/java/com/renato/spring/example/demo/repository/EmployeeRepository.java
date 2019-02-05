package com.renato.spring.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.renato.spring.example.demo.entity.Course;
import com.renato.spring.example.demo.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	EntityManager em;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	public void insert(Employee employee) {
		em.persist(employee);
	}

	public List<Employee> retriveAllEmployees() {
		return em.createQuery("select e from Employee e ", Employee.class).getResultList();
	}

}
