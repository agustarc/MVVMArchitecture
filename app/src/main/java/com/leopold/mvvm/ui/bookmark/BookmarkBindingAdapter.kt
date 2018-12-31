package com.leopold.mvvm.ui.bookmark

import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.leopold.mvvm.data.db.entity.Bookmark
import com.leopold.mvvm.viewmodel.bookmark.BookmarkViewModel

/**
 * @author Leopold
 */
@BindingAdapter("viewModel")
fun setViewModel(view: RecyclerView, vm: BookmarkViewModel) {
    view.adapter?.run {
        if (this is BookmarkAdapter) this.setViewModel(vm)
    } ?: run {
        BookmarkAdapter().apply {
            view.adapter = this
            this.setViewModel(vm)
        }
    }
}

@BindingAdapter("bookmarks")
fun setBookmarks(view: RecyclerView, items: PagedList<Bookmark>?) {
    view.adapter?.run {
        if (this is BookmarkAdapter) this.submitList(items)
    } ?: run {
        BookmarkAdapter().apply {
            view.adapter = this
            this.submitList(items)
        }
    }
}