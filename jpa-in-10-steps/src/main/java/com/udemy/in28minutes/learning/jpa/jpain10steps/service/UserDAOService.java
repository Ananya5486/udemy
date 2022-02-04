package com.udemy.in28minutes.learning.jpa.jpain10steps.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.udemy.in28minutes.learning.jpa.jpain10steps.entity.User;

@Repository
@Transactional
public class UserDAOService {
	@PersistenceContext
	private EntityManager entityManager;

	public long insert(User user) {
		// open transaction
		entityManager.persist(user);
		// close transcation
		return user.getId();
	}
}
