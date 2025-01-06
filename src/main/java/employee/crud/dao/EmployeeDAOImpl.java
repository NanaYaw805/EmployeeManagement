package employee.crud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import employee.crud.bean.Employee;
import employee.crud.db.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {
	public static Connection connection = DBConnection.connection;
	
	

	public EmployeeDAOImpl() {
		super();
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		try {
			String insertStatement = "INSERT INTO employee_db.employee (name , email , phone , address) VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getPhone());
			preparedStatement.setString(4, employee.getAddress());
			
			int result =preparedStatement.executeUpdate();
			return result == 1 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		
		try {
			String deleteStatement = "DELETE FROM employee_db.employee WHERE id = ?";
			PreparedStatement preparedDeleteStatement = connection.prepareStatement(deleteStatement);
			preparedDeleteStatement.setInt(1,employeeId);
			
			int result = preparedDeleteStatement.executeUpdate();
			return result == 1 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		
		try {
			String updateStatement = "UPDATE employee_db.employee SET name = ? , email =?,phone = ? , address =? WHERE id = ?";
			PreparedStatement prepareStatement = connection.prepareStatement(updateStatement);
			prepareStatement.setString(1, employee.getName());
			prepareStatement.setString(2, employee.getEmail());
			prepareStatement.setString(3, employee.getPhone());
			prepareStatement.setString(4, employee.getAddress());
			prepareStatement.setInt(5, employee.getId());
			
			int result = prepareStatement.executeUpdate();
			return result == 1 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		
		try {
			String getAllEmployeesStatement = "SELECT * FROM employee_db.employee";
			PreparedStatement getAllStatement = connection.prepareStatement(getAllEmployeesStatement);
			
			ResultSet resultSet = getAllStatement.executeQuery();
			List<Employee> employees = new ArrayList<Employee>();
			
			while(resultSet.next()) {
				Employee em = new Employee();
				em.setId(resultSet.getInt("id"));
				em.setAddress(resultSet.getString("address"));
				em.setEmail(resultSet.getString("email"));
				em.setName(resultSet.getString("name"));
				em.setPhone(resultSet.getString("phone"));
				
				employees.add(em);
			
			}
			
			return employees;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}

	@Override
	public Employee getSingleEmployee(int employeeId) {
		// TODO Auto-generated method stub
		
		try {
			String getSingleEmployeeStatement = "SELECT * FROM employee_db.employee WHERE id = ?";
			PreparedStatement prepareStatement = connection.prepareStatement(getSingleEmployeeStatement);
			prepareStatement.setInt(1, employeeId);
			
			ResultSet result = prepareStatement.executeQuery();
			List<Employee> listOfEmployees = new ArrayList<Employee>();
			while(result.next()) {
				Employee em = new Employee();
				em.setName(result.getString("name"));
				em.setAddress(result.getString("address"));
				em.setId(result.getInt("id"));
				em.setPhone(result.getString("phone"));
				em.setEmail(result.getString("email"));
				
				listOfEmployees.add(em);
				
			}
			return listOfEmployees.size() == 1 ? listOfEmployees.get(0) : null ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	public static void main(String[] args) {
		//Employee employee = new Employee("Nana Don","arhinyaw64@gmail.com","02442280826","Ghana",11);
		EmployeeDAOImpl employeeImpl = new EmployeeDAOImpl();
		Employee yesOrNo = employeeImpl.getSingleEmployee(9);
		System.out.println(yesOrNo.getName());
		
	}

}
