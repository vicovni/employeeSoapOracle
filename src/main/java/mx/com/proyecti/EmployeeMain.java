package mx.com.proyecti;

import java.util.Date;

public class EmployeeMain {

	public static void main(String[] args) {
		EmployeeManager manager = new EmployeeManager();
		manager.setup();
		manager.create("Victor", "Calderón", new Date(), 1000.00, "victor", "victor12345");
		manager.exit();

	}

}
