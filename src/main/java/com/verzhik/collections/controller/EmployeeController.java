package com.verzhik.collections.controller;

import com.verzhik.collections.services.EmployeeServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    public EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping
    public String start() {
        return "Hello";
    }
    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam(required = false) String name, @RequestParam(required = false) String lastname) {
        return name + " " + lastname;


    }





}
