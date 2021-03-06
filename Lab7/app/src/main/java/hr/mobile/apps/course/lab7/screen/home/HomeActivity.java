package hr.mobile.apps.course.lab7.screen.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import hr.mobile.apps.course.lab7.R;
import hr.mobile.apps.course.lab7.screen.home.fragment.BookRVFragment;
import hr.mobile.apps.course.lab7.util.FragmentUtil;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FragmentUtil.attachFragment(getSupportFragmentManager(), R.id.fragmentContainer, new BookRVFragment());
    }

}
