package com.application.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.model.Form;

@Repository
public interface FormRepository extends JpaRepository<Form, Integer>{

	@Transactional
	void deleteByUserId(int id);
	
	Form findByUserId(int userId);
	
}
