package hr.mobile.apps.course.lab10.screen.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import hr.mobile.apps.course.lab10.interactors.AuthInteractor;
import hr.mobile.apps.course.lab10.interactors.AuthInteractorImpl;

class LoginViewModel extends ViewModel {

    private AuthInteractor authInteractor = new AuthInteractorImpl();

    LiveData<String> loginUser(String username, String password) {
        return authInteractor.login(username, password);
    }

}
