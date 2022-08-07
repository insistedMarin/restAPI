package com.example.test_back_end.Service;

import com.example.test_back_end.DAO.EmployeeDAO;
import com.example.test_back_end.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;
    public Employee saveEmployee(Employee employee){

        if(employeeDAO.addEmployee(employee))
            employee= employeeDAO.searchEmployee(employee).get(0);

        return employee;
    }
}
