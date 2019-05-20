package hr.mobile.apps.course.lab9.screen.splash;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import hr.mobile.apps.course.lab9.interactors.AuthInteractor;
import hr.mobile.apps.course.lab9.interactors.AuthInteractorMockImpl;
import hr.mobile.apps.course.lab9.model.User;

class SplashViewModel extends ViewModel {

    private AuthInteractor authInteractor = new AuthInteractorMockImpl();

    LiveData<User> validateToken() {
        return authInteractor.validateToken();
    }
}
