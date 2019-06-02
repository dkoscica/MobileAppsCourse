package hr.mobile.apps.course.lab10.screen.home.fragment;

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

import hr.mobile.apps.course.lab10.R;
import hr.mobile.apps.course.lab10.screen.bookdetails.BookDetailsActivity;

public class BookRVFragment extends Fragment {

    private BookRVViewModel bookRVViewModel;
    private BookRecyclerViewAdapter bookRecyclerViewAdapter;

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
        setupRecyclerView(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        bookRVViewModel.getBooks().observe(this, books ->
                bookRecyclerViewAdapter.setList(books)
        );
    }

    /**
     * Private methods
     */
    private void setupRecyclerView(View fragmentView) {

        RecyclerView bookRecyclerView = fragmentView.findViewById(R.id.bookRecyclerView);

        // Use a LinearLayoutManager and set it to the RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        bookRecyclerView.setLayoutManager(layoutManager);

        // Create a new instance of your custom RecyclerViewAdapter and set it to the RecyclerView
        bookRecyclerViewAdapter = new BookRecyclerViewAdapter((view, position, book) ->
                BookDetailsActivity.start(getActivity(), book.getId())
        );
        bookRecyclerView.setAdapter(bookRecyclerViewAdapter);
    }

}
