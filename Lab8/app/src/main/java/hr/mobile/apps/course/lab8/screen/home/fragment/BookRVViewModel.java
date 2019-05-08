package hr.mobile.apps.course.lab8.screen.home.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Random;

import hr.mobile.apps.course.lab8.model.Book;
import hr.mobile.apps.course.lab8.repository.BookRepository;

public class BookRVViewModel extends ViewModel {

    private BookRepository bookRepository = BookRepository.getInstance();

    public LiveData<List<Book>> getBooks() {
        return bookRepository.getBooks();
    }

    public void addBook(final Book book) {
        bookRepository.addBook(book);
    }

    public void addRandomBook() {
        if (getBooks().getValue() == null) {
            return;
        }
        int numberOfBooks = getBooks().getValue().size();
        int randomIndex = new Random().nextInt(numberOfBooks);
        Book randomBook = getBooks().getValue().get(randomIndex);
        bookRepository.addBook(randomBook);
    }
}
