package web_study_09_exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import web_study_09_exam.dao.EmployeesDao;
import web_study_09_exam.ds.JdbcUtil;
import web_study_09_exam.dto.Employees;

public class EmployeesDaoImpl implements EmployeesDao {

	private static final EmployeesDaoImpl instance = new EmployeesDaoImpl();

	private EmployeesDaoImpl() {

	}

	public static EmployeesDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Employees> selectEmployeesByAll() {
		String sql = "SELECT ID, PASS, NAME, LEV, ENTER, GENDER, PHONE FROM EMPLOYEES";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Employees> list = new ArrayList<>();
				do {
					list.add(getEmployees(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;

	}

	private Employees getEmployees(ResultSet rs) throws SQLException {
		String id = rs.getString("ID");
		String pass = rs.getString("PASS");
		String name = rs.getString("NAME");
		String lev = rs.getString("LEV");
		Date enter = rs.getTimestamp("ENTER");
		int gender = rs.getInt("GENDER");
		String phone = rs.getString("PHONE");
		return new Employees(id, pass, name, lev, enter, gender, phone);
	}

	@Override
	public Employees selectEmployeesById(Employees emp) {
		String sql = "SELECT ID, PASS, NAME, LEV, ENTER, GENDER, PHONE FROM EMPLOYEES WHERE ID = ? AND PASS = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, emp.getId());
			pstmt.setString(2, emp.getPass());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getEmployees(rs);
				}

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public int insertEmployees(Employees emp) {
		String sql = "INSERT INTO EMPLOYEES(ID, PASS, NAME, LEV, ENTER, GENDER, PHONE) VALUES (?, ?, ?, ?, SYSDATE, ?, ?)";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, emp.getId());
			pstmt.setString(2, emp.getPass());
			pstmt.setString(3, emp.getName());
			pstmt.setString(4, emp.getLev());
			pstmt.setInt(5, emp.getGender());
			pstmt.setString(6, emp.getPhone());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int updateEmployees(Employees emp) {
		String sql = "UPDATE EMPLOYEES SET PASS = ?, NAME = ?, LEV = ?, ENTER = SYSDATE, GENDER = ?, PHONE = ? WHERE ID = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, emp.getPass());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getLev());
			pstmt.setInt(4, emp.getGender());
			pstmt.setString(5, emp.getPhone());
			pstmt.setString(6, emp.getId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int deleteEmployees(Employees emp) {
		String sql = "DELETE FROM EMPLOYEES WHERE ID = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, emp.getId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
