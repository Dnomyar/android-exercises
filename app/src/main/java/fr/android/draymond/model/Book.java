package fr.android.draymond.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.LinkedList;
import java.util.List;


public class Book implements Parcelable {

    private String isbn;
    private String title;
    private String price;
    private String cover;
    private List<String> synopsis;

    public Book(String isbn, String title, String price, String cover, List<String> synopsis) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.cover = cover;
        this.synopsis = synopsis;
    }

    public Book(Parcel in) {
        String[] data = new String[5];

        in.readStringArray(data);
        this.isbn = in.readString();
        this.title = in.readString();
        this.price = in.readString();
        this.cover = in.readString();
        this.synopsis = new LinkedList<>();
        in.readStringList(this.synopsis);
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getCover() {
        return cover;
    }

    public List<String> getSynopsis() {
        return synopsis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return isbn.equals(book.isbn);

    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.isbn);
        dest.writeString(this.title);
        dest.writeString(this.price);
        dest.writeString(this.cover);
        dest.writeStringList(this.synopsis);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
