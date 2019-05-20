package hr.mobile.apps.course.lab9.repository;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import hr.mobile.apps.course.lab9.config.Mock;
import hr.mobile.apps.course.lab9.model.Book;
import hr.mobile.apps.course.lab9.network.services.BookService;

public class BookRepository {

    private static BookRepository instance;

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    private MutableLiveData<List<Book>> booksLiveData = new MutableLiveData<>();

    private BookRepository() {
        setupRepository();
    }

    private void setupRepository() {
        booksLiveData = new MutableLiveData<>();
        booksLiveData.setValue(new ArrayList<>());
    }

    public MutableLiveData<List<Book>> getBooks() {
        //TODO implement Retrofit call
        booksLiveData.setValue(Mock.BOOKS);
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
        if (booksLiveData.getValue() == null) {
            return;
        }
        List<Book> books = booksLiveData.getValue();
        books.add(book);
        booksLiveData.setValue(books);
    }
}
