package com.code.moderntwettir.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


/**
 * Created by engi2nee on 22.10.2018
 */

@Parcelize
data class Media(val id: Long?,
                 @field:Json(name = "media_url") var imageUrl: String?,
                 val type: String?) : Parcelable