package com.application.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.model.TaskDetails;

public interface TaskDetailsRepository extends JpaRepository<TaskDetails, Integer>{
	
	List<TaskDetails> findByUserId(int userId);

	@Transactional
	void deleteByUserId(int userId);

}
