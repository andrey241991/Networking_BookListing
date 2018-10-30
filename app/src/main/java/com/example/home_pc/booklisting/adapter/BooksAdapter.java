package com.example.home_pc.booklisting.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home_pc.booklisting.OnItemClick;
import com.example.home_pc.booklisting.R;
import com.example.home_pc.booklisting.entity.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private List<Book> books;
    private OnItemClick onItemClick;

    public BooksAdapter(List<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_book_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(books.get(position));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_title) TextView txtTitle;
        @BindView(R.id.txt_author) TextView txtAuthor;
        @BindView(R.id.img_image) ImageView image;
        @BindView(R.id.rootView) CardView rootView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            rootView.setOnClickListener(v -> onItemClick.onItemClick(books.get(getAdapterPosition())));
        }

        public void bind(Book book) {
            txtTitle.setText(book.getTitle());
            txtAuthor.setText(setAuthors(book));
            Picasso.get().load(book.getSmallPicture()).into(image);
        }

        private String setAuthors(Book book) {
            String[] authors = book.getAuthors();
            StringBuilder builder = new StringBuilder();
            for(int i=0; i<authors.length; i++){
                builder.append(authors[i]);
                builder.append(" ");
            }
            return builder.toString();
        }

    }
}


