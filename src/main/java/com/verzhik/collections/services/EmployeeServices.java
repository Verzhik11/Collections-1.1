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
        this.employees = new Employee[5];
    }

    public void addEmployee(String name, String lastname) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        if (size > employees.length) {
            throw new EmployeeStorageIsFullException("Нельзя добавить сотрудника, массив заполнен");
        }
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employees[i].getName().equals(name) & employees[i].getLastname().equals(lastname)) {
                throw new EmployeeAlreadyAddedException("Нельзя добавить сотрудника, такой сотрудник уже есть в массиве");
            }
        }
        Employee newEmployee = new Employee(name, lastname);
        employees[size++] = newEmployee;
    }

    public void removeEmployee(String name, String lastname) throws EmployeeNotFoundException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName().equals(name) & employees[i].getLastname().equals(lastname)) {
                System.out.println(employees[i].getName() + " " + employees[i].getLastname() + "удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return;
            }
        }
        throw new EmployeeNotFoundException("Удаляемый сотрудник не найдет");
    }

    public void findEmployee(String name, String lastname) throws EmployeeNotFoundException {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employees[i].getName().equals(name) & employees[i].getLastname().equals(lastname)) {
                System.out.println(employee.getName() + " " +  employee.getLastname());
                return;
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
