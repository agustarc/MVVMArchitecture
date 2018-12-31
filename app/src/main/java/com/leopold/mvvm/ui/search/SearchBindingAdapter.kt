package com.leopold.mvvm.ui.search

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leopold.mvvm.data.remote.domain.Repository
import com.leopold.mvvm.viewmodel.search.SearchViewModel

/**
 * @author Leopold
 */
@BindingAdapter("viewModel")
fun setViewModel(view: RecyclerView, vm: SearchViewModel) {
    view.adapter?.run {
        if (this is RepositoryAdapter) this.setViewModel(vm)
    } ?: run {
        RepositoryAdapter().apply {
            view.adapter = this
            this.setViewModel(vm)
        }
    }
}

@BindingAdapter("repositories")
fun setRepositories(view: RecyclerView, items: List<Repository>) {
    view.adapter?.run {
        if (this is RepositoryAdapter) {
            this.items = items
            this.notifyDataSetChanged()
        }
    } ?: run {
        RepositoryAdapter(items).apply { view.adapter = this }
    }
}