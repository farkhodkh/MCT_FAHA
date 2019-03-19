package com.example.mct_faha.repositories

import android.os.Handler
import com.example.mct_faha.network.ItunesApi
import com.example.mct_faha.network.interfaces.ItunesSearchResult
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.*

class ItunesRepository {

    fun getRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback, term: String) {
        var arrayList = ArrayList<Repository>()
        val apiService = ItunesApi.create()
//        val term = "jim+jones"

        try {
            val result: Observable<ItunesSearchResult> = apiService.search(term)
            result.subscribeOn(Schedulers.io())
                .subscribe(
                    { items ->
                        for (item in items.results) {
                            arrayList.add(
                                Repository(
                                    item.wrapperType,
                                    item.artistName,
                                    item.trackName,
                                    item.artworkUrl100
                                )
                            )
                        }
                    },
                    { error ->
                        print(error)
                    }
                )
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
        }

//        Handler().postDelayed({ onRepositoryReadyCallback.onDataReady(arrayList) }, 2000)
        onRepositoryReadyCallback.onDataReady(arrayList)
    }
}

interface OnRepositoryReadyCallback {
    fun onDataReady(data: ArrayList<Repository>)
}