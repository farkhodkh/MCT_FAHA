package com.example.mct_faha.repositories

import android.databinding.BaseObservable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Repository(var wrapperType: String?, var artistName: String?, var trackName: String?, var trackViewUrl: String?) : BaseObservable()