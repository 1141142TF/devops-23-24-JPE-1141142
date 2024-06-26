package com.greglturnquist.payroll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeTest {

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyStringParameter_shouldThrowException(String firstName) throws InstantiationException {
        //Arrange
        String lastName = "Nabo";
        String description = "Legume";
        Integer jobYears = 2;
        String expectedMessage = "Invalid first name.";
        String email="mail@algo.pt";

        //Act

        Exception exception = assertThrows(InstantiationException.class, () ->
                new Employee(firstName, lastName, description, jobYears,email)
        );

        //Assert
        assertEquals(expectedMessage, exception.getMessage());

    }

    @Test
    void negativeJobYears_shouldThrowException() throws InstantiationException {
        //Arrange
        String firstName = "Senhor";
        String lastName = "Nabo";
        String description = "Legume";
        Integer jobYears = -2;
        String expectedMessage = "Invalid quantity of job years.";
        String email="mail@algo.pt";

        //Act

        Exception exception = assertThrows(InstantiationException.class, () ->
                new Employee(firstName, lastName, description, jobYears,email)
        );

        //Assert
        assertEquals(expectedMessage, exception.getMessage());

    }

    @Test
    void validArguments_shouldConstructEmployee() throws InstantiationException {
        //Arrange
        String firstName = "Senhor";
        String lastName = "Nabo";
        String description = "Legume";
        Integer jobYears = 2;
        String email="mail@algo.pt";

        //Act
        Employee test = new Employee(firstName, lastName, description, jobYears,email);

        //Assert
        assertEquals(firstName, test.getFirstName());
        assertEquals(lastName, test.getLastName());
        assertEquals(description, test.getDescription());
        assertEquals(jobYears, test.getJobYears());
        assertEquals(email, test.getEmail());
    }

    @Test
    void invalidEmail_shouldThrowException() throws InstantiationException {
        //Arrange
        String firstName = "Senhor";
        String lastName = "Nabo";
        String description = "Legume";
        Integer jobYears = -2;
        String expectedMessage = "Invalid quantity of job years.";
        String email="ma.i.l@algo.pt";

        //Act

        Exception exception = assertThrows(InstantiationException.class, () ->
                new Employee(firstName, lastName, description, jobYears,email)
        );

        //Assert
        assertEquals(expectedMessage, exception.getMessage());

    }

    @Test
    void blankInvalidEmail_shouldThrowException() throws InstantiationException {
        //Arrange
        String firstName = "Senhor";
        String lastName = "Nabo";
        String description = "Legume";
        Integer jobYears = -2;
        String expectedMessage = "Invalid quantity of job years.";
        String email="@algo.pt";

        //Act

        Exception exception = assertThrows(InstantiationException.class, () ->
                new Employee(firstName, lastName, description, jobYears,email)
        );

        //Assert
        assertEquals(expectedMessage, exception.getMessage());

    }

}
