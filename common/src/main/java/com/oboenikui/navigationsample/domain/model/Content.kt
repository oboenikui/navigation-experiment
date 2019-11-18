package com.oboenikui.navigationsample.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.ZonedDateTime

@Parcelize
data class Content(
    val body: String,
    val url: String,
    val account: Account
) : Parcelable