package com.code.moderntwettir.features.search

import android.arch.lifecycle.MutableLiveData
import com.code.moderntwettir.model.Status

/**
 * Created by engi2nee on 22.10.2018
 */
class TweetListItem {
    var id = 0
    private val tweetText = MutableLiveData<String>()
    private val tweetRetweets = MutableLiveData<String>()
    private val tweetImage = MutableLiveData<String>()

    fun bind(tweet: Status, position: Int) {
        id = position
        tweetText.value = tweet.text
        tweetRetweets.value = tweet.retweetCount.toString()
        tweetImage.value = tweet.entities?.media?.last()?.imageUrl ?: ""
    }

    fun getTweetText(): MutableLiveData<String> {
        return tweetText
    }

    fun getTweetRetweets(): MutableLiveData<String> {
        return tweetRetweets
    }

    fun getTweetImage(): MutableLiveData<String> {
        return tweetImage
    }

}