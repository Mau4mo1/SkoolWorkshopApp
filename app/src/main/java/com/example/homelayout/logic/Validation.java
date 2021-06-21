package com.example.homelayout.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String VALID_EMAIL_ADDRESS_REGEX = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
    public static final String VALID_PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{12,24}$";

    private static final Pattern passwordPattern = Pattern.compile(VALID_PASSWORD_REGEX);
    private static final Pattern pattern = Pattern.compile(VALID_EMAIL_ADDRESS_REGEX);

    public boolean validateEmail(String email){
        Matcher matcher = pattern.matcher(email);
        System.out.println(email + " : " + matcher.matches());
        return matcher.matches();
    }

    public boolean validatePassword(String password){
        Matcher matcher = passwordPattern.matcher(password);
        System.out.println(password + " : " + matcher.matches());
        return matcher.matches();
    }
}
