package com.imcs.bu.bo;

import com.imcs.bu.dao.EmployeeServiceDAO;
import com.imcs.bu.dto.EmployeeDTO;

public class EmployeeServiceBO {
	public EmployeeDTO getEmployeeInfo(String empId) {
		EmployeeDTO empDto = null;
		if(empId != null && empId.trim().length()>0) {
			EmployeeServiceDAO empDao = new EmployeeServiceDAO();
			empDto = empDao.getEmployeeInfo(empId);
		}	else {
			System.out.println("Please provide valid request.");
		}
		
		return empDto;
	}
	
	public String addEmployeeInfo(String empId, String firstName, String lastName, String email, String phoneNumber, String jobId ) {
		EmployeeServiceDAO empDao = new EmployeeServiceDAO();
		empDao.addEmployeeInfo( empId,  firstName,  lastName,  email,  phoneNumber,  jobId);
		return "Added Employee #" +empId;
	}
}
