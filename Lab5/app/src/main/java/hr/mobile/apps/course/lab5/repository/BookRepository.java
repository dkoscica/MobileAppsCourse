package hr.mobile.apps.course.lab5.repository;

import java.util.ArrayList;
import java.util.List;

import hr.mobile.apps.course.lab5.model.Book;

public class BookRepository {

    private List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
        books.add(new Book("Head First Android Development", "Dawn Griffiths ", 2017, 45.0));
        books.add(new Book("Android Studio 3.0 Development Essentials - Android 8 Edition", "Neil Smyth", 2017, 50.0));
        books.add(new Book("Android Programming: The Big Nerd Ranch Guide (3rd Edition)", "Bill Phillips, Chris Stewart, and Kristin Marsicano", 2017, 55.0));
    }

    public List<Book> getBooks() {
        return books;
    }
}
