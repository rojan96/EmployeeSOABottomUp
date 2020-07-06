package com.imcs.bu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.imcs.bu.constants.AppConstants;
import com.imcs.bu.dto.EmployeeDTO;
import com.imcs.bu.singleton.ApplicationProperties;

public class EmployeeServiceDAO {
	public EmployeeDTO getEmployeeInfo(String empId) {
		EmployeeDTO empDto = null;
		Connection con = null;
		try {
			 con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from employees where employee_id = ?");
			pstmt.setString(1, empId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				empDto = new EmployeeDTO();
				String employeeId = rs.getString("Employee_ID");
				String firstName = rs.getString("First_name");
				String lastName = rs.getString("Last_name");
				String emailId = rs.getString("email");
				
				empDto.setEmailId(emailId);
				empDto.setEmpId(employeeId);
				empDto.setFirstName(firstName);
				empDto.setLastName(lastName);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empDto;
	}
	
	public void addEmployeeInfo(String empId, String firstName, String lastName, String email, String phoneNumber, String jobId) {
		Connection con = null;
		ResultSet rs = null;
		try {
			 con = getConnection();
			 PreparedStatement stmt = con.prepareStatement("insert into employees (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, Phone_number, Job_id) values (?,?,?,?,?,?)");
				stmt.setString(1, empId);
				stmt.setString(2, firstName);
				stmt.setString(3, lastName);
				stmt.setString(4, email);
				stmt.setString(5, phoneNumber);
				stmt.setString(6, jobId);
				rs = stmt.executeQuery();
				con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Connection getConnection() throws Exception {
		Connection con = null;
		
		ApplicationProperties props = null;
		try {
			props = ApplicationProperties.getInstance();
			
			Class.forName(props.getProperty(AppConstants.driver));
			con = DriverManager.getConnection(props.getProperty(AppConstants.url),props.getProperty(AppConstants.user),props.getProperty(AppConstants.password));
			con.setAutoCommit(false);
			
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			throw ex;
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return con;
	}
	
}
