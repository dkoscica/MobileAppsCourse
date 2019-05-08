package hr.mobile.apps.course.lab8.interactors;

import androidx.lifecycle.MutableLiveData;

import hr.mobile.apps.course.lab8.config.Mock;
import hr.mobile.apps.course.lab8.model.User;

public class AuthInteractorMockImpl implements AuthInteractor {

    private MutableLiveData<User> liveDataUser;

    public AuthInteractorMockImpl() {
        liveDataUser = new MutableLiveData<>();
    }

    public MutableLiveData<User> login(String email, String password) {
        if (email.equals(Mock.Credentials.EMAIL) && password.equals(Mock.Credentials.PASSWORD)) {
            liveDataUser.setValue(Mock.USER);
            return liveDataUser;
        }
        liveDataUser.setValue(null);
        return liveDataUser;
    }

}
