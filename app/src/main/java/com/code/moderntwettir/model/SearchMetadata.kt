package com.code.moderntwettir.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by engi2nee on 22.10.2018
 */

@Parcelize
data class SearchMetadata(
        @field:Json(name = "max_id_str") var maxIdStr: String,
        @field:Json(name = "next_results") var nextResults: String?,
        @field:Json(name = "query") var query: String,
        @field:Json(name = "refresh_url") var refreshUrl: String,
        @field:Json(name = "count") var count: Int) : Parcelable