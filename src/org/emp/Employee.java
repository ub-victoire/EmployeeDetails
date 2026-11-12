package org.emp;

public class Employee {
	public void empId(){
		System.out.println("Employee ID: EMP001");
	}

	public void empName(){
		System.out.println("Employee Name: UShindi Bihame Victoire");
	}

	public void empDob() {
		System.out.println("Employee Data of Birth: 2005-03-25");
	}

	public void empPhone(){
		System.out.println("Employee Phine number: 0794412876");
	}
	public void empEmail(){
		System.out.println("Employee Email: victoireushindi371@gmail.com");
	}

	public void empAddress(){
		System.out.println("Employee Address: st 737, Gikondo , Sgeem");
	}

	public static void main(String[] args){
		Employee employee = new Employee();

    	employee.empId();
    	employee.empName();
    	employee.empDob();
    	employee.empPhone();
    	employee.empEmail();
    	employee.empAddress();

    	}
}
