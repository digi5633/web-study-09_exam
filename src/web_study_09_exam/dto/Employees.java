package web_study_09_exam.dto;

import java.util.Date;

public class Employees {
	private String id;
	private String pass;
	private String name;
	private String lev;
	private Date enter;
	private int gender;
	private String phone;

	public Employees() {

	}

	public Employees(String id, String pass, String name, String lev, Date enter, int gender, String phone) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.lev = lev;
		this.enter = enter;
		this.gender = gender;
		this.phone = phone;
	}

	public Employees(String id, String pass, String name, String lev, int gender, String phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.lev = lev;
		this.gender = gender;
		this.phone = phone;
	}

	public Employees(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}

	public Employees(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLev() {
		return lev;
	}

	public void setLev(String lev) {
		this.lev = lev;
	}

	public Date getEnter() {
		return enter;
	}

	public void setEnter(Date enter) {
		this.enter = enter;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "EmployeesDao [id=" + id + ", pass=" + pass + ", name=" + name + ", lev=" + lev + ", enter=" + enter
				+ ", gender=" + gender + ", phone=" + phone + "]";
	}

}
