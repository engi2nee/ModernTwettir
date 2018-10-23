package com.code.moderntwettir.network

import android.arch.paging.ItemKeyedDataSource
import com.code.moderntwettir.model.Status

/**
 * Created by engi2nee on 22.10.2018
 */

//TODO implement paging library

class TweetDataSource : ItemKeyedDataSource<String, Status>() {
    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<Status>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<Status>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<Status>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getKey(item: Status): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
