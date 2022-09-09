package com.felix.gorenganku.ui.home

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainParcelable(val image: String, val rating: String, val title: String, val description: String?, val ingredient: List<String>?) :
    Parcelable