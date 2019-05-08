package hr.mobile.apps.course.lab8.screen.bookdetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import hr.mobile.apps.course.lab8.model.Book;
import hr.mobile.apps.course.lab8.repository.BookRepository;

public class BookDetailsViewModel extends ViewModel {

    private BookRepository bookRepository = BookRepository.getInstance();

    public MutableLiveData<Book> getBookById(long id) {
        Book book = bookRepository.findBookById(id);
        MutableLiveData<Book> bookLiveData = new MutableLiveData<>();
        bookLiveData.setValue(book);
        return bookLiveData;
    }
}
