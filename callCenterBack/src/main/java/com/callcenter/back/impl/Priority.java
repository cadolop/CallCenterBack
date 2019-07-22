package com.callcenter.back.impl;

import java.util.Comparator;

import com.callcenter.back.model.Employee;

/**
 * <h1>Clase Priorty</h1>
 * Clase de ordenamiento de prioridades al recibir una llamada
 *
 * @author  <a href="mailto:cadolop@gmail.com">Carlos Adolfo Lopez</a>
 * @version 1.0
 * @since 20/07/2019
 * @project CallCenterBack
 */
public class Priority implements Comparator<Employee> {
	
	@Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.getPriority(), e2.getPriority());
    }
	
}
