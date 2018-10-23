package com.code.moderntwettir.features.search

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import com.code.moderntwettir.R
import com.code.moderntwettir.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var viewModel: SearchViewModel
    private lateinit var binding: ActivityMainBinding
    var searchTextChangedJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.hide()

        binding.searchViewMainActivity.setOnQueryTextListener(this)

        viewModel = ViewModelProviders.of(this@MainActivity).get(SearchViewModel::class.java)
        binding.viewModel = viewModel
        if (viewModel.authorizationToken.value.isNullOrEmpty())
            viewModel.getToken()
    }


    override fun onQueryTextSubmit(searchedText: String?): Boolean {
        search(searchedText ?: "")
        return true
    }

    override fun onQueryTextChange(searchedText: String?): Boolean {
        searchTextChangedJob?.cancel()
        if (!viewModel.authorizationToken.value.isNullOrEmpty())
            searchTextChangedJob = GlobalScope.launch(Dispatchers.Main) {
                delay(300)
                viewModel.lastSearchedText = searchedText ?: ""
                search(searchedText ?: "")
            }
        return true
    }

    fun search(text: String) {
        viewModel.searchTweets(authorization = viewModel.authorizationToken.value!!, searchedText = text, maxId = 0, sinceId = 0)
    }

    override fun onResume() {
        super.onResume()
        if (!viewModel.lastSearchedText.isEmpty())
            search(viewModel.lastSearchedText)

    }
}
