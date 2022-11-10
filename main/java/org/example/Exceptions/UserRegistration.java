package org.example.Exceptions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


interface UserDetailsValidationFI {
    boolean validate(String x) throws UserRegistrationException;
}


public class UserRegistration {
    UserDetailsValidationFI validateFirstName = firstName -> {
        // regex pattern for firstname
        if (Pattern.matches("[A-Z][a-z A-Z]{2,}", firstName))
            return true;
        else
            throw new UserRegistrationException("Invalid First Name");
    };

    UserDetailsValidationFI validateLastName = lastName -> {
        // regex pattern for lastname
        if (Pattern.matches("[A-Z][a-z A-Z]{2,}", lastName))
            return true;
        else
            throw new UserRegistrationException("Invalid Last Name");
    };

    UserDetailsValidationFI validateEmail = email -> {
        // regex pattern for email
        if (Pattern.matches("[\\w+-]+(?:\\.[\\w+-]+)*[@][\\w]{1,}([.]{1}[a-z]{2,}){1,2}", email))
            return true;
        else
            throw new UserRegistrationException("Invalid Email");
    };

    UserDetailsValidationFI validateMobileNumber = mobileNumber -> {
        // regex pattern for mobile number
        if (Pattern.matches("[+]91 [6-9]\\d{9}", mobileNumber))
            return true;
        else
            throw new UserRegistrationException("Invalid Mobile Number");
    };

    UserDetailsValidationFI validatePassword = password -> {
        // regex pattern for password
        if (Pattern.matches("(?=.*[A-Z])(?=.*\\d)(?=.*[$&+,:;=?@#|'<>.-^*()%!])[a-z A-Z \\d $&+,:;=?@#|'<>.-^*()%!]{8,}", password))
            return true;
        else
            throw new UserRegistrationException("Invalid Password");
    };
}
