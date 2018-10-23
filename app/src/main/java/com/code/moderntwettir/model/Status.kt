package com.code.moderntwettir.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by engi2nee on 22.10.2018
 */

@Parcelize
data class Status(@field:Json(name = "id_str") val id: String,
                  val text: String, val entities: Entities?,
                  @field:Json(name = "extended_entities") val extendedEntities: Entities? = null,
                  val user: User?,
                  @field:Json(name = "retweet_count") val retweetCount: Int) : Parcelable
