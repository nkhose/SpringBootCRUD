package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeService {
	private EmployeeRepository employeeRepository;

	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	private List<Employee> emps = new ArrayList<Employee>(Arrays.asList(
			new Employee(1, "Nikita", "Pune"),
			new Employee(2, "Pritam", "Pune")));

	public List<Employee> getAllEmployee() {
		List<Employee> emp=new ArrayList<Employee>();
		employeeRepository.findAll().forEach(emp::add);
		return emp;

	}

	public void addEmployee(Employee e) {
		employeeRepository.save(emps);
	}
	
	public Employee findById(Integer id){
	return employeeRepository.findOne(id);

	}
	
	public Employee updateEmp(Employee emp){
		return employeeRepository.save(emp);

	}
	
	public void deleteEmp(Integer id){
		employeeRepository.delete(id);;

	}
}
