package com.example.mct_faha.repositories

import android.databinding.BaseObservable

class Repository(var wrapperType: String?, var artistName: String?, var trackName: String?, var trackViewUrl: String?) :
    BaseObservable() {
}