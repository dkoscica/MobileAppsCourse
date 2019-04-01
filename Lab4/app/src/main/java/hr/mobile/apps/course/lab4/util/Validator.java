package hr.mobile.apps.course.lab4.util;

import android.text.TextUtils;
import android.util.Patterns;

public class Validator {

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPassword(String password) {
        return !TextUtils.isEmpty(password) && password.length() > 5;
    }
}
