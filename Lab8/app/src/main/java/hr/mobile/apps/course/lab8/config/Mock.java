package hr.mobile.apps.course.lab8.config;

import hr.mobile.apps.course.lab8.model.User;

public class Mock {

    public class Credentials {
        public static final String EMAIL = "student@gmail.com";
        public static final String PASSWORD = "password";
        public static final String TOKEN = "EvNElvTOZvi1fnczpuVR77dQT3GlKkjtaRSFZmEo";
    }

    public static final User USER = new User(Credentials.EMAIL, Credentials.TOKEN);

}
