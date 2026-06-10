package com.airtribe.learntrack.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    public static boolean emailValidator(String email){

        String EMAIL_REGEX = "";
        Pattern Email_pattern = Pattern.compile(EMAIL_REGEX);

        if( email == null ) return false;

        Matcher matcher = Email_pattern.matcher(email);
        return matcher.matches();
    }
}
