package hr.mobile.apps.course.lab10.database;


import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import hr.mobile.apps.course.lab10.model.Publisher;

public class PublisherConverter {

    //Room will automatically convert custom obj into string and store in DB
    @TypeConverter
    public static String fromPublisherToJson(Publisher publisher) {
        return new Gson().toJson(publisher);
    }

    //At the time of fetching records room will automatically convert string to respective obj
    @TypeConverter
    public static Publisher fromJsonToPublisher(String value) {
        Type type = new TypeToken<Publisher>() {
        }.getType();
        return new Gson().fromJson(value, type);
    }

}
