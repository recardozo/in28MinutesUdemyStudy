package com.renato.spring.example.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.renato.spring.example.demo.entity.Course;
import com.renato.spring.example.demo.entity.Review;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	public Course save(Course course) {

		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}

		return course;
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}

	public void playWithEntityManager() {
		Course course1 = new Course("Web Services in 100 Steps");
		em.persist(course1);

		Course course2 = findById(10001L);

		course2.setName("JPA in 50 Steps - Updated");

	}

	public void addReviewsCourse() {
		// get the course 10003L
		Course course = findById(10003L);
		log.info("course.getReviews -->", course.getReviews());

		// add 2 reviews
		Review review1 = new Review("Greatfull course", "5");
		review1.setCourse(course);
		Review review2 = new Review("Wonderfull course", "4");
		review2.setCourse(course);

		course.addReview(review1);
		course.addReview(review2);

		// save to databse
		em.persist(review1);
		em.persist(review2);
	}

}
