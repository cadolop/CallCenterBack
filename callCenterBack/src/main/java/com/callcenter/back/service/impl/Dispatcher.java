package com.callcenter.back.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.callcenter.back.impl.EmployeeList;
import com.callcenter.back.model.Employee;
import com.callcenter.back.service.IDispatcher;

/**
 * <h1>Clase Dispatcher</h1>
 * Clase servicio que implementa la logica de negicio del callcenter y su despacho
 *
 * @author  <a href="mailto:cadolop@gmail.com">Carlos Adolfo Lopez</a>
 * @version 1.0
 * @since 20/07/2019
 * @project CallCenterBack
 */
@Service
public class Dispatcher implements IDispatcher {
	private static final Logger LOGGER = LoggerFactory.getLogger(Dispatcher.class);

	@Autowired
	EmployeeList employeeList;

	public Dispatcher() {
	}

    /**
     * Metodo de asigancion de llamadas al empleado que este disponible para la llamada
     *
     * @param call idetificado de llamada
     */
	@Async
	@Override
	public void dispatchCall(String call) {
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

    /**
     * Metodo que busca al empleado que este disponible
     * llamadas
     *
     * @return Employee el empleado disponible
     */
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

    /**
     * Metodo que libera un empleado al terminar la llamada
     * llamadas
     *
     * @param employeeTarget Empleado a liberar
     */
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
