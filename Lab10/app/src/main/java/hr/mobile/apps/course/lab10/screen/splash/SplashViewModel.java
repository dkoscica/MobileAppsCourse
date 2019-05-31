package hr.mobile.apps.course.lab10.screen.splash;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import hr.mobile.apps.course.lab10.interactors.AuthInteractor;
import hr.mobile.apps.course.lab10.interactors.AuthInteractorImpl;
import hr.mobile.apps.course.lab10.model.User;

class SplashViewModel extends ViewModel {

    private AuthInteractor authInteractor = new AuthInteractorImpl();

    LiveData<User> validateToken() {
        return authInteractor.validateToken();
    }
}
