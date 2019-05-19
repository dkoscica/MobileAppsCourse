package hr.mobile.apps.course.lab9.interactors;

import androidx.lifecycle.MutableLiveData;

import hr.mobile.apps.course.lab9.config.Mock;
import hr.mobile.apps.course.lab9.model.User;

public class AuthInteractorMockImpl implements AuthInteractor {

    private static final int DELAY_IN_MS = 2000;

    private MutableLiveData<User> liveDataUser;
    private MutableLiveData<String> liveDataToken;

    public AuthInteractorMockImpl() {
        liveDataUser = new MutableLiveData<>();
        liveDataToken = new MutableLiveData<>();
    }

    public MutableLiveData<User> login(String email, String password) {
        new Thread(() -> {
            try {
                Thread.sleep(DELAY_IN_MS);
                if (email.equals(Mock.Credentials.EMAIL) && password.equals(Mock.Credentials.PASSWORD)) {
                    liveDataUser.postValue(Mock.USER);
                    return;
                }
                liveDataUser.postValue(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        return liveDataUser;
    }

    public MutableLiveData<String> retrieveToken() {
        liveDataToken.setValue(Mock.Credentials.TOKEN);
        return liveDataToken;
    }

}
