package com.application.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Form;
import com.application.repository.FormRepository;

@Service
public class FormService {

	@Autowired
	FormRepository formRepository;

	private static final Logger log = LoggerFactory.getLogger(FormService.class);

	public void saveForm(Form form) {
		try {
			log.info("Inside saveForm method..");
			formRepository.save(form);
		} catch (Exception e) {
			log.error("Exception occured in saveForm method", e);
		}
	}

	public List<Form> getAllEmployees() {
		List<Form> returnList = new ArrayList<Form>();
		try {
			log.info("Inside getAllEmployees method..");
			returnList = formRepository.findAll();
		} catch (Exception e) {
			log.error("Exception occured in getAllEmployees method", e);
		}
		return returnList;
	}

	public Form getFormById(int id) {
		Form returnForm = new Form();
		try {
			log.info("Inside getFormById method..");
			returnForm = formRepository.findById(id).get();
		} catch (Exception e) {
			log.error("Exception occured in getFormById method", e);
		}
		return returnForm;
	}

	public void deleteForm(int userId) {
		try {
			log.info("Inside deleteForm method..");
			formRepository.deleteByUserId(userId);
		} catch (Exception e) {
			log.error("Exception occured in deleteForm method", e);
		}
	}

	public void updateForm(Form form) {
		try {
			log.info("Inside updateForm method..");
			formRepository.save(form);
		} catch (Exception e) {
			log.error("Exception occured in updateForm method", e);
		}
	}
	
	public Form findFormByUserId(int userId) {
		Form form = new Form();
		try {
			log.info("Inside findFormByUserId method..");
			form = formRepository.findByUserId(userId);
		} catch (Exception e) {
			log.error("Exception occured in findFormByUserId method", e);
		}
		return form;
	}

}
