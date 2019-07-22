package com.callcenter.back.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.callcenter.back.model.Employee;

/**
 * <h1>Clase EmployeeList</h1>
 * Clase de la lista de empleados
 *
 * @author  <a href="mailto:cadolop@gmail.com">Carlos Adolfo Lopez</a>
 * @version 1.0
 * @since 20/07/2019
 * @project CallCenterBack
 */
public class EmployeeList {
	@Autowired
	List<Employee> employees = new ArrayList<Employee>();
	
    public List<Employee> getListEmployees() {
        return employees;
    }
    
}
