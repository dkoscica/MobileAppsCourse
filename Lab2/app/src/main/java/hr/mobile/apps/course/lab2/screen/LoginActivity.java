package hr.mobile.apps.course.lab2.screen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import hr.mobile.apps.course.lab2.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    // UI components

    /**
     * Lifecycle methods
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupView();
    }

    /**
     * Private methods
     */
    private void setupView() {
        //TODO initialize UI components
    }

}
