package fr.android.draymond.persistence;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by damien on 19/11/2017.
 */
public class HenriPotierServiceFactory {

    public HenriPotierService create(){
        return new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(HenriPotierService.class);
    }

}
