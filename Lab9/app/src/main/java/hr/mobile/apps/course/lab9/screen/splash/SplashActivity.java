package hr.mobile.apps.course.lab9.screen.splash;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import hr.mobile.apps.course.lab9.R;
import hr.mobile.apps.course.lab9.screen.home.HomeActivity;
import hr.mobile.apps.course.lab9.screen.login.LoginActivity;
import hr.mobile.apps.course.lab9.util.IntentUtil;
import hr.mobile.apps.course.lab9.util.SystemUtil;

public class SplashActivity extends AppCompatActivity {

    private static final int DELAY_IN_MS = 2000;

    private SplashViewModel splashViewModel;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemUtil.hideSystemUI(getWindow());
        setContentView(R.layout.activity_splash);

        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel.class);

        handler = new Handler();
        handler.postDelayed(() -> splashViewModel.retrieveToken().observe(SplashActivity.this, token -> {
            Class nextActivityClass = token == null ? HomeActivity.class : LoginActivity.class;
            IntentUtil.startWithClearTask(SplashActivity.this, nextActivityClass);
        }), DELAY_IN_MS);
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacksAndMessages(null);
    }

}
