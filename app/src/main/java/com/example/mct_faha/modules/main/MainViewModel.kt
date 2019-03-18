package com.example.mct_faha.modules.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.mct_faha.repositories.ItunesRepository
import com.example.mct_faha.repositories.OnRepositoryReadyCallback
import com.example.mct_faha.repositories.Repository


class MainViewModel : ViewModel() {
    var repoModel: ItunesRepository =
        ItunesRepository()

    val isLoading = ObservableField(false)

    var repositories = MutableLiveData<ArrayList<Repository>>()

    fun loadRepositories() {
        val term = "jim+jones"
        isLoading.set(true)
        repoModel.getRepositories(object : OnRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }
        }, term)
    }

//    fun EditText.onTextChanged(action: (CharSequence) -> Unit) {
//        addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(string: Editable?) = Unit
//            override fun beforeTextChanged(string: CharSequence?, start: Int, count: Int, after: Int) = Unit
//            override fun onTextChanged(string: CharSequence?, start: Int, before: Int, count: Int) {
//                action(string ?: "")
//            }
//        })
//    }
//
//    fun EditText.clearOnTextChangedListener() {
//        onTextChanged {}
//    }
//
//    @BindingAdapter("textLengthWarning")
//    fun textLengthWarning(view: EditText, textLengthWarningEnabled: Boolean) {
//        if (!textLengthWarningEnabled) {
//            view.clearOnTextChangedListener()
//            return
//        }
//
//        view.onTextChanged {
//            if (view.text.length > 10) {
//                view.setTextColor(view.context.getColor(R.color.abc_btn_colored_text_material))
//            } else {
//                view.setTextColor(view.context.getColor(R.color.abc_background_cache_hint_selector_material_dark))
//            }
//        }
//    }
}