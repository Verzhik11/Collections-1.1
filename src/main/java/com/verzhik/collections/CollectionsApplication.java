package com.verzhik.collections;

import com.verzhik.collections.services.EmployeeServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollectionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollectionsApplication.class, args);
        EmployeeServices employeeServices = new EmployeeServices();
        employeeServices.addEmployee("Максим", "Ласточкин");
        employeeServices.addEmployee("Олег", "Иванов");

        employeeServices.printEmployees();
    }

}
