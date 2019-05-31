package hr.mobile.apps.course.lab10.screen.splash;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import hr.mobile.apps.course.lab10.R;
import hr.mobile.apps.course.lab10.screen.home.HomeActivity;
import hr.mobile.apps.course.lab10.screen.login.LoginActivity;
import hr.mobile.apps.course.lab10.util.SystemUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemUtil.hideSystemUI(getWindow());
        setContentView(R.layout.activity_splash);

        SplashViewModel splashViewModel = ViewModelProviders.of(this).get(SplashViewModel.class);
        splashViewModel.validateToken().observe(SplashActivity.this, user -> {
            if (user == null) {
                LoginActivity.start(SplashActivity.this);
                return;
            }
            HomeActivity.start(SplashActivity.this);
        });
    }

}
