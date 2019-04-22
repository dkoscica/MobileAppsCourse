package hr.mobile.apps.course.lab6.screen.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hr.mobile.apps.course.lab6.R;
import hr.mobile.apps.course.lab6.model.Book;
import hr.mobile.apps.course.lab6.repository.BookRepository;
import hr.mobile.apps.course.lab6.screen.bookdetails.BookDetailsActivity;

public class BookRVFragment extends Fragment {

    private BookRepository bookRepository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookRepository = new BookRepository();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rv_book, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView(view, bookRepository.getBooks());
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
        RecyclerView.Adapter adapter = new BookRecyclerViewAdapter(books, (view, position, book) -> openBookDetails(book));
        bookRecyclerView.setAdapter(adapter);
    }

    private void openBookDetails(Book book) {
        Intent intent = new Intent(getActivity(), BookDetailsActivity.class);
        intent.putExtra(BookDetailsActivity.BOOK_ID, book.getId());
        startActivity(intent);
    }
}
