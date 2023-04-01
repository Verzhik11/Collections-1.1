package com.verzhik.collections.services;

import com.verzhik.collections.exceptions.EmployeeAlreadyAddedException;
import com.verzhik.collections.exceptions.EmployeeNotFoundException;
import com.verzhik.collections.exceptions.EmployeeStorageIsFullException;
import com.verzhik.collections.objects.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {
    private final Employee[] employees;
    private int size;

    public EmployeeServices() {
        this.employees = new Employee[2];
    }

    public Employee addEmployee(String name, String lastname) {
        if (size >= employees.length) {
            throw new EmployeeStorageIsFullException("Нельзя добавить сотрудника, массив заполнен");
        }
        Employee newEmployee = new Employee(name, lastname);
        for (int i = 0; i < size; i++) {
            if (employees[i].equals(newEmployee)) {
                throw new EmployeeAlreadyAddedException("Нельзя добавить сотрудника, такой сотрудник уже есть в массиве");
            }
        }
        employees[size] = newEmployee;
        size++;
        return newEmployee;
    }

    public Employee removeEmployee(String name, String lastname) {
        Employee removeEmployee = new Employee(name, lastname);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(removeEmployee)) {
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return removeEmployee;
            }
        }
        throw new EmployeeNotFoundException("Удаляемый сотрудник не найден");
    }

    public Employee findEmployee(String name, String lastname) {
        Employee findEmployee = new Employee(name, lastname);
        for (int i = 0; i < size; i++) {
            if (employees[i].equals(findEmployee)) {
                return findEmployee;
            }
        }
        throw new EmployeeNotFoundException(name + " " + lastname + " не найден");

    }

    public void printEmployees() {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            System.out.println(employee.getName() + " " + employee.getLastname());
        }
    }

    public int getCurrenSize() {
        return size;
    }

}
