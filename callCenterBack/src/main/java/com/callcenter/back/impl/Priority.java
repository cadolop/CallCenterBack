package com.callcenter.back.impl;

import java.util.Comparator;

import com.callcenter.back.model.Employee;

public class Priority implements Comparator<Employee> {
	
	@Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.getPriority(), e2.getPriority());
    }
	
}
