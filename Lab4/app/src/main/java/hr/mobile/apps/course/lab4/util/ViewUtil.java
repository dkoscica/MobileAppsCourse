package hr.mobile.apps.course.lab4.util;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class ViewUtil {

    public static void requestFocus(Window window, View view) {
        if (view.requestFocus()) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
