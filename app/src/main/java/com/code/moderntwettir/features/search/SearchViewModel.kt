package com.code.moderntwettir.features.search

import android.arch.lifecycle.MutableLiveData
import android.util.Base64
import android.util.Log
import android.view.View
import com.code.moderntwettir.base.BaseViewModel
import com.code.moderntwettir.model.Status
import com.code.moderntwettir.network.TwitterApi
import com.code.moderntwettir.utils.BEARER_TOKEN
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by engi2nee on 22.10.2018
 */

@Singleton
class SearchViewModel : BaseViewModel() {

    @Inject
    lateinit var twitterApi: TwitterApi
    var lastSearchedText = ""

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val tweetsList: MutableLiveData<List<Status>> = MutableLiveData()
    val authorizationToken: MutableLiveData<String> = MutableLiveData()

    fun getToken() {
        GlobalScope.launch(Dispatchers.Main) {
            loadingVisibility.value = View.VISIBLE
            try {
                val request = twitterApi.getToken("Basic ${getBase64(BEARER_TOKEN)}",
                        "client_credentials")
                val response = request.await()
                if (response.isSuccessful) {
                    loadingVisibility.value = View.GONE
                    authorizationToken.value = "Bearer ${response.body()?.accessToken}"
                    Log.d("Api Status", "Token successfully received")
                } else {
                    loadingVisibility.value = View.GONE
                    Log.e("Api Error", "${response.errorBody()}")
                }
            } catch (exception: Exception) {
                loadingVisibility.value = View.GONE
                Log.e("TAG", exception.message)
            }
        }

    }

    fun searchTweets(authorization: String, searchedText: String, maxId: Long, sinceId: Long) {
        GlobalScope.launch(Dispatchers.Main) {
            loadingVisibility.value = View.VISIBLE
            try {
                val request = twitterApi.searchTweets(authorization, searchedText, maxId, sinceId)

                val response = request.await()
                if (response.isSuccessful) {
                    loadingVisibility.value = View.GONE
                    tweetsList.value = response.body()?.statuses
                    Log.d("Api Status", "Data successfully received")
                } else {
                    loadingVisibility.value = View.GONE
                    Log.e("Api Error", "${response.errorBody()}")

                }
            } catch (exception: Exception) {
                loadingVisibility.value = View.GONE
                Log.e("TAG", exception.message)
            }


        }
    }

    private fun getBase64(value: String): String {
        return Base64.encodeToString(value.toByteArray(Charsets.UTF_8), Base64.NO_WRAP).toString()
    }

}