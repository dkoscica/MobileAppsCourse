package hr.mobile.apps.course.lab10.network;

public class SessionManager {

    private static SessionManager instance;

    private String token;

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
