package hr.mobile.apps.course.lab10.screen.home.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import hr.mobile.apps.course.lab10.model.Book;
import hr.mobile.apps.course.lab10.repository.BookRepository;

public class BookRVViewModel extends ViewModel {

    private BookRepository bookRepository = BookRepository.getInstance();

    public LiveData<List<Book>> getBooks() {
        return bookRepository.getBooks();
    }

}
