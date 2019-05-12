package hr.mobile.apps.course.lab8.screen.bookdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;

import hr.mobile.apps.course.lab8.R;
import hr.mobile.apps.course.lab8.model.Book;
import hr.mobile.apps.course.lab8.screen.home.fragment.BookRVFragment;
import hr.mobile.apps.course.lab8.util.FragmentUtil;

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
        CardView bookRecyclerViewItem = view.findViewById(R.id.bookRecyclerViewItem);
        bookRecyclerViewItem.setOnClickListener(v -> replaceWithBookRVFragment());

        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView authorTextView = view.findViewById(R.id.authorTextView);
        TextView yearTextView = view.findViewById(R.id.yearTextView);
        TextView costTextView = view.findViewById(R.id.costTextView);
        ImageView bookImageView = view.findViewById(R.id.bookImageView);

        titleTextView.setText(book.getTitle());
        authorTextView.setText(book.getAuthor());
        yearTextView.setText(String.valueOf(book.getYear()));
        costTextView.setText("$" + book.getCost());

        Glide.with(this)
                .load(book.getImageUrl())
                .placeholder(R.drawable.logo)
                .into(bookImageView);
    }

    private void replaceWithBookRVFragment() {
        FragmentUtil.replaceFragment(getFragmentManager(), R.id.fragmentContainer, new BookRVFragment());
    }

}
