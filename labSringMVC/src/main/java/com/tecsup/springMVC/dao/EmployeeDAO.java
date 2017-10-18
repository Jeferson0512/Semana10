package com.tecsup.springMVC.dao;

import com.tecsup.springMVC.exception.DAOException;
import com.tecsup.springMVC.exception.EmptyResultException;
import com.tecsup.springMVC.model.Employee;

public interface EmployeeDAO {

	Employee findEmployee(int id) throws DAOException, EmptyResultException;
	
}
