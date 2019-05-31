package hr.mobile.apps.course.lab10.network.services;

import hr.mobile.apps.course.lab10.network.response.BookResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BookService {

    @GET("books")
    Call<BookResponse> getBooks();
}
