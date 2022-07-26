package com.tst.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO {

	public boolean updateMember(String userName, String userPass, String role) {

		String sql = "UPDATE members "
				   + "SET member_password = ?, member_role = ? "
				   + "WHERE member_id = ?";

		connect();
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userPass);
			pstmt.setInt(2, Integer.parseInt(role));
			pstmt.setString(3, userName);

			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 수정되었습니다");
			
			if(result > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}
		
		return false;
	}

	public boolean insertMember(String userName, String userPass, String role) {

		String sql = "INSERT INTO members " + "VALUES(?, ?, ?)";

		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userPass);
			pstmt.setString(3, role);

			int result = pstmt.executeUpdate(); // insert, update, delete
			System.out.println(result + "건 입력됨.");
			if(result > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}
		
		return false;
	}

	public List<Employee> getEmpInfo(String name) {
		connect();
		List<Employee> list = new ArrayList<>();
		String query = "SELECT * FROM employees " + "WHERE first_name = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();

				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFisrtName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJob(rs.getString("job_id"));
				
				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}

		return list;
	}

	public List<Employee> empList() {

		List<Employee> list = new ArrayList<>();

		connect();
		String query = "SELECT employee_id, first_name, last_name, email, salary, job_id, "
				+ " TO_CHAR(hire_date) as hire_date" + " FROM employees";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Employee emp = new Employee();

				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFisrtName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJob(rs.getString("job_id"));
				emp.setHireDate(rs.getString("hire_date"));

				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}

		return list;
	}

}
