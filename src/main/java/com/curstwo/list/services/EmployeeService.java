package com.curstwo.list.services;

import com.curstwo.list.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> print();

    public Object addEmployee(String firstName, String lastName);

    public Object deleteEmployee(String firstName, String lastName);

    public Object findEmployee(String firstName, String lastName);

}
