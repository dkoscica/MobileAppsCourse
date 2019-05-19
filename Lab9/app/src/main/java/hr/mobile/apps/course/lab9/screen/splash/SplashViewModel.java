package hr.mobile.apps.course.lab9.screen.splash;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import hr.mobile.apps.course.lab9.interactors.AuthInteractor;
import hr.mobile.apps.course.lab9.interactors.AuthInteractorMockImpl;

public class SplashViewModel extends ViewModel {

    private AuthInteractor authInteractor = new AuthInteractorMockImpl();

    public LiveData<String> retrieveToken() {
        return authInteractor.retrieveToken();
    }
}
