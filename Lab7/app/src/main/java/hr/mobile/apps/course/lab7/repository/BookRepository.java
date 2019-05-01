package hr.mobile.apps.course.lab7.repository;

import java.util.ArrayList;
import java.util.List;

import hr.mobile.apps.course.lab7.model.Book;

public class BookRepository {

    private List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
        books.add(new Book(1, "Head First Android Development", "Dawn Griffiths ", 2017, 45.0, "https://covers.oreillystatic.com/images/0636920029045/lrg.jpg"));
        books.add(new Book(2, "Android Studio 3.0 Development Essentials - Android 8 Edition", "Neil Smyth", 2017, 50.0, "https://images-na.ssl-images-amazon.com/images/I/81CW6SaZtfL.jpg"));
        books.add(new Book(3, "Android Programming: The Big Nerd Ranch Guide (3rd Edition)", "Bill Phillips, Chris Stewart, and Kristin Marsicano", 2017, 55.0, "https://www.bignerdranch.com/assets/img/books/covers/android.jpg"));
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book findBookById(long id) {
        for (Book book : books) {
            if (book.getId() == id) return book;
        }
        return null;
    }
}
