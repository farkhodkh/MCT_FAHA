package com.example.mct_faha.network;

import android.database.Observable;
import com.example.mct_faha.network.interfaces.ItunesSearchResult;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ItunesApiService {
    //https://itunes.apple.com/search?term=jim+jones
    @GET("search")
    Observable<ItunesSearchResult> search(@Query("term") String term);

    class Factory {

        public static ItunesApiService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.github.com/")
                    .build();

            return retrofit.create(ItunesApiService.class);
        }
    }
}
