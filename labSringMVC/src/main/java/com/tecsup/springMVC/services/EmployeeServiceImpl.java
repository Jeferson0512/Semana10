package com.tecsup.springMVC.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.springMVC.dao.EmployeeDAO;
import com.tecsup.springMVC.exception.DAOException;
import com.tecsup.springMVC.exception.EmptyResultException;
import com.tecsup.springMVC.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	//indentifica el dao
	@Autowired
	private EmployeeDAO employeeDAO;
//Sobree scribe el metodo y excepciones personalisadas, como se hce inyecciones no se ahce isntancias
	@Override
	public Employee find(int employee_id) throws DAOException, EmptyResultException {
		
		Employee emp = employeeDAO.findEmployee(employee_id);

		return emp;
	}

	
}
