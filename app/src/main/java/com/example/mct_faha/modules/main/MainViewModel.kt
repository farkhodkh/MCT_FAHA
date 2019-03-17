package com.example.mct_faha.modules.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.mct_faha.repositories.ItunesRepository
import com.example.mct_faha.repositories.OnRepositoryReadyCallback
import com.example.mct_faha.repositories.Repository

class MainViewModel: ViewModel() {
    var repoModel: ItunesRepository =
        ItunesRepository()

    val isLoading = ObservableField(false)

    var repositories = MutableLiveData<ArrayList<Repository>>()

    fun loadRepositories() {
        isLoading.set(true)
        repoModel.getRepositories(object : OnRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }
        })
    }

}