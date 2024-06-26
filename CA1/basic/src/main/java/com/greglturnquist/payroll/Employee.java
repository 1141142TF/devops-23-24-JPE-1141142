/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.payroll;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Entity // <1>
public class Employee {

    private @Id
    @GeneratedValue Long id; // <2>
    private String firstName;
    private String lastName;
    private String description;
    private Integer jobYears;
    private String email;

    private Employee() {
    }

    public Employee(String firstName, String lastName, String description, Integer jobYears, String email) throws InstantiationException {
        try {
            if (isConstructorArgumentsValid(firstName, lastName, description, jobYears,email)) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.description = description;
                this.jobYears = jobYears;
                this.email = email;
            }
        } catch (Exception e) {
            throw new InstantiationException(e.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(jobYears, employee.jobYears) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(description, employee.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, description, jobYears, email);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getJobYears() {
        return jobYears;
    }

    public void setJobYears(int jobYears) {
        this.jobYears = jobYears;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                ", jobYears='" + jobYears + '\'' +
                '}';
    }


    private boolean isConstructorArgumentsValid(String firstName, String lastName, String description, Integer jobYears,String emailAddress) throws InstantiationException {

        if (firstName == null || firstName.isEmpty() || firstName.isBlank()) {
            throw new InstantiationException("Invalid first name.");
        }
        if (lastName == null || lastName.isEmpty() || lastName.isBlank()) {
            throw new InstantiationException("Invalid last name.");
        }
        if (description == null || description.isEmpty() || description.isBlank()) {
            throw new InstantiationException("Invalid description.");
        }
        if (jobYears == null || jobYears < 0) {
            throw new InstantiationException("Invalid quantity of job years.");
        }
        if (!patternMatches(emailAddress)) {
            throw new InstantiationException("Invalid quantity of job years.");
        }

        return true;
    }

    private static boolean patternMatches(String emailAddress) {
        return Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
                .matcher(emailAddress)
                .matches();
    }
}
// end::code[]
