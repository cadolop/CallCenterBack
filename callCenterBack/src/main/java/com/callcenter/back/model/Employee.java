package com.callcenter.back.model;

import com.callcenter.back.enums.EmployeeEnum;

/**
 * <h1>Clase Empleado</h1> Clase modelo con las propiedades de cada empleado del contact center
 *
 * @author <a href="mailto:cadolop@gmail.com">Carlos Adolfo Lopez</a>
 * @version 1.0
 * @since 20/07/2019
 * @project CallCenterBack
 */
public class Employee {
	private final EmployeeEnum employeeType;
	private final String name;
	private final int priority;
	private boolean busy;
	
	public Employee(EmployeeEnum employeeType, String name, int priority) {
		super();
		this.employeeType = employeeType;
		this.name = name;
		this.priority = priority;
        this.busy = false;
	}

	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	public EmployeeEnum getEmployeeType() {
		return employeeType;
	}

	public String getName() {
		return name;
	}

	public int getPriority() {
		return priority;
	}
	
}
