package hr.mobile.apps.course.lab10.screen.home;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import hr.mobile.apps.course.lab10.R;
import hr.mobile.apps.course.lab10.screen.home.fragment.BookRVFragment;
import hr.mobile.apps.course.lab10.util.FragmentUtil;
import hr.mobile.apps.course.lab10.util.IntentUtil;

public class HomeActivity extends AppCompatActivity {

    public static void start(Context context) {
        IntentUtil.startWithClearTask(context, HomeActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FragmentUtil.attachFragment(getSupportFragmentManager(), R.id.fragmentContainer, new BookRVFragment());
    }

}
