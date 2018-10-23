package com.code.moderntwettir.utils

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Created by engi2nee on 22.10.2018
 */

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("liveDataVisibility")
    fun setLiveDataVisibility(view: View, visibility: MutableLiveData<Int>?) {
        val parentActivity: AppCompatActivity? = view.getParentActivity()
        if (parentActivity != null && visibility != null) {
            visibility.observe(parentActivity, Observer { value -> view.visibility = value ?: View.VISIBLE })
        }
    }

    @JvmStatic
    @BindingAdapter("liveDataSrcUrl")
    fun setImageLiveUrl(imageView: ImageView, url: MutableLiveData<String>?) {
        val parentActivity: AppCompatActivity? = imageView.getParentActivity()
        if (parentActivity != null && url != null) {
            url.observe(parentActivity, Observer { value ->
                if (value.isNullOrEmpty()) {
                    imageView.visibility = View.GONE
                    Glide.with(imageView.context).clear(imageView)
                } else {
                    imageView.visibility = View.VISIBLE
                    Glide.with(imageView.context).load(value).apply(RequestOptions().fitCenter()).into(imageView)
                }
            })
        }

    }

    @JvmStatic
    @BindingAdapter("srcUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        val parentActivity: AppCompatActivity? = imageView.getParentActivity()
        if (parentActivity != null && !url.isNullOrEmpty()) {
            imageView.visibility = View.VISIBLE
            Glide.with(imageView.context).load(url).apply(RequestOptions().fitCenter()).into(imageView)
        } else {
            imageView.visibility = View.INVISIBLE
        }
    }


    @JvmStatic
    @BindingAdapter("liveDataText")
    fun setLiveDataText(view: TextView, text: MutableLiveData<String>?) {
        val parentActivity: AppCompatActivity? = view.getParentActivity()
        if (parentActivity != null && text != null) {
            text.observe(parentActivity, Observer { value -> view.text = value ?: "" })
        }
    }

}