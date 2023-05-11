package me.siyum.ihungry.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean isTextFieldValid(Rgex textField, String text) {
        String field = "";
        switch (textField) {
            case SRI_LANKA_MOBILE:
                field = "^[0]{1}[7]{1}[01245678]{1}[0-9]{7}$";
                break;
            case DOUBLE:
                field = "^([0-9]){1,}[.]([0-9]){1,}$";
                break;
            case INTEGER:
                field = "^([0-9]){1,}$";
                break;
        }

        Pattern pattern = Pattern.compile(field);
        if (text != null) {
            if (text.trim().isEmpty()) {
                return false;
            }
        } else {
            return false;
        }
        Matcher matcher = pattern.matcher(text);

        return matcher.matches();
    }

}
