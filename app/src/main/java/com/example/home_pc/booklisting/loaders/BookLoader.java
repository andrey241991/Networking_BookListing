package com.example.home_pc.booklisting.loaders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import com.example.home_pc.booklisting.entity.Book;
import com.example.home_pc.booklisting.utils.QueryUtils;

import java.util.List;

import static com.example.home_pc.booklisting.MainActivity.URL;


public class BookLoader extends AsyncTaskLoader<List<Book>> {

    public BookLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public List<Book> loadInBackground() {
       return QueryUtils.fetchBooksData(URL);
    }
}
