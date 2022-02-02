package com.mouritech.onetooneexample;

import com.mouritech.onetooneexample.dao.EmployeeDao;
import com.mouritech.onetooneexample.model.Employee;
import com.mouritech.onetooneexample.model.EmployeeDetails;

public class OnetoOneBiDirectionalMain {

	public static void main(String[] args) {
		Employee emp = new Employee("Kiran","Kamesh","kirantvk98@gmail.com");
		EmployeeDetails empdetails = new EmployeeDetails("tennis","drawing");
		empdetails.setEmployee(emp);
		emp.setEmpDetails(empdetails);
		
		EmployeeDao empDao = new EmployeeDao();
		empDao.saveEmployee(emp);

	}

}