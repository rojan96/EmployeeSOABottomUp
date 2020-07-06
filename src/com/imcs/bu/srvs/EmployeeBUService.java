package com.imcs.bu.srvs;

import com.imcs.bu.bo.EmployeeServiceBO;
import com.imcs.bu.dto.EmployeeDTO;

public class EmployeeBUService {
	
	public EmployeeDTO getEmployeeInfo(String empId) {
		EmployeeServiceBO bo = new EmployeeServiceBO();
		EmployeeDTO dto = bo.getEmployeeInfo(empId);
		return dto;
	}
	
	public String addEmployeeInfo(String empId, String firstName, String lastName, String email, String phoneNumber, String jobId ) {
		EmployeeServiceBO bo = new EmployeeServiceBO();
		bo.addEmployeeInfo(empId, firstName, lastName, email, phoneNumber, jobId);
		return "Success - added: " + empId;
	}
}
