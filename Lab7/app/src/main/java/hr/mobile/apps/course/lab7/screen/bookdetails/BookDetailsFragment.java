package hr.mobile.apps.course.lab7.screen.bookdetails;

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

import com.bumptech.glide.Glide;

import hr.mobile.apps.course.lab7.R;
import hr.mobile.apps.course.lab7.model.Book;
import hr.mobile.apps.course.lab7.repository.BookRepository;
import hr.mobile.apps.course.lab7.screen.home.BookRVFragment;
import hr.mobile.apps.course.lab7.util.FragmentUtil;

public class BookDetailsFragment extends Fragment {

    private static final String BOOK_ID = "BOOK_ID";

    public static BookDetailsFragment newInstance(long bookId) {
        BookDetailsFragment fragment = new BookDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(BOOK_ID, bookId);
        fragment.setArguments(bundle);
        return fragment;
    }

    private BookRepository bookRepository;
    private long bookId;

    private BookDetailsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookRepository = new BookRepository();
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
        setupCardView(view, bookRepository.findBookById(bookId));
    }

    private void setupCardView(View view, Book book) {
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
