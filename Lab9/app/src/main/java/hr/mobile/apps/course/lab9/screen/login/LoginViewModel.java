package hr.mobile.apps.course.lab9.screen.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import hr.mobile.apps.course.lab9.interactors.AuthInteractor;
import hr.mobile.apps.course.lab9.interactors.AuthInteractorMockImpl;
import hr.mobile.apps.course.lab9.model.User;

public class LoginViewModel extends ViewModel {

    private AuthInteractor authInteractor = new AuthInteractorMockImpl();

    public MutableLiveData<User> loginUser(String username, String password) {
        return authInteractor.login(username, password);
    }

}
