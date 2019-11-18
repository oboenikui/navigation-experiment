package com.oboenikui.navigationsample.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Trend(
    val name: String,
    val contents: List<Content>
) : Parcelable