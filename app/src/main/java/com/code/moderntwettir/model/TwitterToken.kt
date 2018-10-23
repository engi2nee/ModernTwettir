package com.code.moderntwettir.model

import com.squareup.moshi.Json

/**
 * Created by engi2nee on 22.10.2018
 */

data class TwitterToken(@field:Json(name = "access_token") val accessToken: String,
                        @field:Json(name = "token_type") val tokenType: String)