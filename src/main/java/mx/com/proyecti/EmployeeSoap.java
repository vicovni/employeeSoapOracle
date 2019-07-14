package mx.com.proyecti;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import mx.com.proyecti.entity.Employee;

@WebService
public class EmployeeSoap {
	
	EmployeeManager manager = new EmployeeManager();
	public EmployeeSoap() {
		// TODO Auto-generated constructor stub
	}
	
	@WebMethod
	public Employee create(@WebParam(name="firstname")String firstName, 
			@WebParam(name="lastname")String lastName, 
			@WebParam(name="birthdate")Date birthdate, 
			@WebParam(name="salary")double salary, 
			@WebParam(name="username")String userName, 
			@WebParam(name="password")String password) {
		manager.setup();
		int id = manager.create(firstName, lastName, birthdate, salary, userName, password);
		manager.exit();
		Employee emp = read(id);
		return emp;
	}

	@WebMethod
	public Employee read(@WebParam(name="id")int id) {
		manager.setup();
		Employee employee = manager.read(id);
		manager.exit();
		return employee;
	}

	@WebMethod
	public List<Employee> readAll(){
		manager.setup();
		List<Employee> employees= manager.readAll();
		manager.exit();
		return employees;
	}
	
	@WebMethod
	public Employee update(@WebParam(name="id")int id, 
	@WebParam(name="firstname")String firstName, 
	@WebParam(name="lastname")String lastName, 
	@WebParam(name="birthdate")Date birthdate, 
	@WebParam(name="salary")double salary, 
	@WebParam(name="username")String userName, 
	@WebParam(name="password")String password) {
		manager.setup();
		manager.update(id, firstName, lastName, birthdate, salary, userName, password);
		manager.exit();
		Employee emp = read(id);
		return emp;	
	}
	
	@WebMethod
	public void delete(@WebParam(name="id")int id) {
		manager.setup();
		manager.delete(id);
		manager.exit();
	}
	
	
}
