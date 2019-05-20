package hr.mobile.apps.course.lab9.screen.splash;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import hr.mobile.apps.course.lab9.R;
import hr.mobile.apps.course.lab9.screen.home.HomeActivity;
import hr.mobile.apps.course.lab9.screen.login.LoginActivity;
import hr.mobile.apps.course.lab9.util.IntentUtil;
import hr.mobile.apps.course.lab9.util.SystemUtil;

public class SplashActivity extends AppCompatActivity {

    private SplashViewModel splashViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemUtil.hideSystemUI(getWindow());
        setContentView(R.layout.activity_splash);

        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel.class);
        splashViewModel.validateToken().observe(SplashActivity.this, user -> {
            Class nextActivityClass = user == null ? LoginActivity.class : HomeActivity.class;
            IntentUtil.startWithClearTask(SplashActivity.this, nextActivityClass);
        });
    }

}
