package hr.mobile.apps.course.lab7.interactors;

import androidx.lifecycle.MutableLiveData;

import hr.mobile.apps.course.lab7.model.User;

public interface AuthInteractor {
    MutableLiveData<User> login(String email, String password);
}
