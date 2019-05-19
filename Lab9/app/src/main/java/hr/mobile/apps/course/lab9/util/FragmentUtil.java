package hr.mobile.apps.course.lab9.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FragmentUtil {

    public static void attachFragment(FragmentManager fragmentManager, int containerViewId, Fragment fragment) {
        fragmentManager
                .beginTransaction()
                .add(containerViewId, fragment)
                .commit();
    }

    public static void replaceFragment(FragmentManager fragmentManager, int containerViewId, Fragment fragment) {
        fragmentManager
                .beginTransaction()
                .replace(containerViewId, fragment)
                .commit();
    }
}
