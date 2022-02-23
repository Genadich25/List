package com.curstwo.list.services;

import com.curstwo.list.Employee;
import com.curstwo.list.exceptions.BadRequestException;
import com.curstwo.list.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    public List<Employee> print(){
        return employees;
    }

    public Object addEmployee(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.size(); i++) {
            if (employee.equals(employees.get(i))) {
                throw new BadRequestException();
            }
        }
        employees.add(employee);
        return employee;
    }

    public Object deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i) != null) {
                    if (employees.get(i).equals(employee)) {
                        employees.set(i, null);
                        return employee;
                    }
                }
            }
        throw new NotFoundException();
    }

    public Object findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employee)) {
                return employees.get(i);
            }
        }
        throw new NotFoundException();
    }
}
