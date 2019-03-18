package com.example.mct_faha.network

import com.example.mct_faha.network.interfaces.ItunesSearchResult
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ItunesApi {
    @GET("search")
    fun search(@Query("term") query: String): Observable<ItunesSearchResult>
    //https://itunes.apple.com/search?term=jim+jones

    companion object Factory {
        fun create(): ItunesApi {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://itunes.apple.com")
                .build()

            return retrofit.create(ItunesApi::class.java);
        }
    }
}