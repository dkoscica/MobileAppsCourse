package hr.mobile.apps.course.lab9.screen.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hr.mobile.apps.course.lab9.R;
import hr.mobile.apps.course.lab9.model.Book;
import hr.mobile.apps.course.lab9.screen.bookdetails.BookDetailsActivity;

public class BookRVFragment extends Fragment {

    private BookRVViewModel bookRVViewModel;
    private RecyclerView.Adapter bookRecyclerViewAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookRVViewModel = ViewModelProviders.of(this).get(BookRVViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rv_book, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bookRVViewModel.getBooks().observe(this, books ->
                setupRecyclerView(view, books)
        );
    }

    /**
     * Private methods
     */

    private void setupRecyclerView(View fragmentView, List<Book> books) {

        RecyclerView bookRecyclerView = fragmentView.findViewById(R.id.bookRecyclerView);

        // Use a LinearLayoutManager and set it to the RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        bookRecyclerView.setLayoutManager(layoutManager);

        // Create a new instance of your custom RecyclerViewAdapter and set it to the RecyclerView
        bookRecyclerViewAdapter = new BookRecyclerViewAdapter(books, (view, position, book) -> openBookDetails(book));
        bookRecyclerView.setAdapter(bookRecyclerViewAdapter);
    }

    private void openBookDetails(Book book) {
        Intent intent = new Intent(getActivity(), BookDetailsActivity.class);
        intent.putExtra(BookDetailsActivity.BOOK_ID, book.getId());
        startActivity(intent);
    }

}
