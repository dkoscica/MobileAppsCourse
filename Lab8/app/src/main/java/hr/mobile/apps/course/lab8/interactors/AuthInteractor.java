package hr.mobile.apps.course.lab8.interactors;

import androidx.lifecycle.MutableLiveData;

import hr.mobile.apps.course.lab8.model.User;

public interface AuthInteractor {
    MutableLiveData<User> login(String email, String password);
}
