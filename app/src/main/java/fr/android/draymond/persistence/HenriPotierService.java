package fr.android.draymond.persistence;

import java.util.List;

import fr.android.draymond.model.Book;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HenriPotierService {

    @GET("books")
    Call<List<Book>> books();

}
