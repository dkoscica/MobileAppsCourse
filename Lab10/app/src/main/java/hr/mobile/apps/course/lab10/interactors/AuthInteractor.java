package hr.mobile.apps.course.lab10.interactors;

import androidx.lifecycle.LiveData;

import hr.mobile.apps.course.lab10.model.User;

public interface AuthInteractor {
    LiveData<User> validateToken();
    LiveData<String> login(String email, String password);
}
