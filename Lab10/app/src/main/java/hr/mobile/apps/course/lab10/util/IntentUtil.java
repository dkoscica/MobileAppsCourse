package hr.mobile.apps.course.lab10.util;

import android.content.Context;
import android.content.Intent;

public class IntentUtil {

    public static void startWithClearTask(Context context, Class cls) {
        Intent intent = new Intent(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
