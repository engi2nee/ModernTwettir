package com.code.moderntwettir.features.detail

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.code.moderntwettir.R
import com.code.moderntwettir.databinding.ActivityDetailsBinding
import com.code.moderntwettir.features.search.SearchViewModel
import com.code.moderntwettir.model.Status


class DetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: SearchViewModel
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        viewModel = ViewModelProviders.of(this@DetailsActivity).get(SearchViewModel::class.java)
        val selectedTweet = intent?.extras?.getParcelable("selected_tweet") as? Status

        binding.text = selectedTweet?.text ?: ""
        binding.url = selectedTweet?.entities?.media?.last()?.imageUrl ?: ""
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                super.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {

        fun start(context: Context, status: Status) {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("selected_tweet", status)
            context.startActivity(intent)
        }
    }
}
