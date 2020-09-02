package web_study_09_exam.service;

import web_study_09_exam.dao.EmployeesDao;
import web_study_09_exam.dao.impl.EmployeesDaoImpl;
import web_study_09_exam.dto.Employees;

public class LoginService {
	
	private EmployeesDao dao = EmployeesDaoImpl.getInstance();

	public Employees getEmployees(Employees emp) {
		return dao.selectEmployeesById(emp);
	}

}
