package hr.mobile.apps.course.lab10.network.services;

import hr.mobile.apps.course.lab10.network.request.LoginRequest;
import hr.mobile.apps.course.lab10.network.response.LoginResponse;
import hr.mobile.apps.course.lab10.network.response.TokenResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {

    @POST("auth/me")
    Call<TokenResponse> validateToken();

    @POST("auth/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
}
