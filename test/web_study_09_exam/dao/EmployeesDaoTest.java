package web_study_09_exam.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_study_09_exam.dao.impl.EmployeesDaoImpl;
import web_study_09_exam.dto.Employees;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeesDaoTest {

	@Test
	public void test05SelectEmployeesByAll() {
		System.out.println("test05SelectEmployeesByAll");
		List<Employees> list = EmployeesDaoImpl.getInstance().selectEmployeesByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);

		System.out.println();
	}

	@Test
	public void test03SelectEmployeesById() {
		System.out.printf("%s()%n", "test03SelectEmployeesById");
		Employees selectEmployees = EmployeesDaoImpl.getInstance().selectEmployeesById(new Employees("admin", "1111"));
		Assert.assertNotNull(selectEmployees);

		System.out.printf("%s%n%n", selectEmployees);
	}

	@Test
	public void test01InsertEmployees() {
		System.out.printf("%s()%n", "test01InsertEmployees");
		Employees insertEmployees = new Employees("somi", "1234", "이소미", "B", new Date(), 2, "010-1234-1234");
		int res = EmployeesDaoImpl.getInstance().insertEmployees(insertEmployees);
		Assert.assertEquals(1, res);
	
		System.out.printf("%s%n%n", insertEmployees);
	}

	@Test
	public void test02UpdateEmployees() {
		System.out.printf("%s()%n", "test02UpdateEmployees");
		Employees updateEmployees = new Employees("somi", "1111", "이소미", "A", new Date(), 2, "010-5555-5555");
		int res = EmployeesDaoImpl.getInstance().updateEmployees(updateEmployees);
		Assert.assertEquals(1, res);

		System.out.printf("%s%n%n", updateEmployees);
	}

	@Test
	public void test04DeleteEmployees() {
		System.out.printf("%s()%n", "test04DeleteEmployees");
		Employees deleteEmployees = new Employees("somi");
		int res = EmployeesDaoImpl.getInstance().deleteEmployees(deleteEmployees);
		Assert.assertEquals(1, res);
		
		System.out.printf("%s%n%n", deleteEmployees);
	}

}
