package fr.android.androidexercises.persistence;

import java.util.List;

import fr.android.androidexercises.model.Book;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HenriPotierService {

    @GET("books")
    Call<List<Book>> books();

}
