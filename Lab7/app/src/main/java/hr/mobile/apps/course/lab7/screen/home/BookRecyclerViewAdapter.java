package hr.mobile.apps.course.lab7.screen.home;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import hr.mobile.apps.course.lab7.R;
import hr.mobile.apps.course.lab7.model.Book;

public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookRecyclerViewAdapter.BookViewHolder> {

    public interface RecyclerViewEventListener {
        void onItemClick(View view, int position, Book book);
    }

    class BookViewHolder extends RecyclerView.ViewHolder {

        View itemView;
        TextView titleTextView;
        TextView authorTextView;
        TextView yearTextView;
        TextView costTextView;
        ImageView bookImageView;

        BookViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.titleTextView = itemView.findViewById(R.id.titleTextView);
            this.authorTextView = itemView.findViewById(R.id.authorTextView);
            this.yearTextView = itemView.findViewById(R.id.yearTextView);
            this.costTextView = itemView.findViewById(R.id.costTextView);
            this.bookImageView = itemView.findViewById(R.id.bookImageView);
        }
    }

    private List<Book> books;
    private RecyclerViewEventListener listener;

    BookRecyclerViewAdapter(List<Book> books, RecyclerViewEventListener listener) {
        this.books = books;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BookRecyclerViewAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookRecyclerViewAdapter.BookViewHolder holder, int position) {
        Book book = books.get(position);
        holder.itemView.setOnClickListener(view -> listener.onItemClick(holder.itemView, position, book));
        holder.titleTextView.setText(book.getTitle());
        holder.authorTextView.setText(book.getAuthor());
        holder.yearTextView.setText(String.valueOf(book.getYear()));
        holder.costTextView.setText("$" + book.getCost());
        Glide.with(holder.itemView.getContext())
                .load(book.getImageUrl())
                .placeholder(R.drawable.logo)
                .into(holder.bookImageView);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

}
