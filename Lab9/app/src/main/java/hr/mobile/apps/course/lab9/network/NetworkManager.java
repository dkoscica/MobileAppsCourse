package hr.mobile.apps.course.lab9.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    private static final String BASE_URL = "http://185.103.219.195:80/api/";

    private Retrofit retrofit;

    private static NetworkManager instance;

    public static NetworkManager getInstance() {
        if (instance == null) {
            instance = new NetworkManager();
        }
        return instance;
    }

    private NetworkManager() {
        //TODO Use the Retrofit.Builder() to create an retrofit object
        // https://www.baeldung.com/retrofit
    }

    private OkHttpClient provideClient(SessionManager sessionManager) {
        return new OkHttpClient.Builder().addInterceptor(chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + sessionManager.getToken())
                    .build();
            return chain.proceed(newRequest);
        }).build();
    }

    private GsonConverterFactory provideConverterFactory() {
        Gson gson = new GsonBuilder().create();
        return GsonConverterFactory.create(gson);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

}
