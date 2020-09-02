package web_study_09_exam.service;

import web_study_09_exam.dao.EmployeesDao;
import web_study_09_exam.dao.impl.EmployeesDaoImpl;
import web_study_09_exam.dto.Employees;

public class JoinService {
	
	private EmployeesDao dao = EmployeesDaoImpl.getInstance();

	public int insertEmployees(Employees emp) {
		return dao.insertEmployees(emp);
	}

	public int updateEmployees(Employees emp) {
		return dao.updateEmployees(emp);
	}

}
