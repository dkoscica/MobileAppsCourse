package hr.mobile.apps.course.lab9.interactors;

import androidx.lifecycle.MutableLiveData;

import hr.mobile.apps.course.lab9.model.User;

public interface AuthInteractor {
    MutableLiveData<User> login(String email, String password);
    MutableLiveData<String> retrieveToken();
}
