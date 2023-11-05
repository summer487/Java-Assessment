package com.application.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.dto.service.CustomDTOService;
import com.application.model.Form;
import com.application.model.TaskDetails;
import com.application.model.User;
import com.application.service.FormService;
import com.application.service.MyUserDetails;
import com.application.service.MyUserDetailsService;
import com.application.service.TaskDetailsService;

@Controller
public class MainController {

	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	@Autowired
	CustomDTOService customDTOService;

	@Autowired
	TaskDetailsService taskDetailsService;

	@Autowired
	FormService formService;

	@Autowired
	MyUserDetailsService myUserDetailsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage(ModelMap modelMap) {
		log.info("Inside loginPage method..");
		Map<String, String> map = getLoggedInUserDetails();

		if (map != null && !map.isEmpty()) {
			String loggedInUserName = map.get("userName");
			String roles = map.get("roles");

			if (loggedInUserName.equals("") || loggedInUserName == null) {
				return "redirect:/login";
			} else {
				modelMap.addAttribute("userName", loggedInUserName);
				if (roles.contains("ROLE_ADMIN")) {
					return "home-page-admin";
				} else {
					return "home-page-user";

				}
			}
		} else {
			return "redirect:/login";
		}
	}

	private Map<String, String> getLoggedInUserDetails() {
		log.info("Fetching logged in User Details");
		Map<String, String> map = new HashMap<String, String>();
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal != null) {
				if (principal instanceof MyUserDetails) {
					map.put("userName", ((MyUserDetails) principal).getUsername());
					map.put("roles", ((MyUserDetails) principal).getAuthorities().toString());
					map.put("id", ((MyUserDetails) principal).getId().toString());
				}
			}
		} catch (Exception e) {
			log.error("Exception occured inside getLoggedInUserDetails method", e);
		}
		return map;
	}

	// to show the employee Report
	@RequestMapping(value = "/employee-report", method = RequestMethod.GET)
	public String viewEmployeeReport(ModelMap map) {
		log.info("Inside viewEmployeeReport method");
		try {
			map.addAttribute("details", formService.getAllEmployees());
			return "employee-report";
		} catch (Exception e) {
			log.error("Exception occured inside viewEmployeeReport method", e);
		}
		return "employee-report";

	}

	// to show the task Report
	@RequestMapping(value = "/task-report", method = RequestMethod.GET)
	public String viewTaskReport(ModelMap map) {
		log.info("Inside viewTaskReport method");
		try {
			map.addAttribute("details", customDTOService.getAllDetailsForTasks());
		} catch (Exception e) {
			log.error("Exception occured inside viewTaskReport method", e);
		}
		return "task-report";

	}

	// to show the dashboard page
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String displayDashboard(ModelMap map) {
		log.info("Inside displayDashboard method");
		Map<String, String> loggedInUserMap = getLoggedInUserDetails();
		if (loggedInUserMap != null && !loggedInUserMap.isEmpty()) {
			try {
				map.addAttribute("userName", loggedInUserMap.get("userName"));
				String userId = loggedInUserMap.get("id");
				List<TaskDetails> list = taskDetailsService.findByUserId(Integer.valueOf(userId));
				map.addAttribute("pendingCount", list.get(0).getPendingTask());
				map.addAttribute("ongoingCount", list.get(0).getOngoingTask());
				map.addAttribute("completedCount", list.get(0).getCompletedTask());
			} catch (Exception e) {
				log.error("Exception occured inside displayDashboard method", e);
			}
		}
		return "dashboard";
	}

	// to show the reports page
	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public String displayReports(ModelMap map) {
		log.info("Inside displayReports method");
		return "reports-home-page";
	}

	// to show the library page
	@RequestMapping(value = "/library", method = RequestMethod.GET)
	public String displayLibrary(ModelMap map) {
		log.info("Inside displayLibrary method");
		Map<String, String> loggedInUserMap = getLoggedInUserDetails();
		if (loggedInUserMap != null && !loggedInUserMap.isEmpty()) {
			try {
				Form form = formService.findFormByUserId(Integer.valueOf(loggedInUserMap.get("id")));
				String department = form.getDepartment();
				boolean condition = true;
				if (department.equals("Research & Development")) {
					condition = false;
				}
				map.addAttribute("condition", condition);
			} catch (Exception e) {
				log.error("Exception occured inside displayLibrary method", e);
			}
		}
		return "library";
	}

	// to display the add form page
	@RequestMapping(value = "/add-employee", method = RequestMethod.GET)
	public String addEmployeePage(ModelMap map) {
		map.addAttribute("form", new Form());
		setAttributes("add", map);
		return "add-employee";
	}

	// to actually the add form page
	@RequestMapping(value = "/add-employee", method = RequestMethod.POST)
	public String addEmployee(@Valid @ModelAttribute("form") Form form, BindingResult bindingResult, ModelMap map) {
		log.info("Inside addEmployee method");
		String page = "add";
		if (formValidations(form, bindingResult, map, page)) {
			return "add-employee";
		} else {
			try {
				User user = myUserDetailsService.saveUserDetails(form);
				if (user != null && user.getId() > 0) {
					form.setUserId(user.getId());
					taskDetailsService.saveTaskDetails(form);
					formService.saveForm(form);
					map.addAttribute("name", form.getFirstName() + " " + form.getLastName());
				}
			} catch (Exception e) {
				log.error("Exception occured inside addEmployee method", e);
			}
			return "employee-add-success";
		}
	}

	// to show the view page
	@RequestMapping(value = "/view-employees", method = RequestMethod.GET)
	public String displayEmployees(ModelMap map) {
		log.info("Inside displayEmployees method");
		try {
			List<Form> list = formService.getAllEmployees();
			List<Form> listWithoutAdminEmployees = list.stream().filter(x -> !x.getDepartment().equals("Administration")).collect(Collectors.toList());
			map.addAttribute("form", listWithoutAdminEmployees);
		} catch (Exception e) {
			log.error("Exception occured inside displayEmployees method", e);
		}
		return "view-employees";

	}

	// to execute the operation on delete page
	@RequestMapping(value = "/delete-employee", method = { RequestMethod.POST, RequestMethod.GET })
	public String editEmployee(@RequestParam int id, ModelMap map) {
		log.info("Inside editEmployee method");
		try {
			formService.deleteForm(id);
			taskDetailsService.deleteTaskDetails(id);
			myUserDetailsService.deleteUser(id);
		} catch (Exception e) {
			log.error("Exception occured inside editEmployee method", e);
		}
		return "employee-delete-success";
	}

	// to set the button names, page title and headings
	public void setAttributes(String flag, ModelMap map) {
		map.addAttribute("pageHeading", "Registration of New User");
		map.addAttribute("buttonName", "Register");
		map.addAttribute("pageTitle", "Add Employee");
	}

	// to do the code level validations
	public boolean formValidations(@Valid @ModelAttribute("form") Form form, BindingResult bindingResult, ModelMap map,
			String page) {

		boolean flag = false;

		if (bindingResult.hasErrors()) {
			flag = true;
		}

		setAttributes("add", map);

		return flag;
	}

}
