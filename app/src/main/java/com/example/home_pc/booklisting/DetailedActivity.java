package com.example.home_pc.booklisting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home_pc.booklisting.entity.Book;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailedActivity extends AppCompatActivity {

    public static final String BOOK_KEY = "BOOK_KEY";
    @BindView(R.id.txt_title) TextView txtTitle;
    @BindView(R.id.txt_description) TextView txtDescription;
    @BindView(R.id.image) ImageView image;

    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        ButterKnife.bind(this);
        book = getIntent().getParcelableExtra(BOOK_KEY);
        initViews();
    }

    private void initViews() {
        txtTitle.setText(book.getTitle());
        txtDescription.setText(book.getDescription());
        Picasso.get().load(book.getBigPicture()).into(image);

    }

}
