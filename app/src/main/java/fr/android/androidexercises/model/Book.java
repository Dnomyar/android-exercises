package fr.android.androidexercises.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    private String isbn;
    private String title;
    private String price;
    private String cover;
    private String description;

    public Book(String isbn, String title, String price, String cover, String description) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.cover = cover;
        this.description = description;
    }

    public Book(Parcel in) {
        String[] data = new String[5];

        in.readStringArray(data);
        this.isbn = data[0];
        this.title = data[1];
        this.price = data[2];
        this.cover = data[3];
        this.description = data[4];
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

    public String getDescription() {
        return description;
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
        dest.writeStringArray(new String[] {
                this.isbn,
                this.title,
                this.price,
                this.cover,
                this.description
        });
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
