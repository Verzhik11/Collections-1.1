package com.verzhik.collections.objects;

import java.util.Objects;

public class Employee {
        private final String name;
        private final String lastname;


        public Employee(String name, String lastname) {
            this.name = name;
            this.lastname = lastname;
        }

        public String toString() {
            return "Работник" + " " + this.name + this.lastname;
        }

        public String getName() {
            return name;
        }
        public String getLastname() {
            return lastname;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && lastname.equals(employee.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname);
    }
}

