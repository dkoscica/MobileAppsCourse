package hr.mobile.apps.course.lab9.screen.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import hr.mobile.apps.course.lab9.interactors.AuthInteractor;
import hr.mobile.apps.course.lab9.interactors.AuthInteractorMockImpl;

class LoginViewModel extends ViewModel {

    private AuthInteractor authInteractor = new AuthInteractorMockImpl();

    LiveData<String> loginUser(String username, String password) {
        return authInteractor.login(username, password);
    }

}
