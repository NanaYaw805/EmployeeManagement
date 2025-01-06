package employee.crud.dao;

import java.util.List;

import employee.crud.bean.Employee;

public interface EmployeeDAO {
	
	//insert employee
	public boolean addEmployee(Employee employee);
	
	
	//delete employee
	public boolean deleteEmployee(int employeeId);
	
	//update employee
	public boolean updateEmployee(Employee employee);
	
	//get all employees
	public List<Employee> getAllEmployees();
	
	//get single employee
	public Employee getSingleEmployee(int employeeId);
	
	
	
	
	

}
