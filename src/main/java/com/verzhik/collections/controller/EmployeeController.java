package com.verzhik.collections.controller;

import com.verzhik.collections.objects.Employee;
import com.verzhik.collections.services.EmployeeServices;
import com.verzhik.collections.services.EmployeeServicesList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    //public EmployeeServices employeeServices;
    public EmployeeServicesList employeeServicesList;

    //public EmployeeController(EmployeeServices employeeServices) {
        //this.employeeServices = employeeServices;
    //}

    public EmployeeController(EmployeeServicesList employeeServicesList) {
        this.employeeServicesList = employeeServicesList;
    }

    @GetMapping
    public String start() {
        return "Hello";
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam(required = false) String name, @RequestParam(required = false) String lastname) {
        return employeeServicesList.addEmployee(name, lastname);
    }
    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam(required = false) String name, @RequestParam(required = false) String lastname) {
        return employeeServicesList.removeEmployee(name, lastname);
    }
   @GetMapping(path = "/find")
   public Employee findEmployee(@RequestParam(required = false) String name, @RequestParam(required = false) String lastname) {
         return employeeServicesList.findEmployee(name, lastname);
    }
    @GetMapping(path = "/print")
   public List<Employee> printEmployee(@RequestParam(required = false) String name, @RequestParam(required = false) String lastname) {
         return employeeServicesList.printEmployee(name, lastname);
    }
}
