package com.tecsup.springMVC.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.tecsup.springMVC.model.Employee;
import com.tecsup.springMVC.services.EmployeeService;

@Controller
public class EmployeeController {

private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//En la parte de abajo espera un valor y la cual  es 100
	@GetMapping("/{employee_id}")
	public ModelAndView home(@PathVariable int employee_id, ModelMap model) {

		ModelAndView modelAndView = null;
		Employee emp = new Employee();
		try {
			//busca el empleado
			emp = employeeService.find(employee_id);
			logger.info(emp.toString());
		} catch (Exception e) {
			//Si hay un error lo imprime
			e.printStackTrace();
		}
		
		modelAndView = new ModelAndView("home", "command", emp);

		return modelAndView;
	}
	
}
