package hr.mobile.apps.course.lab4.screen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import hr.mobile.apps.course.lab4.R;
import hr.mobile.apps.course.lab4.model.Book;
import hr.mobile.apps.course.lab4.repository.BookRepository;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BookRepository bookRepository = new BookRepository();
        Book firstBook = bookRepository.getBooks().get(0);

        setupCardView(firstBook);
    }

    private void setupCardView(Book book) {
        CardView bookRecyclerViewItem = findViewById(R.id.bookRecyclerViewItem);
        bookRecyclerViewItem.setOnClickListener(v -> finish());

        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView authorTextView = findViewById(R.id.authorTextView);
        TextView yearTextView = findViewById(R.id.yearTextView);
        TextView costTextView = findViewById(R.id.costTextView);

        titleTextView.setText(book.getTitle());
        authorTextView.setText(book.getAuthor());
        yearTextView.setText(String.valueOf(book.getYear()));
        costTextView.setText(String.valueOf("$" + book.getCost()));
    }

    private void openBookDetails(Book book) {

    }
}
