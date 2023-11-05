package com.application.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Form;
import com.application.model.TaskDetails;
import com.application.repository.TaskDetailsRepository;

@Service
public class TaskDetailsService {

	@Autowired
	private TaskDetailsRepository taskDetailsRepository;

	private static final Logger log = LoggerFactory.getLogger(TaskDetailsService.class);

	public List<TaskDetails> findByUserId(int userId) {
		log.info("Inside findByUserId method..");
		List<TaskDetails> returnList = new ArrayList<TaskDetails>();
		try {
			returnList = taskDetailsRepository.findByUserId(userId);
		} catch (Exception e) {
			log.error("Exception occured in findByUserId method", e);
		}
		return returnList;
	}

	public void saveTaskDetails(Form form) {
		log.info("Inside saveTaskDetails method..");
		if (form != null) {
			try {
				TaskDetails task = new TaskDetails();
				task.setUserId(form.getUserId());
				task.setPendingTask(0);
				task.setCompletedTask(0);
				task.setOngoingTask(0);
				taskDetailsRepository.save(task);
			} catch (Exception e) {
				log.error("Exception occured in saveTaskDetails method", e);
			}
		}
	}

	public void deleteTaskDetails(int userId) {
		log.info("Inside deleteTaskDetails method..");
		try {
			taskDetailsRepository.deleteByUserId(userId);
		} catch (Exception e) {
			log.error("Exception occured in deleteTaskDetails method", e);
		}
	}

}
