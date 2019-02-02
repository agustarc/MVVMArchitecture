package com.leopold.mvvm.ui

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Leopold
 */
abstract class BindingViewHolder<out T> (view: View): RecyclerView.ViewHolder(view) where T : ViewDataBinding {
    val binding: T = DataBindingUtil.bind(view)!!
}
