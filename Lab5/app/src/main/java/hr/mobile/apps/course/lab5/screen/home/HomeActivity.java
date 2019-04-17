package hr.mobile.apps.course.lab5.screen.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hr.mobile.apps.course.lab5.R;
import hr.mobile.apps.course.lab5.model.Book;
import hr.mobile.apps.course.lab5.repository.BookRepository;
import hr.mobile.apps.course.lab5.screen.bookdetails.BookDetailsActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BookRepository bookRepository = new BookRepository();
        setupRecyclerView(bookRepository.getBooks());
    }

    /**
     * Private methods
     */
    private void setupRecyclerView(List<Book> books) {

        RecyclerView bookRecyclerView = findViewById(R.id.bookRecyclerView);

        // Use a LinearLayoutManager and set it to the RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        bookRecyclerView.setLayoutManager(layoutManager);

        // Create a new instance of your custom RecyclerViewAdapter and set it to the RecyclerView
        RecyclerView.Adapter adapter = new BookRecyclerViewAdapter(books, (view, position, book) -> openBookDetails(book));
        bookRecyclerView.setAdapter(adapter);
    }

    private void openBookDetails(Book book) {
        Intent intent = new Intent(this, BookDetailsActivity.class);
        intent.putExtra(BookDetailsActivity.BOOK_ID, book);
        startActivity(intent);
    }
}
