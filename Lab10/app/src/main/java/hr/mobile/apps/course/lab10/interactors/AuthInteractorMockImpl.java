package hr.mobile.apps.course.lab10.interactors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import hr.mobile.apps.course.lab10.config.Mock;
import hr.mobile.apps.course.lab10.model.User;

public class AuthInteractorMockImpl implements AuthInteractor {

    private static final int DELAY_IN_MS = 2000;

    private MutableLiveData<User> userLiveData;
    private MutableLiveData<String> tokenLiveData;

    public AuthInteractorMockImpl() {
        userLiveData = new MutableLiveData<>();
        tokenLiveData = new MutableLiveData<>();
    }

    public LiveData<User> validateToken() {
        userLiveData.setValue(Mock.USER);
        return userLiveData;
    }

    public LiveData<String> login(String email, String password) {
        new Thread(() -> {
            try {
                Thread.sleep(DELAY_IN_MS);
                if (email.equals(Mock.Credentials.EMAIL) && password.equals(Mock.Credentials.PASSWORD)) {
                    tokenLiveData.postValue(Mock.Credentials.TOKEN);
                    return;
                }
                tokenLiveData.postValue(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        return tokenLiveData;
    }

}
