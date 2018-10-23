package com.code.moderntwettir.features.search


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.code.moderntwettir.R
import com.code.moderntwettir.databinding.FragmentResultsBinding
import com.code.moderntwettir.features.detail.DetailsActivity


class ResultsFragment : Fragment() {

    lateinit var binding: FragmentResultsBinding
    lateinit var viewModel: SearchViewModel

    var tweetListAdapter = TweetListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_results, container, false)
        viewModel = ViewModelProviders.of(activity!!).get(SearchViewModel::class.java)
        binding.recyclerviewResultsFragmentsTweetsList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.recyclerviewResultsFragmentsTweetsList.adapter = tweetListAdapter

        tweetListAdapter.onItemClick = { tweet ->
            DetailsActivity.start(activity!!, viewModel.tweetsList.value!![tweet.id])
        }


        viewModel.tweetsList.observe(this, Observer {
            if (it != null) tweetListAdapter.loadTweets(it)
        })
        return binding.root
    }


}
