package com.callcenter.back.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.callcenter.back.enums.EmployeeEnum;
import com.callcenter.back.impl.EmployeeList;
import com.callcenter.back.impl.Priority;
import com.callcenter.back.model.Employee;

/**
 * <h1>Clase EmployeeListConfig</h1>
 * Clase que configura la lista de empleados
 *
 * @author  <a href="mailto:cadolop@gmail.com">Carlos Adolfo Lopez</a>
 * @version 1.0
 * @since 20/07/2019
 * @project CallCenterBack
 */
@Configuration
public class EmployeeListConfig {

	private static final int PRIORITY_ONE = 1;
	private static final int PRIORITY_TWO = 2;
	private static final int PRIORITY_THREE = 3;

	private int directorSize = 1;
	private int supervisorSize = 3;
	private int operatorSize = 7;
	
	@Bean
	public EmployeeList getCollectionsBean() {
		return new EmployeeList();
	}
	
	@Bean
	public List<Employee> employeeList() {
		List<Employee> employees = new ArrayList<Employee>();
		for (int i = 1; i <= directorSize; i++) {
			employees.add(new Employee(EmployeeEnum.DIRECTOR, "Director_" + i, PRIORITY_THREE));
		}

		for (int i = 1; i <= supervisorSize; i++) {
			employees.add(new Employee(EmployeeEnum.SUPERVISOR, "Supervisor_" + i, PRIORITY_TWO));
		}

		for (int i = 1; i <= operatorSize; i++) {
			employees.add(new Employee(EmployeeEnum.OPERATOR, "Operator_" + i, PRIORITY_ONE));
		}

		// Ordenamiento por prioridad
		Collections.sort(employees, new Priority());
		return employees;
	}

}
