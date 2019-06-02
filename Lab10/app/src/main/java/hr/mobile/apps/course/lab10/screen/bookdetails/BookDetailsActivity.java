package hr.mobile.apps.course.lab10.screen.bookdetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import hr.mobile.apps.course.lab10.R;
import hr.mobile.apps.course.lab10.util.FragmentUtil;

public class BookDetailsActivity extends AppCompatActivity {

    public static final String BOOK_ID = "BOOK_ID";

    public static void start(Context context, long id) {
        Intent intent = new Intent(context, BookDetailsActivity.class);
        intent.putExtra(BookDetailsActivity.BOOK_ID, id);
        context.startActivity(intent);
    }

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
