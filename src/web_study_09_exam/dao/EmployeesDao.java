package web_study_09_exam.dao;

import java.util.List;

import web_study_09_exam.dto.Employees;

public interface EmployeesDao {

	List<Employees> selectEmployeesByAll();

	Employees selectEmployeesById(Employees emp);

	int insertEmployees(Employees emp);

	int updateEmployees(Employees emp);

	int deleteEmployees(Employees emp);

}
