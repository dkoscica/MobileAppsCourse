package hr.mobile.apps.course.lab6.screen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import hr.mobile.apps.course.lab6.R;
import hr.mobile.apps.course.lab6.screen.home.HomeActivity;
import hr.mobile.apps.course.lab6.util.Validator;
import hr.mobile.apps.course.lab6.util.ViewUtil;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    // UI components
    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView websiteTextView;
    private Button loginButton;

    /**
     * Lifecycle methods
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        addTextWatchers();
    }


    @Override
    protected void onStop() {
        super.onStop();
        removeTextWatchers();
    }

    /**
     * Private methods
     */
    private void setupView() {
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        websiteTextView = findViewById(R.id.websiteTextView);

        websiteTextView.setOnClickListener(v -> openWebsite());
        loginButton.setOnClickListener(v -> submitForm());
    }

    private void openWebsite() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url_university_website)));
        startActivity(intent);
    }

    private void submitForm() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (!Validator.isValidEmail(email)) {
            showInvalidCredentialsMessage();
            return;
        }
        if (!Validator.isValidPassword(password)) {
            showInvalidCredentialsMessage();
            return;
        }
        startActivity(new Intent(this, HomeActivity.class));
    }

    private void showInvalidCredentialsMessage() {
        LinearLayout loginActivityLayout = findViewById(R.id.loginActivityLayout);
        Snackbar.make(loginActivityLayout, getString(R.string.error_invalid_credentials), Snackbar.LENGTH_SHORT).show();
    }

    private void addTextWatchers() {
        emailEditText.addTextChangedListener(emailTextWatcher);
        passwordEditText.addTextChangedListener(passwordTextWatcher);
    }

    private void removeTextWatchers() {
        emailEditText.removeTextChangedListener(emailTextWatcher);
        passwordEditText.removeTextChangedListener(passwordTextWatcher);
    }

    private TextWatcher emailTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            TextInputLayout emailInputLayout = findViewById(R.id.emailInputLayout);
            if (Validator.isValidEmail(editable.toString())) {
                emailInputLayout.setErrorEnabled(false);
                return;
            }
            emailInputLayout.setError(getString(R.string.error_email));
            ViewUtil.requestFocus(getWindow(), emailEditText);
        }
    };

    private TextWatcher passwordTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            TextInputLayout passwordInputLayout = findViewById(R.id.passwordInputLayout);
            if (Validator.isValidPassword(editable.toString())) {
                passwordInputLayout.setErrorEnabled(false);
                return;
            }
            passwordInputLayout.setError(getString(R.string.error_password));
            ViewUtil.requestFocus(getWindow(), passwordEditText);
        }
    };
}
