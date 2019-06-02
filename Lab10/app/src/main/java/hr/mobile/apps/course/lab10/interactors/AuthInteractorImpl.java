package hr.mobile.apps.course.lab10.interactors;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import hr.mobile.apps.course.lab10.model.User;
import hr.mobile.apps.course.lab10.network.NetworkManager;
import hr.mobile.apps.course.lab10.network.SessionManager;
import hr.mobile.apps.course.lab10.network.request.LoginRequest;
import hr.mobile.apps.course.lab10.network.response.LoginResponse;
import hr.mobile.apps.course.lab10.network.response.TokenResponse;
import hr.mobile.apps.course.lab10.network.services.AuthService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthInteractorImpl implements AuthInteractor {

    private static final String TAG = AuthInteractorImpl.class.getSimpleName();

    private AuthService authService;

    private MutableLiveData<User> userLiveData;
    private MutableLiveData<String> tokenLiveData;

    public AuthInteractorImpl() {
        userLiveData = new MutableLiveData<>();
        tokenLiveData = new MutableLiveData<>();
        authService = NetworkManager.getInstance().getRetrofit().create(AuthService.class);
    }

    public LiveData<User> validateToken() {
        Call<TokenResponse> call = authService.validateToken();
        call.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                if (response.body() == null) {
                    userLiveData.postValue(null);
                    return;
                }
                User user = response.body().getResponse().getUser();
                userLiveData.postValue(user);
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable throwable) {
                Log.d(TAG, throwable.getLocalizedMessage());
            }
        });
        return userLiveData;
    }

    public LiveData<String> login(String email, String password) {
        Call<LoginResponse> call = authService.login(new LoginRequest(email, password));
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body() == null) {
                    return;
                }
                String token = response.body().getResponse().getToken();
                SessionManager.getInstance().setToken(token);
                tokenLiveData.postValue(token);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable throwable) {
                Log.d(TAG, throwable.getLocalizedMessage());
            }
        });
        return tokenLiveData;
    }

}
