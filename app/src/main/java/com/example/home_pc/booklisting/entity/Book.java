package com.example.home_pc.booklisting.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    private String title;
    private String [] authors;
    private String description;
    private String smallPicture;
    private String bigPicture;

    protected Book(Parcel in) {
        title = in.readString();
        authors = in.createStringArray();
        description = in.readString();
        smallPicture = in.readString();
        bigPicture = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String getDescription() {
        return description;
    }

    public String getSmallPicture() {
        return smallPicture;
    }

    public String getBigPicture() {
        return bigPicture;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSmallPicture(String smallPicture) {
        this.smallPicture = smallPicture;
    }

    public void setBigPicture(String bigPicture) {
        this.bigPicture = bigPicture;
    }

    public Book(String title, String[] authors, String description, String smallPicture, String bigPicture) {
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.smallPicture = smallPicture;
        this.bigPicture = bigPicture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeStringArray(authors);
        dest.writeString(description);
        dest.writeString(smallPicture);
        dest.writeString(bigPicture);
    }
}
