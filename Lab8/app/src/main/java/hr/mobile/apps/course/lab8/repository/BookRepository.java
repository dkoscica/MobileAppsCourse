package hr.mobile.apps.course.lab8.repository;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import hr.mobile.apps.course.lab8.model.Book;

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
        initRepository();
    }

    private void initRepository() {
        books = new ArrayList<Book>() {{
            add(new Book(1, "Head First Android Development", "Dawn Griffiths ", 2017, 45.0, "https://covers.oreillystatic.com/images/0636920029045/lrg.jpg"));
            add(new Book(2, "Android Studio 3.0 Development Essentials - Android 8 Edition", "Neil Smyth", 2017, 50.0, "https://images-na.ssl-images-amazon.com/images/I/81CW6SaZtfL.jpg"));
            add(new Book(3, "Android Programming: The Big Nerd Ranch Guide (3rd Edition)", "Bill Phillips, Chris Stewart, and Kristin Marsicano", 2017, 55.0, "https://www.bignerdranch.com/assets/img/books/covers/android.jpg"));
            add(new Book(4, "The Busy Coder's Guide to Android Development", "Mark L. Murphy", 2019, 20.0, "https://images-na.ssl-images-amazon.com/images/I/515B4rm-BlL._SX258_BO1,204,203,200_.jpg"));

        }};
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
        liveDataBooks.setValue(books);
    }
}
