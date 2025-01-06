package employee.crud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.crud.bean.Employee;
import employee.crud.dao.EmployeeDAO;
import employee.crud.dao.EmployeeDAOImpl;

@WebServlet("/")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDAO employeeDAO = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	
    	employeeDAO = new EmployeeDAOImpl();
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getServletPath();
		
		switch (action) {
		case "/add": {
			
			addNewEmployee(request,response);
			
			break;
		}
		
		case "/delete":{
			 deleteEmployee(request,response);
			
			break;
		}
		
		case "/list":{
			
			getAllEmployees(request,response);
			
			break;
		}
		
		case "/update":{
			
			updateEmployee(request,response);
			
			break;
		}
		
		case "/get" : {
			
			getASingleEmployee(request,response);
			
			break;
		}
		
		
		
		
		default:
			getAllEmployees(request,response);
		}
		
		
	}

	private void getASingleEmployee(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		
		
		Employee  result = employeeDAO.getSingleEmployee(id);
		
		System.out.println("action: update returns: "+ result.getAddress() +" " + result.getEmail() + " " + result.getName() + " " + result.getPhone());
		
		RequestDispatcher requestDispatch = request.getRequestDispatcher("/employeesView.jsp");
		try {
			requestDispatch.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		Employee employee = new Employee(id,name,email,phone,address);
		
		boolean result = employeeDAO.updateEmployee(employee);
		
		System.out.println("action: update returns: "+result);
		
		
		RequestDispatcher requestDispatch = request.getRequestDispatcher("/employeesView.jsp");
		try {
			request.setAttribute("employee" , employee);
			requestDispatch.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}

	private List<Employee> getAllEmployees(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Employee> result = employeeDAO.getAllEmployees();
		
		System.out.println("Total number of employee is " + result.size());
		
		RequestDispatcher requestDispatch = request.getRequestDispatcher("/employeesView.jsp");
		try {
			request.setAttribute("result", result);
			requestDispatch.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Employee employee = new Employee(id,name,email,phone,address);
		
		
		boolean result = employeeDAO.deleteEmployee(employee.getId());
		
		System.out.println("employee is deleted: "+result);
		
		RequestDispatcher disp = request.getRequestDispatcher("/");
		try {
			disp.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void addNewEmployee(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		Employee employee = new Employee(name,email,phone,address);
	
		
		System.out.println("addNewEmployee, Employee Details ==> "+ employee);
		
		boolean result = employeeDAO.addEmployee(employee);
		System.out.println("addNewEmployee, result is ==> "+result);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employeesView.jsp");
		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block;
			e.printStackTrace();
		}
		
	}

}
