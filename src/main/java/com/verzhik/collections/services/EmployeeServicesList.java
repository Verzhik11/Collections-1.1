package com.verzhik.collections.services;

import com.verzhik.collections.exceptions.EmployeeAlreadyAddedException;
import com.verzhik.collections.exceptions.EmployeeNotFoundException;
import com.verzhik.collections.exceptions.EmployeeStorageIsFullException;
import com.verzhik.collections.objects.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class EmployeeServicesList {
    List<Employee> employees;
    private int size = 2;

    public EmployeeServicesList(List<Employee> employees) {
        this.employees = new ArrayList<>();
    }

    public Employee addEmployee(String name, String lastname) {
        if (employees.size()> size) {
            throw new EmployeeStorageIsFullException("Нельзя добавить сотрудника, массив заполнен");
        }
        Employee newEmployee = new Employee(name, lastname);
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Нельзя добавить сотрудника, такой сотрудник уже есть в массиве");
        }
        employees.add(newEmployee);
        return newEmployee;
    }
    public Employee removeEmployee(String name, String lastname) {
        Employee removeEmployee = new Employee(name, lastname);
        if (employees.contains(removeEmployee)) {
            employees.remove(removeEmployee);
                return removeEmployee;
            }
        throw new EmployeeNotFoundException("Удаляемый сотрудник не найден");
    }
    public Employee findEmployee(String name, String lastname) {
        Employee findEmployee = new Employee(name, lastname);
            if (employees.contains(findEmployee)) {
                return findEmployee;
            }
        throw new EmployeeNotFoundException(findEmployee + "не найден");

    }
    public List<Employee> printEmployee (String name, String lastname) {
        return employees;
        }
}

