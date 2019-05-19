package hr.mobile.apps.course.lab9.repository;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import hr.mobile.apps.course.lab9.config.Mock;
import hr.mobile.apps.course.lab9.model.Book;

public class BookRepository {

    private static BookRepository instance;

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    private List<Book> books = new ArrayList<>();
    private MutableLiveData<List<Book>> liveDataBooks = new MutableLiveData<>();

    private BookRepository() {
        setupRepository();
    }

    private void setupRepository() {
        books.addAll(Mock.BOOKS);
        liveDataBooks = new MutableLiveData<>();
        liveDataBooks.setValue(books);
    }

    public MutableLiveData<List<Book>> getBooks() {
        return liveDataBooks;
    }

    public Book findBookById(long id) {
        if (liveDataBooks.getValue() == null) {
            return null;
        }
        for (Book book : liveDataBooks.getValue()) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        books.add(book);
        liveDataBooks.postValue(books);
    }
}
