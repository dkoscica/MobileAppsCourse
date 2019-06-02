package hr.mobile.apps.course.lab10.screen.bookdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import hr.mobile.apps.course.lab10.R;
import hr.mobile.apps.course.lab10.model.Book;

public class BookDetailsFragment extends Fragment {

    private static final String BOOK_ID = "BOOK_ID";

    public static BookDetailsFragment newInstance(long bookId) {
        BookDetailsFragment fragment = new BookDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(BOOK_ID, bookId);
        fragment.setArguments(bundle);
        return fragment;
    }

    private BookDetailsViewModel bookDetailsViewModel;
    private long bookId;

    private BookDetailsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookDetailsViewModel = ViewModelProviders.of(this).get(BookDetailsViewModel.class);
        if (getArguments() != null) {
            bookId = getArguments().getLong(BOOK_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bookDetailsViewModel.getBookById(bookId).observe(this, book -> setupView(view, book));
    }

    private void setupView(View view, Book book) {
        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView publisherTextView = view.findViewById(R.id.publisherTextView);
        TextView publicationDateTextView = view.findViewById(R.id.publicationDateTextView);
        TextView isbnTextView = view.findViewById(R.id.isbnTextView);
        TextView descriptionTextView = view.findViewById(R.id.descriptionTextView);

        TextView pageNumberTextView = view.findViewById(R.id.pageNumberTextView);
        TextView ratingTextView = view.findViewById(R.id.ratingTextView);
        ImageView bookImageView = view.findViewById(R.id.bookImageView);
        FloatingActionButton addBookFab = view.findViewById(R.id.addBookFab);

        titleTextView.setText(book.getTitle());
        publisherTextView.setText(book.getPublisher().getName());
        publicationDateTextView.setText(book.getPublicationDate());
        isbnTextView.setText("ISBN " + book.getIsbn13());

        descriptionTextView.setText(book.getDescription());

        pageNumberTextView.setText(String.valueOf(book.getPages()));
        ratingTextView.setText(String.valueOf(book.getBookRate()));

        Glide.with(this)
                .load(book.getImage())
                .placeholder(R.drawable.logo)
                .into(bookImageView);

        addBookFab.setOnClickListener((v) -> {
            Snackbar.make(addBookFab,
                    String.format(getString(R.string.book_added_message), book.getTitle()), Snackbar.LENGTH_SHORT)
                    .show();

            bookDetailsViewModel.addBook(book);
        });
    }

}
