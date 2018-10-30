package com.example.home_pc.booklisting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.example.home_pc.booklisting.adapter.BooksAdapter;
import com.example.home_pc.booklisting.entity.Book;
import com.example.home_pc.booklisting.loaders.BookLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.home_pc.booklisting.DetailedActivity.BOOK_KEY;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>>, OnItemClick {

    private static final int BOOK_LOADER_ID = 0 ;
    public static String URL;
    private static final String BASIC_URL = "https://www.googleapis.com/books/v1/volumes?q=";

    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.ed_search) EditText edSearch;
    @BindView(R.id.btn_search) Button btnSearch;

    private BooksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnSearch.setOnClickListener(v -> {
            String searchedTitle = edSearch.getText().toString();
            URL = BASIC_URL + searchedTitle;
            getSupportLoaderManager().initLoader(BOOK_LOADER_ID, null, MainActivity.this).forceLoad();
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

    }

    @NonNull
    @Override
    public Loader<List<Book>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new BookLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Book>> loader, List<Book> books) {
        if (books != null && !books.isEmpty()) {
            updateUi(books);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Book>> loader) {
    }

    private void updateUi(List<Book> books) {
        adapter = new BooksAdapter(books);
        adapter.setOnItemClick(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Book book) {
        Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
        intent.putExtra(BOOK_KEY, book);
        startActivity(intent);
    }
}
