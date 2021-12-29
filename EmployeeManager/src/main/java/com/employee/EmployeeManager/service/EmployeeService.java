package com.employee.EmployeeManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.EmployeeManager.domain.Employee;
import com.employee.EmployeeManager.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(Long employeeId) {
		return employeeRepository.getById(employeeId);
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployee(Long id) throws Exception{
		Employee employeeToBeDeleted = employeeRepository.getById(id);
		if (employeeToBeDeleted == null) {
			throw new Exception("Employee does not exist");
		}

		employeeRepository.delete(employeeToBeDeleted);
	}
}
