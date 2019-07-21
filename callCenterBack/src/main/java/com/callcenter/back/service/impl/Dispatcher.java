package com.callcenter.back.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.callcenter.back.impl.EmployeeList;
import com.callcenter.back.model.Employee;
import com.callcenter.back.service.IDispatcher;

@Service
public class Dispatcher implements IDispatcher {
	private static final Logger LOGGER = LoggerFactory.getLogger(Dispatcher.class);

	@Autowired
	EmployeeList employeeList;

	public Dispatcher() {
	}

	@Async
	@Override
	public void dispatcherCall(String call) {
		// Cada llamada puede durar un tiempo aleatorio entre 5 y 10 segundos.
		long time = (long) Math.floor(Math.random() * (10000 - 4999 + 1) + 4999);
		try {
			Employee employee = getEmployee();
			if (employee != null) {
				Thread.sleep(time);
				LOGGER.info("Call {} ends for {} in {} ms.", call, employee.getName(), time);
				setFreeEmployee(employee);
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	private Employee getEmployee() {
		int i = 0;
		for (Employee employee : employeeList.getListEmployees()) {
			if (!employee.isBusy()) {
				employee.setBusy(true);
				employeeList.getListEmployees().set(i, employee);
				return employee;
			}
			i++;
		}
		return null;
	}

	private void setFreeEmployee(Employee employeeTarget) {
		int i = 0;
		for (Employee employee : employeeList.getListEmployees()) {
			if (employee.getName().equals(employeeTarget.getName())) {
				employee.setBusy(false);
				employeeList.getListEmployees().set(i, employee);
				break;
			}
			i++;
		}
	}

}
