package hr.mobile.apps.course.lab7.screen.bookdetails;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import hr.mobile.apps.course.lab7.R;
import hr.mobile.apps.course.lab7.util.FragmentUtil;

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

        long bookId = getIntent().getExtras().getLong(BOOK_ID);
        FragmentUtil.attachFragment(getSupportFragmentManager(), R.id.fragmentContainer, BookDetailsFragment.newInstance(bookId));
    }
}
