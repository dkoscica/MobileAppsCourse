package hr.mobile.apps.course.lab10.repository;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import hr.mobile.apps.course.lab10.model.Book;
import hr.mobile.apps.course.lab10.network.NetworkManager;
import hr.mobile.apps.course.lab10.network.response.BookResponse;
import hr.mobile.apps.course.lab10.network.services.BookService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookRepository {

    private static BookRepository instance;

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    private MutableLiveData<List<Book>> booksLiveData = new MutableLiveData<>();
    private BookService bookService;

    private BookRepository() {
        setupRepository();
    }

    private void setupRepository() {
        booksLiveData = new MutableLiveData<>();
        booksLiveData.setValue(new ArrayList<>());
        bookService = NetworkManager.getInstance().getRetrofit().create(BookService.class);
    }

    public MutableLiveData<List<Book>> getBooks() {
        Call<BookResponse> call = bookService.getBooks();
        call.enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                if (response.body() == null) {
                    return;
                }
                if (response.body().isSuccess()) {
                    booksLiveData.postValue(response.body().getResponse().getBooks());
                }
            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {
            }
        });
        return booksLiveData;
    }

    public Book findBookById(long id) {
        if (booksLiveData.getValue() == null) {
            return null;
        }
        for (Book book : booksLiveData.getValue()) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        //TODO Add to database
    }
}
