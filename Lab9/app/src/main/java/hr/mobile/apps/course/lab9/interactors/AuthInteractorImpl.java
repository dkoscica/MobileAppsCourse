package hr.mobile.apps.course.lab9.interactors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import hr.mobile.apps.course.lab9.model.User;

public class AuthInteractorImpl implements AuthInteractor {

    private static final String TAG = AuthInteractorImpl.class.getSimpleName();

    private MutableLiveData<User> userLiveData;
    private MutableLiveData<String> tokenLiveData;

    public AuthInteractorImpl() {
        userLiveData = new MutableLiveData<>();
        tokenLiveData = new MutableLiveData<>();
    }

    public LiveData<User> validateToken() {
        //TODO implement Retrofit call
        userLiveData.postValue(null);
        return userLiveData;
    }

    public LiveData<String> login(String email, String password) {
        //TODO implement Retrofit call
        return tokenLiveData;
    }

}
