package com.tecsup.springMVC.dao.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.springMVC.dao.EmployeeDAO;
import com.tecsup.springMVC.exception.DAOException;
import com.tecsup.springMVC.exception.EmptyResultException;
import com.tecsup.springMVC.mapper.EmployeeMapper;
import com.tecsup.springMVC.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public Employee findEmployee(int employee_id) throws DAOException, EmptyResultException {

		String query = "SELECT employee_id, login, password, first_name, last_name, salary, department_id "
				+ " FROM employees WHERE employee_id = ?";

		//general un obejto y pones los parametros de entrada y son par la consulta de abajo
		Object[] params = new Object[] { employee_id };

		try {

			Employee emp = (Employee) jdbcTemplate.queryForObject(query, params, new EmployeeMapper());
			//
			return emp;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

}
