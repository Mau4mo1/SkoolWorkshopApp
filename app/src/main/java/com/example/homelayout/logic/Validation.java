package com.example.homelayout.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String VALID_EMAIL_ADDRESS_REGEX = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
    public static final String VALID_PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{12,24}$";
    public static final String VALID_NAME_REGEX = "^[a-zA-Z]+$";
    public static final String VALID_POSTAL_REGEX = "^[1-9][0-9]{3} ?(?!sa|sd|ss)[a-zA-Z]{2}$";
    public static final String VALID_PHONENUMBER_REGEX = "^[0][0-9]{9}$";

    private static final Pattern passwordPattern = Pattern.compile(VALID_PASSWORD_REGEX);
    private static final Pattern emailPattern = Pattern.compile(VALID_EMAIL_ADDRESS_REGEX);
    private static final Pattern namePattern = Pattern.compile(VALID_NAME_REGEX);
    private static final Pattern postalCodePattern = Pattern.compile(VALID_POSTAL_REGEX);
    private static final Pattern phonenumberPattern = Pattern.compile(VALID_PHONENUMBER_REGEX);


    public boolean validateEmail(String email){
        Matcher matcher = emailPattern.matcher(email);
        System.out.println(email + " : " + matcher.matches());
        return matcher.matches();
    }

    public boolean validatePassword(String password){
        Matcher matcher = passwordPattern.matcher(password);
        System.out.println(password + " : " + matcher.matches());
        return matcher.matches();
    }

    public boolean validateName(String name){
        Matcher matcher = namePattern.matcher(name);
        boolean b = matcher.matches();
        return b;
    }
    public boolean validatePostalCode(String postalCode){
        Matcher matcher = postalCodePattern.matcher(postalCode);
        boolean b = matcher.matches();
        return b;
    }

    public boolean validatePhonenumber(String phonenumber){
        Matcher matcher = phonenumberPattern.matcher( phonenumber);
        return matcher.matches();
    }


}
