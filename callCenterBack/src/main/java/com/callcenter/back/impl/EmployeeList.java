package com.callcenter.back.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.callcenter.back.model.Employee;

public class EmployeeList {
	@Autowired
	List<Employee> employees = new ArrayList<Employee>();
	
    public List<Employee> getListEmployees() {
        return employees;
    }
    
}
