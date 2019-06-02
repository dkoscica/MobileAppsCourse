package hr.mobile.apps.course.lab10.screen.login;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import hr.mobile.apps.course.lab10.R;
import hr.mobile.apps.course.lab10.screen.home.HomeActivity;
import hr.mobile.apps.course.lab10.util.IntentUtil;
import hr.mobile.apps.course.lab10.util.Validator;
import hr.mobile.apps.course.lab10.util.ViewUtil;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    public static void start(Context context) {
        IntentUtil.startWithClearTask(context, LoginActivity.class);
    }

    private LoginViewModel loginViewModel;

    // UI components
    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView websiteTextView;
    private Button loginButton;
    private ContentLoadingProgressBar loadingProgressBar;

    /**
     * Lifecycle methods
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupView();
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
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
        loadingProgressBar = findViewById(R.id.loadingProgressBar);

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
        String errorMessage = getString(R.string.error_invalid_credentials);

        if (!Validator.isValidEmail(email)) {
            showSnackbar(errorMessage);
            return;
        }
        if (!Validator.isValidPassword(password)) {
            showSnackbar(errorMessage);
            return;
        }
        loadingProgressBar.setVisibility(View.VISIBLE);
        loginViewModel.loginUser(email, password).observe(this, token -> {
            loadingProgressBar.setVisibility(View.INVISIBLE);
            if (token == null) {
                showSnackbar(errorMessage);
                return;
            }
            Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, HomeActivity.class));
        });
    }

    private void showSnackbar(String message) {
        LinearLayout loginActivityLayout = findViewById(R.id.loginActivityLayout);
        Snackbar.make(loginActivityLayout, message, Snackbar.LENGTH_SHORT).show();
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
