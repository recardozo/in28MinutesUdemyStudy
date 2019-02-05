package com.renato.spring.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renato.spring.example.demo.entity.Course;
import com.renato.spring.example.demo.entity.FullTimeEmployee;
import com.renato.spring.example.demo.entity.PartTimeEmployee;
import com.renato.spring.example.demo.entity.Review;
import com.renato.spring.example.demo.entity.Student;
import com.renato.spring.example.demo.repository.CourseRepository;
import com.renato.spring.example.demo.repository.EmployeeRepository;
import com.renato.spring.example.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 Course course = courseRepository.findById(10001L);
		 courseRepository.save(course);
		 log.info("Executing course--->", course);
		
		 studentRepository.saveStudentWithPassport();
		 List<Review> reviews = new ArrayList<>();
		 reviews.add(new Review("Gratefull course", "5"));
		 reviews.add(new Review("It could be better", "3"));
		 courseRepository.addReviewsCourse(10003L, reviews);
		
		 studentRepository.insertStudentAndCourse(new Student("Jack"), new
		 Course("Jack's Course"));
		
		 employeeRepository.insert(new PartTimeEmployee("John", new
		 BigDecimal("50")));
		 employeeRepository.insert(new FullTimeEmployee("David", new
		 BigDecimal("1000")));
		
		 log.info("list the employees---->",
		 employeeRepository.retriveAllEmployees());

	}

}
