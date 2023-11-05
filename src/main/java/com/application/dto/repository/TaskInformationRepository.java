package com.application.dto.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.service.FormService;

@Repository
public class TaskInformationRepository {
	
	@Autowired
    private EntityManager entityManager;
	
	private static final Logger log = LoggerFactory.getLogger(TaskInformationRepository.class);
	
    @SuppressWarnings("unchecked")
	public List<Object[]> findAllDetailsForTasks(){
		log.info("Inside findAllDetailsForTasks method");
		List<Object[]> results = new ArrayList<Object[]>();
		try {
		NativeQuery<Object[]> q = (NativeQuery<Object[]>) entityManager.createNativeQuery("select f.department, sum(pending_task), sum(completed_task), sum(ongoing_task) from task_details t join form f on f.user_id = t.user_id"
				+ " group by f.department");
		results = q.getResultList();
		}
		catch(Exception e) {
			log.error("Exception occured inside findAllDetailsForTasks method", e);
		}
        return results;
	};

}
