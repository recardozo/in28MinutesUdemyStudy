package com.renato.spring.example.demo.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.renato.spring.example.demo.DemoApplication;
import com.renato.spring.example.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseSpringDataRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepository repository;

	@Test
	public void findById_coursePresent() {
		Optional<Course> optional = repository.findById(10001L);
		assertTrue(optional.isPresent());
	}

	@Test
	public void findById_courseNotPresent() {
		Optional<Course> optional = repository.findById(20001L);
		assertFalse(optional.isPresent());
	}
}
