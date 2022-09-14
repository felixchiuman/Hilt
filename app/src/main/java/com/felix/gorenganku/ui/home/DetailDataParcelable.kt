package com.felix.gorenganku.ui.home

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailDataParcelable(val image: List<String>, val rating: String, val title: String, val description: String?, val ingredient: List<String>?) :
    Parcelable