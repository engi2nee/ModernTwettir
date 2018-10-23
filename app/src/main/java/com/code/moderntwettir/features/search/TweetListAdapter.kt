package com.code.moderntwettir.features.search

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.code.moderntwettir.R
import com.code.moderntwettir.databinding.ListItemTweetBinding
import com.code.moderntwettir.model.Status


/**
 * Created by engi2nee on 22.10.2018
 */

class TweetListAdapter : RecyclerView.Adapter<TweetListAdapter.ViewHolder>() {

    private lateinit var tweetsList: List<Status>
    var onItemClick: ((TweetListItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetListAdapter.ViewHolder {
        val binding: ListItemTweetBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_item_tweet, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TweetListAdapter.ViewHolder, position: Int) {
        holder.bind(tweetsList[position])
    }

    override fun getItemCount(): Int {
        return if (::tweetsList.isInitialized) tweetsList.size else 0
    }

    fun loadTweets(tweetsList: List<Status>) {
        this.tweetsList = tweetsList
        notifyDataSetChanged()
    }


    inner class ViewHolder(private val binding: ListItemTweetBinding) : RecyclerView.ViewHolder(binding.root) {
        private val itemViewModel = TweetListItem()

        init {
            itemView.setOnClickListener {
                val itemViewModel = TweetListItem()
                itemViewModel.bind(tweetsList[adapterPosition], adapterPosition)
                onItemClick?.invoke(itemViewModel)
            }
        }

        fun bind(tweet: Status) {
            itemViewModel.bind(tweet, adapterPosition)
            binding.item = itemViewModel
        }
    }
}