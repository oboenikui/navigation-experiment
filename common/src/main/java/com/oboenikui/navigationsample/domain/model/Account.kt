package com.oboenikui.navigationsample.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Account(
    val name: String,
    val themeColor: Int
) : Parcelable