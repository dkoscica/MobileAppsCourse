package hr.mobile.apps.course.lab5.screen.bookdetails;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import hr.mobile.apps.course.lab5.R;
import hr.mobile.apps.course.lab5.model.Book;

public class BookDetailsActivity extends AppCompatActivity {

    public static final String BOOK_ID = "BOOK_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }

        Book book = (Book) getIntent().getExtras().getSerializable(BOOK_ID);
        if (book != null) {
            setupCardView(book);
        }
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
        costTextView.setText("$" + book.getCost());
    }
}
