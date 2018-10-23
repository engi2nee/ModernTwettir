package com.code.moderntwettir.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by engi2nee on 22.10.2018
 */

@Parcelize
data class TweetResponse(val statuses: List<Status>?, @field:Json(name = "search_metadata") val searchMetadata: SearchMetadata) : Parcelable