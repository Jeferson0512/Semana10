package com.tecsup.springMVC.services;

import com.tecsup.springMVC.exception.DAOException;
import com.tecsup.springMVC.exception.EmptyResultException;
import com.tecsup.springMVC.model.Employee;

public interface EmployeeService {

	Employee find(int employee_id) throws DAOException, EmptyResultException;
}
