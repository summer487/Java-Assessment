package com.application.dto.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dto.model.TaskInformation;
import com.application.dto.repository.TaskInformationRepository;
import com.application.service.FormService;

@Service
public class CustomDTOService {

	@Autowired
	TaskInformationRepository taskInformationRepository;

	private static final Logger log = LoggerFactory.getLogger(CustomDTOService.class);

	public List<TaskInformation> getAllDetailsForTasks() {
		log.info("Inside getAllDetailsForTasks method");
		List<Object[]> items = taskInformationRepository.findAllDetailsForTasks();
		List<TaskInformation> responseList = new ArrayList<TaskInformation>();
		if (items != null && items.size() > 0) {
			try {
				for (Object[] item : items) {
					TaskInformation c = new TaskInformation();
					c.setDepartment(String.valueOf(item[0]));
					c.setPendingTasks(String.valueOf(item[1]));
					c.setOngoingTasks(String.valueOf(item[3]));
					c.setCompletedTasks(String.valueOf(item[2]));
					responseList.add(c);
				}
			} catch (Exception e) {
				log.error("Exception occured in getAllDetailsForTasks method", e);
			}
		}
		return responseList;
	}

}
