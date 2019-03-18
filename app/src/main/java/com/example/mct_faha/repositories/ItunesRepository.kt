package com.example.mct_faha.repositories

import android.database.Observable
import android.os.Handler
import com.example.mct_faha.network.ItunesApiService
import com.example.mct_faha.network.interfaces.ItunesSearchResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ItunesRepository {
    fun getRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback) {
        var arrayList = ArrayList<Repository>()

        val apiService = ItunesApiService.create()
        var result: Observable<ItunesSearchResult> = apiService.search("jim+jones")

        arrayList.add(
            Repository(
                "track",
                "Jack Johnson",
                "Better Together",
                "https://is1-ssl.mzstatic.com/image/thumb/Music2/v4/a2/66/32/a2663205-663c-8301-eec7-57937c2d0878/source/100x100bb.jpg"
            )
        )
        arrayList.add(
            Repository(
                "track",
                "Jack Johnson",
                "When I Look Up",
                "https://is2-ssl.mzstatic.com/image/thumb/Music/v4/7d/26/43/7d2643d8-e66f-7bb0-0e76-26b36531753f/source/100x100bb.jpg"
            )
        )
        arrayList.add(
            Repository(
                "track",
                "Jack Johnson",
                "No Good With Faces",
                "https://is1-ssl.mzstatic.com/image/thumb/Music2/v4/a2/66/32/a2663205-663c-8301-eec7-57937c2d0878/source/100x100bb.jpg"
            )
        )

        Handler().postDelayed({ onRepositoryReadyCallback.onDataReady(arrayList) }, 2000)
    }
}

interface OnRepositoryReadyCallback {
    fun onDataReady(data: ArrayList<Repository>)
}